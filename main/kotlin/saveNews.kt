import com.github.doyaaaaaken.kotlincsv.dsl.csvWriter
import java.io.File
import java.io.IOException

fun saveNews(path: String, news: Collection<News>) {
    val file = File(path)

    if (file.exists()) {
        throw IllegalArgumentException("Файл уже существует: $path")
    }
    try {
  
        csvWriter().open(file) {
            writeRow("id", "title", "place", "description", "siteUrl", "favoritesCount", "commentsCount", "publishedAt")

            news.forEach { newsItem ->
                writeRow(
                    newsItem.id,
                    newsItem.title,
                    newsItem.place,
                    newsItem.description,
                    newsItem.siteUrl,
                    newsItem.favoritesCount,
                    newsItem.commentsCount,
                    newsItem.publishedAt
                )
            }
        }
    } catch (e: IOException) {
        throw RuntimeException("Ошибка при записи в файл: ${e.message}", e)
    } catch (e: Exception) {
        throw RuntimeException("Неизвестная ошибка: ${e.message}", e)
    }
}
