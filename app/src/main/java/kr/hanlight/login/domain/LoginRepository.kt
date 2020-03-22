package kr.hanlight.login.domain

import io.reactivex.Single
import kr.hanlight.login.entity.User

interface LoginRepository {
    fun login(id: String, pw: String): Single<User>
}