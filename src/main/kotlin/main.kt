fun main() {
    newsPrint {
        header(1) { "Новости KudaGo" }
        header(2) { "Список новостей" }
        text { "Сегодня мы изучаем работу с API KudaGo." }

        val newsList = getNews()
        newsList.forEach { news ->
            text { "${news.title} - ${news.siteUrl}" }
        }
    }
}
