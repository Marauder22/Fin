class NewsPrinter {
    private val stringBuilder = StringBuilder()

    fun header(level: Int, block: () -> String) {
        stringBuilder.append("#".repeat(level)).append(" ").append(block()).appendLine()
    }

    fun text(block: () -> String) {
        stringBuilder.append(block()).appendLine()
    }

    fun print() {
        println(stringBuilder.toString())
    }
}

fun newsPrint(block: NewsPrinter.() -> Unit) {
    val printer = NewsPrinter()
    printer.block()
    printer.print()
}
