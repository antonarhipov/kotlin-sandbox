import java.util.Locale

fun main() {
    val locales = Locale.getAvailableLocales()
    for (locale in locales) {
        println(Locale.forLanguageTag(locale.language))
    }
}
