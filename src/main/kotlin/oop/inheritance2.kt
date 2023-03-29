package oop

interface Foo2 {
    class Bar
}

class Child2 : Foo2 {
    fun test(bar: Foo2.Bar) {} // have to use Foo.Bar, just Bar does not work
}