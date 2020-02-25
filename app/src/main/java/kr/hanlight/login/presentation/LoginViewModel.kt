package kr.hanlight.login.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import kr.hanlight.common.Lce
import kr.hanlight.login.domain.usecase.Login
import kr.hanlight.login.entity.User

class LoginViewModel(
    private val login: Login
) : ViewModel() {
    private val disposable: CompositeDisposable = CompositeDisposable()

    private val _user = MutableLiveData<Lce<User>>()
    val user: LiveData<Lce<User>>
        get() = _user

    fun login(id: String, pw: String) {
        disposable.add(
            login.excute(Pair(id, pw))
                .subscribe({
                    _user.value = Lce.Content(it)
                }, {
                    _user.value = Lce.Error(it)
                    it.printStackTrace()
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }
}