package kr.hanlight.signup.presentation

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import kr.hanlight.signup.domain.usecase.AuthPhoneNumber
import kr.hanlight.signup.domain.usecase.CheckUserAuthKey

class AuthViewModel(
    private val checkUserAuthKey: CheckUserAuthKey,
    private val authPhoneNumber: AuthPhoneNumber
) : ViewModel() {

    private val disposable: CompositeDisposable = CompositeDisposable()

    fun checkUserAuthKey(key: String) {
        disposable.add(
            checkUserAuthKey.excute(key)
                .subscribe({

                }, {
                    it.printStackTrace()
                })
        )
    }

    fun authPhoneNumber(number: String) {
        disposable.add(
            authPhoneNumber.excute(number)
                .subscribe({

                }, {
                    it.printStackTrace()
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }
}