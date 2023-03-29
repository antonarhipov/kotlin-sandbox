package intro


@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Repeatable
annotation class Attribute(val name: String)


@Attribute("attr1")
@Attribute("attr2")
class MyClass

