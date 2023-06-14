package statments

sealed class Weather
object Rainy : Weather()


sealed class Drive
class Safe: Drive()
class Calm: Drive()

fun adjustSpeed(weather: Weather) = if (weather is Rainy) {
    Safe()
} else {
    Calm()
}

val x: UInt = 1u