package lang.dsl

fun main() {

//    val project = project("My project") {
//
//        val c1 = configuration("Configuration 1") {
//            steps {
//                maven {}
//            }
//
//            vcs {
//                type = "Git"
//                url = "git://......"
//                user = "user"
//                password = "password"
//            }
//        }
//        val c2 = configuration("Configuration 2") { }
//        val c3 = configuration("Configuration 3") { }
//        val c4 = configuration("Configuration 4") { }
//
//        pipeline {
//            build(c1)
//            parallel(c2, c3)
//            build(c4)
//        }
//    }
}


//class Steps {
//    fun maven(block: () -> Unit) {
//    }
//}
//
//class Configuration(val name: String) {
//    val steps: List<Any> = mutableListOf()
//
//    fun steps(block: Steps.() -> Unit) {
//
//    }
//}

//class VCS {
//    lateinit var type: String
//    lateinit var url: String
//    lateinit var user: String
//    lateinit var password: String
//}
//
//class Project(val name: String) {
//    fun configuration(name: String, block: Configuration.() -> Unit) = Configuration(name).apply(block)
//
//    fun vcs(block: VCS.() -> Unit) {
//    }
//
//    fun pipeline(block:/* context(StorageContext)*/ Pipeline.() -> Unit) {
////        val storageContext = StorageContext()
//        block(
////            storageContext,
////            with(storageContext) {
//                Pipeline()
////            }
//        )
//    }
//
////    context(StorageContext)
//    class Pipeline {
//        fun build(c: Configuration) {
//        }
//
//        fun parallel(vararg c: Configuration) {
//        }
//    }
//}

//fun project(`project name`: String, block: Project.() -> Unit): Project {
//    return Project(`project name`).apply(block)
//}

//
//class StorageContext {
//    val storage = S3()
//}
//
//class S3 {
//    fun upload() {}
//    fun download() {}
//}