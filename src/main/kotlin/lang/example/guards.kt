package lang.example

import jdk.jfr.Threshold
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.Month
import lang.example.Order.*
import kotlin.time.Duration
import kotlin.time.DurationUnit
import kotlin.time.toDuration


fun main() {
    val order = getOrder()
    when {
        order is YearlySubscription && order.amount > 100 -> applyDiscount(order)
        order is MonthlySubscription -> startSubscription(order)
        order is OneTimeOrder -> processOrder(order)
    }
}


//region processors
fun processSubscription(subscription: YearlySubscription) {
    val (name, id, amount) = subscription
    println("$id: $name $amount")
}

fun processOrder(order: OneTimeOrder) {
    println("Processing $order")
}

fun startSubscription(subscription: MonthlySubscription) {
    println("Starting $subscription")
}

fun applyDiscount(subscription: Subscription) {
    println("Applying discount to $subscription")
}
//endregion

private fun getOrder(): Order {
    return YearlySubscription("1", "Anton", 12.0, LocalDate(2024, Month.OCTOBER, 9))
}

//region domain model
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
        abstract val renewalDate: LocalDate
        abstract val duration: Duration
    }

    data class MonthlySubscription(
        override val id: String,
        override val customerName: String,
        override val amount: Double,
        override val renewalDate: LocalDate,
        override val duration: Duration = 30.toDuration(DurationUnit.DAYS)
    ) : Subscription()

    data class YearlySubscription(
        override val id: String,
        override val customerName: String,
        override val amount: Double,
        override val renewalDate: LocalDate,
        override val duration: Duration = 365.toDuration(DurationUnit.DAYS)
    ) : Subscription()

    class CancelledOrder : Order() {
        override val id: String = "Cancelled"
        override val customerName: String = "N/A"
        override val amount: Double = 0.0
    }
}
//endregion


fun processAllOrders(orders: Sequence<YearlySubscription>, ) {
    orders.groupBy { it.customerName }
        .forEach { customerName, orders ->
            processCustomerOrders(orders.asSequence())
        }
}

fun processCustomerOrders(orders: Sequence<YearlySubscription>,  threshold: Double = 100.0) {
    orders.last { it.amount > threshold }
}

val TODAY: Instant = Clock.System.now()

private fun retrieveOrders(): List<Order> {
    TODO()
}
