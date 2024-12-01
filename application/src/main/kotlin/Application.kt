package text

import com.github.kinquirer.KInquirer
import com.github.kinquirer.components.promptList
import text.impl.EchoPlugin
import text.spi.TextPlugin
import java.util.ServiceLoader

fun main(args: Array<String>) {
    if (args.isEmpty() || args[0].isEmpty()) {
        println("Usage: text '<text>'")
        return
    }
    val text = args[0]
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
