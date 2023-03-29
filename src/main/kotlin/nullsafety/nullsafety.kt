package nullsafety


fun main(args: Array<String>) {


    // nullable value
    val user: User? = getUser()

    // check for null
    if (user != null) {
        println(user.name)
    }

    // use ?. operator
    println(user?.name)



}

fun getUser(): User? {
    TODO()
}

fun printAnyUserName(o: Any) {
    // prints null on cast failure
    println((o as? User)?.name)

    // throws exception on cast failure
    println((o as User).name)
}



data class User(val id: String?, val name: String, val address: Address)
data class Address(val city: City?, val street: String)
data class City(val name: String)

fun getS(): String? = TODO()