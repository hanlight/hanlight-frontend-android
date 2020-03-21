package kr.hanlight.signup.presentation

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.jakewharton.rxbinding3.widget.textChangeEvents
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_sign_up.*

import kr.hanlight.R

/**
 * 회원가입 페이지
 */
class SignUpFragment : Fragment(R.layout.fragment_sign_up) {

    companion object {
        fun newInstance(): SignUpFragment {
            return SignUpFragment()
        }
    }

    private val disposable: CompositeDisposable = CompositeDisposable()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        initViewModels()
    }

    private fun initViews() {
        disposable.add(
            Observable.combineLatest(
                    authKeyInput.textChangeEvents().skipInitialValue().map { it.text.isNotBlank() },
                    phoneNumberInput.textChangeEvents().skipInitialValue().map { it.text.isNotBlank() },
                    BiFunction<Boolean, Boolean, Boolean> { key, number -> (key && number) }
                ).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    if (it) {
                        certificationBtn.setCardBackgroundColor(Color.parseColor("#4470ff"))
                    } else {
                        certificationBtn.setCardBackgroundColor(Color.parseColor("#a3a3a3"))
                    }
                }
        )
    }

    private fun initViewModels() {

    }
}
