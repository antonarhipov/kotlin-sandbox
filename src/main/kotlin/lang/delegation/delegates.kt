package lang.delegation

import kotlin.properties.Delegates

interface MyInterface {
    fun sayHello() = "hello"
    fun sayBye()
}

class MyInterfaceWrapper(my: MyInterface) : MyInterface by my


fun main(args: Array<String>) {

    class User {
        var name: String by Delegates.observable("N/A") {
                property, old, new -> println("$old -> $new")
        }
    }

    val user = User()
    user.name = "Joe"  // N/A -> Joe
    user.name = "John" // Joe -> John
}