import java.lang.reflect.Modifier

abstract class SomeClass<T> {
    abstract fun execute() : T
}

class SomeImplementation : SomeClass<String>() {
    override fun execute(): String = "Test"
}

class OtherImplementation : SomeClass<Int>() {
    override fun execute(): Int = 42
}

object Runner {
    inline fun <reified S: SomeClass<T>, T> run() : T {
        val clazz = S::class.java
        if(Modifier.isAbstract(clazz.modifiers)) {
           throw IllegalArgumentException("Type argument $clazz should not be abstract")
        }
        return clazz.getDeclaredConstructor().newInstance().execute()
    }
}

fun main() {
    // T is inferred to String because of SomeImplementation derives from SomeClass<String>
    val s = Runner.run<SomeImplementation, _>()
    assert(s == "Test")

    // T is inferred to Int because of OtherImplementation derives from SomeClass<Int>
    val n = Runner.run<OtherImplementation, _>()
    assert(n == 42)



}
