package lang.dsl

import lang.coroutines.client
import model.Client
import model.ClientBuilder
import model.CompanyBuilder
import model.TwitterBuilder


fun main() {
    val client = client {

        firstName = "Anton"
        lastName = "Arhipov"

        twitter {
            handle = "@antonarhipov"
        }

        company {
            name = "JetBrains"
            city = "Tallinn"
        }

        dob = 24 March 1981

    }

    println("Created client is: ${client.toS}")
}


fun ClientBuilder.twitter(block: TwitterBuilder.() -> Unit) {
    twitter = TwitterBuilder().apply(block).build()
}

fun ClientBuilder.company(block: CompanyBuilder.() -> Unit) {
    company = CompanyBuilder().apply(block).build()
}

val Client.toS: String
    get() = "${twitter.handle} ${company.name}"

fun client(block: context(DateContext) ClientBuilder.() -> Unit): Client {
    val builder = ClientBuilder()
    with(DateContext){
        block(builder)
    }
    return builder.build()
}


