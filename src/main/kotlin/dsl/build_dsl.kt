package dsl

fun main() {
    val project = project("My Project") {
        configuration {
            name = "My Config"
            id = "123123"
            type = "Buld project"
        }

        pipeline {
//            step { "git -u pull" }
//            step {"mvn clean test" }
        }
    }

}

fun Project.pipeline(block: Runnable){
    pipelines.add(block)
}

fun project(name: String, block: Project.() -> Unit) =
    Project("MyProject").apply(block)

class Project(val name: String) {

    private val configuration = Configuration()
    val pipelines = mutableListOf<Runnable>()

    fun configuration(block: Configuration.() -> Unit) {
        configuration.apply(block)
    }

    class Configuration {
        lateinit var name: String
        lateinit var id: String
        lateinit var type: String
    }

    class Pipeline {
        val steps = mutableListOf<String>()
        fun step(s: String) {
            steps += s
        }
    }
}



