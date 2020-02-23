package kr.hanlight.login.domain

import io.reactivex.Single

interface LoginRepository {
    fun login(id: String, pw: String): Single<String>
}