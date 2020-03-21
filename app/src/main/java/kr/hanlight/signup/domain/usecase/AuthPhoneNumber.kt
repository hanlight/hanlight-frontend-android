package kr.hanlight.signup.domain.usecase

import io.reactivex.Single
import kr.hanlight.UseCase
import kr.hanlight.signup.domain.SignUpRepository

class AuthPhoneNumber(
    private val repository: SignUpRepository
) : UseCase<String, Single<Boolean>> {
    override fun excute(params: String?): Single<Boolean> {
        return params?.let { repository.authPhoneNumber(it) }
            ?: Single.error(IllegalArgumentException("invalid parameters"))
    }
}