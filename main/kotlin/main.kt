import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val newsList = getNews(5)

    newsDsl {
        header(level = 1) { "Новости" }
        newsList.forEach { news ->
            newsItem(news)
        }
    }
}
