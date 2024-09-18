import java.io.File

fun saveNews(path: String, news: Collection<News>) {
    val file = File(path)

    require(!file.exists()) { "Файл по указанному пути уже существует." }

    file.printWriter().use { out ->
        out.println("id,title,place,description,siteUrl,favoritesCount,commentsCount,rating")
        news.forEach {
            out.println("${it.id},${it.title},${it.place ?: ""},${it.description},${it.siteUrl},${it.favoritesCount},${it.commentsCount},${it.rating}")
        }
    }
}
