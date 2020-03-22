package kr.hanlight.signup.presentation

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.jakewharton.rxbinding3.widget.textChangeEvents
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.BiFunction
import io.reactivex.functions.Function3
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_sign_up_form.*
import kr.hanlight.R

/**
 * A simple [Fragment] subclass.
 */
class SignUpFormFragment : Fragment(R.layout.fragment_sign_up_form) {

    companion object {
        fun newInstance(): SignUpFormFragment {
            return SignUpFormFragment()
        }
    }

    private val disposable: CompositeDisposable = CompositeDisposable()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    private fun initViews() {
        disposable.add(
            Observable.combineLatest(
                    idInput.textChangeEvents().skipInitialValue().map { it.text.isNotBlank() },
                    pwInput.textChangeEvents().skipInitialValue().map { it.text.isNotBlank() },
                    checkPwInput.textChangeEvents().skipInitialValue().map { it.text.isNotBlank() },
                    Function3<Boolean, Boolean, Boolean, Boolean> { id, pw, checkPw -> (id && pw && checkPw) }
                ).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    if (it) {
                        signUpButton.setCardBackgroundColor(Color.parseColor("#4470ff"))
                    } else {
                        signUpButton.setCardBackgroundColor(Color.parseColor("#a3a3a3"))
                    }
                }
        )
    }
}
