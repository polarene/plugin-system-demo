package text

import com.github.kinquirer.KInquirer
import com.github.kinquirer.components.promptList
import text.impl.EchoPlugin
import text.spi.TextPlugin
import java.util.ServiceLoader

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("Usage: text <text>")
        println("You can pass a text including spaces, " +
            "but if there are special characters, you should quote it.")
        return
    }
    val text = args.joinToString(" ")
    val plugins =
        (listOf(EchoPlugin()) + ServiceLoader.load(TextPlugin::class.java))
            .associateBy { it.name }
    val selected = KInquirer.promptList(
        message = "Which plugin do you want to apply?",
        choices = plugins.keys.toList()
    )
    val result = plugins[selected]!!(text)
    println(result)
}
