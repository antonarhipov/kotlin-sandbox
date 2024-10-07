
class Card(val holder: String?)

fun findHolder(card: Any): String {
    val first = when {
        card is Card && (card.holder == "Anton") -> "OK"
        else -> "Not found"
    }

    val second = when(card) {
        is Card if (card.holder == "Anton") -> "OK"
        else -> "Not found"
    }

    return first + second
}

