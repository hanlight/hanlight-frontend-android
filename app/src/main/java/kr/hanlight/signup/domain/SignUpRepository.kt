package kr.hanlight.signup.domain

import io.reactivex.Single

interface SignUpRepository {
    fun checkCertificationKey(key: String): Single<Boolean>
    fun authPhoneNumber(number: String): Single<Boolean>
}