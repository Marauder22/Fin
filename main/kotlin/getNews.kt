import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

suspend fun getNews(count: Int = 100): List<News> {
    val client = HttpClient()
    val response: HttpResponse = client.get("https://api.kudago.com/v1/news/?page=1&page_size=$count&order_by=published_at&location=spb")
    val jsonString = response.bodyAsText()
    val newsList = Json.decodeFromString<List<News>>(jsonString) // Десериализация JSON в список новостей
    client.close()
    return newsList
}