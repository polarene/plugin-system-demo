package custom.text

import text.spi.TextPlugin

@Suppress("unused")
class FlipFlopPlugin : TextPlugin {
    override val name: String = "Flip Flop"

    override fun invoke(text: String): String {
        return text.mapIndexed { i, c ->
            if (i % 2 == 0) c.uppercaseChar() else c.lowercaseChar()
        }.joinToString("")
    }
}
