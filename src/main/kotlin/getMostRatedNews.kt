import java.time.LocalDate

fun List<News>.getMostRatedNews(count: Int, period: ClosedRange<LocalDate>): List<News> {
    return this.filter { news ->
        // Предполагается, что поле publicationDate доступно в API
        // news.publicationDate in period
        true // Замените на реальную проверку
    }.sortedByDescending { it.rating }
        .take(count)
}
