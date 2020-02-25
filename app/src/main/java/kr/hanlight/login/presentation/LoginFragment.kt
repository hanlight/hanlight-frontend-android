package kr.hanlight.login.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_login.*
import kr.hanlight.R
import kr.hanlight.common.Lce
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {
    companion object {
        fun newInstance(): LoginFragment {
            return LoginFragment()
        }
    }

    private val viewModel: LoginViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        initViewModel()
    }

    private fun initViews() {
        loginBtn.setOnClickListener {
            if (idInput.text.toString().isNotEmpty() && pwInput.text.toString().isNotEmpty()) {
                viewModel.login(idInput.text.toString(), pwInput.text.toString())
            }
        }

        findIdBtn.setOnClickListener {

        }

        findPwBtn.setOnClickListener {

        }

        signUpBtn.setOnClickListener {

        }
    }

    private fun initViewModel() {
        viewModel.user.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Lce.Content -> { }
                is Lce.Error -> { showAlert() }
            }
        })
    }

    private fun showAlert() {
        idInput.showAlertOutline()
        pwInput.showAlertOutline()
    }
}