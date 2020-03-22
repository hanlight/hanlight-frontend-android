package kr.hanlight.network.service.login

import io.reactivex.Single
import kr.hanlight.network.response.model.UserRaw
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST("user/login")
    fun login(@Body id: String,
              @Body pw: String): Single<UserRaw>
}