package text.impl

import text.spi.TextPlugin

@Suppress("unused")
class UppercasePlugin : TextPlugin {
    override val name: String = "Uppercase"
    override operator fun invoke(text: String): String = text.uppercase()
}
