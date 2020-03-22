package kr.hanlight.login

import kr.hanlight.login.data.repository.LoginRepositoryImpl
import kr.hanlight.login.domain.LoginRepository
import kr.hanlight.login.domain.usecase.Login
import kr.hanlight.login.presentation.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var loginModule = module {
    factory<LoginRepository> { LoginRepositoryImpl(get()) }

    factory { Login(get()) }

    viewModel { LoginViewModel(get()) }
}