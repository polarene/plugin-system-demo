package text.impl

import text.spi.TextPlugin

@Suppress("unused")
class LowercasePlugin : TextPlugin {
    override val name: String = "Lowercase"
    override operator fun invoke(text: String): String = text.lowercase()
}
