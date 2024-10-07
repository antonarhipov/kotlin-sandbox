package lang.nullsafety

data class User(val id: String?, val name: String, val address: Address)
data class Address(val city: City?, val street: String)
data class City(val name: String)

fun getUserLocation(user: User): String {
    // Safe call operator: ?.
    val cityName: String? = user.address.city.name

    // Elvis operator: ?: provides a fallback message if city is null
    return "${user.address.street}, ${cityName ?: "City not provided"}"
}

fun main() {
    val userWithCity = User("1", "Anton", Address(City("Tallinn"), "Main St"))
    val userWithoutCity = User("2", "Maria", Address(null, "Baker St"))

    // Safe call and Elvis operator handle null city gracefully
    println(getUserLocation(userWithCity))    // Outputs: "Main St, Tallinn"
    println(getUserLocation(userWithoutCity)) // Outputs: "Baker St, City not provided"
}
