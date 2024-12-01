package text.impl

import text.spi.TextPlugin

@Suppress("unused")
class EchoPlugin : TextPlugin {
    override val name: String = "Echo"
    override operator fun invoke(text: String): String = text
}
