package org.kotlin

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class DelegatedPropertiesExample {

    var p: String by Delegate()

    val x: String by lazy {
        println("initializing the property")
        "Hello"
    }

    var name: String by Delegates.observable("<no name>") {
            prop, old, new ->
        println("${prop.name}: $old -> $new")
    }
}

class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }
}


fun main() {
}




