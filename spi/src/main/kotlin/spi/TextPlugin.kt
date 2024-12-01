package text.spi

interface TextPlugin {
    val name: String
    operator fun invoke(text: String): String
}
