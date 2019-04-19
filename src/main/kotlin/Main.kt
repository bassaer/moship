package moship

import com.squareup.moshi.Json
import com.squareup.moshi.Moshi


data class User(
var id: Int,
var name: String
)


fun jsonToObject() {
    val jsonText = "{\"id\": 0, \"name\": \"hoge\"}"
    val adapter = Moshi.Builder().build().adapter(User::class.java)
    val user = adapter.fromJson(jsonText)
    println("id: ${user?.id}, name: ${user?.name}")
}


fun objectToJson() {
    val user = User(999, "foo")
    val adapter = Moshi.Builder().build().adapter(User::class.java)
    val jsonText = adapter.toJson(user)
    println(jsonText)
}


fun main() {
    jsonToObject()
    objectToJson()
}
