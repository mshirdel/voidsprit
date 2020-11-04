package ir.mshirdel.voidsprit.models

data class UserApiHolder(val user: User)

data class User(
    val email: String,
    val username: String,
    val bio: String,
    val image: String,
    val token: String)