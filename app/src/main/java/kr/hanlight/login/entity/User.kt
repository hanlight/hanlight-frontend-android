package kr.hanlight.login.entity

data class User(
    val accessToken: String?,
    val type: String,
    val admin: Boolean,
    val name: String,
    val id: String,
    val major: String,
    val grade: Int,
    val classNum: Int?,
    val studentNum: Int?
)