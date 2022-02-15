import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.help
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.required
import com.google.gson.Gson
import kotlin.system.exitProcess


object App : CliktCommand("Utility to change date format in ndjson properties", "2022.02.16", "datereconv") {

  val property by option().required().help("json property contains date")

  val pattern by option().required().help("pattern to convert date")

  private val parser = Gson()

  override fun run() {
    val nestingHierarchy = property.split('.')
    while (true) {
      val text = readLine() ?: return
      val tree = parser.toJsonTree(text).asJsonObject

    }
  }

  fun convert(date: String): String {
    TODO()
  }
}