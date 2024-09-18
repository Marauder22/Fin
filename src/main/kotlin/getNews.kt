import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun getNews(count: Int = 100): List<News> {
    val client = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }

    val location = "spb" // Замените на ваш регион, если необходимо
    val newsList: List<News> = withContext(Dispatchers.IO) {
        client.get("https://api.kudago.com/v1.4/news/?page_size=$count&order_by=-publication_date&location=$location")
    }

    client.close()
    return newsList
}
