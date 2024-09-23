class NewsDsl {
    private val content = StringBuilder()

    fun header(level: Int, block: () -> String) {
        content.append("#".repeat(level)).append(" ${block()}\n")
    }

    fun text(block: () -> String) {
        content.append("${block()}\n")
    }

fun newsItem(news: News) {
    content.append("### ${news.title}\n")
    content.append("-----\n")
    
    content.append("**Place:** ${news.place}\n")
    content.append("-----\n")
    
    content.append("**Description:**\n")
    content.append("${news.description}\n")
    content.append("-----\n")
    
    content.append("**URL:** [${news.siteUrl}](${news.siteUrl})\n")
    content.append("-----\n")
    
    content.append("**Favorites:** ${news.favoritesCount}\n")
    content.append("**Comments:** ${news.commentsCount}\n")
    content.append("**Rating:** ${news.rating}\n")
    content.append("-----\n")
}
    fun print() {
        println(content.toString())
    }
}

fun newsDsl(block: NewsDsl.() -> Unit) {
    val dsl = NewsDsl()
    dsl.block()
    dsl.print()
}
