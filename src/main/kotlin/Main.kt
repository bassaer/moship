package moship

import com.squareup.moshi.Json
import com.squareup.moshi.Moshi


data class User(
var id: Int,
var name: String
)

data class Account(
var user: User,
var item: String
)


fun jsonToObject1() {
    val jsonText = "{\"id\": 0, \"name\": \"hoge\", \"age\": 99}"
    val adapter = Moshi.Builder().build().adapter(User::class.java)
    val user = adapter.fromJson(jsonText)
    println("id: ${user?.id}, name: ${user?.name}")
}


fun objectToJson1() {
    val user = User(999, "foo")
    val adapter = Moshi.Builder().build().adapter(User::class.java)
    val jsonText = adapter.toJson(user)
    println(jsonText)
}

fun jsonToObject2() {
    val jsonText = "{\"user\": {\"id\": 0, \"name\": \"hoge\"}, \"item\": \"piyo\"}"
    val adapter = Moshi.Builder().build().adapter(Account::class.java)
    val account = adapter.fromJson(jsonText)
    println("$account")
}


fun objectToJson2() {
    val account = Account(User(999, "foo"), "bar")
    val adapter = Moshi.Builder().build().adapter(Account::class.java)
    val jsonText = adapter.toJson(account)
    println(jsonText)
}


fun main(args: Array<String>) {
    jsonToObject1()
    objectToJson1()
    jsonToObject2()
    objectToJson2()
}
