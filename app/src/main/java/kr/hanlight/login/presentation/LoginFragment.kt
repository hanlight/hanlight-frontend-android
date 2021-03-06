package kr.hanlight.login.presentation

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.jakewharton.rxbinding3.widget.TextViewTextChangeEvent
import com.jakewharton.rxbinding3.widget.textChangeEvents
import com.jakewharton.rxbinding3.widget.textChanges
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_login.*
import kr.hanlight.R
import kr.hanlight.common.Lce
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class LoginFragment : Fragment() {
    companion object {
        fun newInstance(): LoginFragment {
            return LoginFragment()
        }
    }

    private val viewModel: LoginViewModel by viewModel()

    private val disposable: CompositeDisposable = CompositeDisposable()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        initViewModel()
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }

    private fun initViews() {
        disposable.add(
            Observable.combineLatest(
                    idInput.textChangeEvents().skipInitialValue().map { it.text.isNotBlank() },
                    pwInput.textChangeEvents().skipInitialValue().map { it.text.isNotBlank() },
                    BiFunction<Boolean, Boolean, Boolean> { id, pw -> (id && pw) }
                ).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    if (it) {
                        loginBtn.setCardBackgroundColor(Color.parseColor("#4470ff"))
                    } else {
                        loginBtn.setCardBackgroundColor(Color.parseColor("#a3a3a3"))
                    }
                }
        )

        loginBtn.setOnClickListener {
            if (idInput.text.toString().isNotEmpty() && pwInput.text.toString().isNotEmpty()) {
                viewModel.login(idInput.text.toString(), pwInput.text.toString())
            }
        }

        txtFindId.setOnClickListener {

        }

        txtFindPw.setOnClickListener {

        }

        txtSignUp.setOnClickListener {

        }
    }

    private fun initViewModel() {
        viewModel.user.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Lce.Content -> {  }
                is Lce.Error -> { showAlert() }
            }
        })
    }

    private fun showAlert() {
        idInput.showAlertOutline()
        pwInput.showAlertOutline()
    }
}