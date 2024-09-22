package lang.oop

open class Foo {
    class Bar
}

class Child : Foo() {
    fun test(bar: Bar) {} // no need to use Foo.Bar
}