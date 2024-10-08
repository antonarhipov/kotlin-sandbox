package lang.inference


fun main() {
    val order = getOrder()

    when {
        order is Order.YearlySubscription -> processSubscription(order)
        order is Order.YearlySubscription && order.amount > 100 -> applyDiscount(order)
        order is Order.MonthlySubscription -> startSubscription(order)
        order is Order.OneTimeOrder -> processOrder(order)
    }
}

//region processors
fun processSubscription(subscription: Order.Subscription) {
    println("Processing $subscription")
}

fun processOrder(order: Order.OneTimeOrder) {
    println("Processing $order")
}

fun startSubscription(subscription: Order.MonthlySubscription) {
    println("Starting $subscription")
}

fun applyDiscount(subscription: Order.Subscription) {
    println("Applying discount to $subscription")
}
//endregion

sealed class Order {
    abstract val id: String
    abstract val customerName: String
    abstract val amount: Double

    data class OneTimeOrder(
        override val id: String,
        override val customerName: String,
        override val amount: Double,
        val deliveryDate: String
    ) : Order()

    sealed class Subscription : Order() {
        abstract val renewalDate: String
        abstract val duration: String
    }

    data class MonthlySubscription(
        override val id: String,
        override val customerName: String,
        override val amount: Double,
        override val renewalDate: String,
        override val duration: String = "1 month"
    ) : Subscription()

    data class YearlySubscription(
        override val id: String,
        override val customerName: String,
        override val amount: Double,
        override val renewalDate: String,
        override val duration: String = "1 year"
    ) : Subscription()

    object CancelledOrder : Order() {
        override val id: String = "Cancelled"
        override val customerName: String = "N/A"
        override val amount: Double = 0.0
    }
}






private fun getOrder(): Order = Order.YearlySubscription("1", "John", 102.0, "2024-10-07")


