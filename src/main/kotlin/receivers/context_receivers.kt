package receivers

//interface LoggerContext {
//    val logger: Logger
//}
//
//interface NotificationContext {
//    val notifier: NotificationSender
//}

//class NotificationSender {
//    fun log(s: String) {
//    }
//}
//
//context(LoggerContext, NotificationContext)
//fun store(s: String) {
//    logger.log("Stored $s on disk")
//}
//
//context(LoggerContext, NotificationContext)
//class Storage {
//    fun store(s: String) {
//        logger.log(s)
//    }
//}


fun main() {
//    val loggerContext1 = object : LoggerContext {
//        override val logger: Logger
//            get() = Logger("Main")
//    }
//
//    val loggerContext2 = object : LoggerContext {
//        override val logger: Logger
//            get() = Logger("Secondary")
//    }
//
//    val notificationContext = object : NotificationContext {
//        override val notifier: NotificationSender
//            get() = NotificationSender()
//
//    }

//    with(loggerContext1) {
//        with(notificationContext) {
//            store("blah 1")
//            store("blah 2")
//            store("blah 3")
//        }
//    }
//    val storage1 = with(loggerContext1) {
//        with(notificationContext) {
//            Storage()
//        }
//    }
//
//    val storage2 = with(loggerContext2) {
//        with(notificationContext) {
//            Storage()
//        }
//    }
//
//    storage1.store("blah")
//    storage2.store("blah")
}


