import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonDecodingException

@Serializable
data class News(
    val id: Int,
    val title: String,
    val publishedAt: String,
)

object HttpClientProvider {
    val client = HttpClient()
}
suspend fun getNews(count: Int = 100): Result<List<News>> {
    return try {
        val response: HttpResponse = HttpClientProvider.client.get("https://api.kudago.com/v1/news/?page=1&page_size=$count&order_by=published_at&location=spb") {
            headers {
                append(HttpHeaders.Accept, ContentType.Application.Json.toString())
            }
        }
        if (response.status.isSuccess()) {
            val jsonString = response.bodyAsText()
            val newsList = Json.decodeFromString<List<News>>(jsonString)
            Result.success(newsList)
        } else {
            Result.failure(Exception("Ошибка HTTP: ${response.status}"))
        }
    } catch (e: Exception) {
        Result.failure(e)
    }
}
