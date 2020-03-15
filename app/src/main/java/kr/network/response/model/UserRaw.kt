package kr.network.response.model

data class UserRaw(
    val accessToken: String,
    val user: UserInfo
) {
    data class UserInfo(
        val type: String,
        val admin: Int,
        val name: String,
        val id: String,
        val major: String,
        val grade: Int,
        val classNum: Int?,
        val studentNum: Int?
    )
}