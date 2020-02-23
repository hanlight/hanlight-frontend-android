package kr.hanlight.login.domain.usecase

import io.reactivex.Single
import kr.hanlight.UseCase
import kr.hanlight.login.domain.LoginRepository

class Login(
    private val repository: LoginRepository
) : UseCase<Pair<String, String>, Single<String>> {
    override fun excute(params: Pair<String, String>?): Single<String> {
        return params?.let { repository.login(it.first, it.second) }
            ?: Single.error(IllegalArgumentException("invalid parameters"))
    }
}