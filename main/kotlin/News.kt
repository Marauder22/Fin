import kotlinx.serialization.Serializable
import java.time.LocalDate
import kotlinx.serialization.Contextual

@Serializable
data class News(
    val id: Int,
    val title: String,
    val place: String,
    val description: String,
    val siteUrl: String,
    val favoritesCount: Int,
    val commentsCount: Int,
    @Contextual val publishedAt: LocalDate
) {
    // Ленивое свойство для рейтинга
    val rating: Double by lazy {
        1 / (1 + Math.exp(-(favoritesCount / (commentsCount + 1).toDouble())))
    }
}
