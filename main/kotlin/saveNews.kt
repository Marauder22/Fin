import java.io.File

fun saveNews(path: String, news: Collection<News>) {
    val file = File(path)
    if (file.exists()) {
        throw IllegalArgumentException("Файл уже существует: $path")
    }

    file.printWriter().use { out ->
        out.println("id,title,place,description,siteUrl,favoritesCount,commentsCount,publishedAt")
        news.forEach { newsItem ->
            out.println("${newsItem.id},${newsItem.title},${newsItem.place},${newsItem.description},${newsItem.siteUrl},${newsItem.favoritesCount},${newsItem.commentsCount},${newsItem.publishedAt}")
        }
    }
}
