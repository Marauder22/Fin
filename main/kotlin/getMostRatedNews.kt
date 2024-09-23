import java.time.LocalDate

fun List<News>.getMostRatedNews(count: Int, period: ClosedRange<LocalDate>): List<News> {
    return this.filter { news ->
        news.publishedAt in period
    }
        .sortedByDescending { it.rating }
        .take(count)
}