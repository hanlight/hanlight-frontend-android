package kr.hanlight.login.data.repository

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kr.hanlight.login.data.UserMapper
import kr.hanlight.login.domain.LoginRepository
import kr.hanlight.login.entity.User
import kr.hanlight.network.service.login.LoginService

class LoginRepositoryImpl(
    private val loginService: LoginService
): LoginRepository {
    override fun login(id: String, pw: String): Single<User> {
        return loginService.login(id, pw)
            .map { UserMapper().map(it) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}