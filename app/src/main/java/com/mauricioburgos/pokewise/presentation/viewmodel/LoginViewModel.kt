package com.mauricioburgos.pokewise.presentation.viewmodel

import androidx.databinding.ObservableField
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.mauricioburgos.pokewise.AppController
import com.mauricioburgos.pokewise.core.platform.Failure
import com.mauricioburgos.pokewise.data.repositories.UserRepository
import com.mauricioburgos.pokewise.domain.ErrorResponse
import com.mauricioburgos.pokewise.domain.UserSigninRequest
import com.mauricioburgos.pokewise.usecases.LoginUseCase


import javax.inject.Inject

class LoginViewModel
@ViewModelInject
constructor(
    private val loginUseCase: LoginUseCase,
    private val userRepository: UserRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    var mEmailAddress = ObservableField<String>("")
    var mPassword = ObservableField<String>("")

    val logged: MutableLiveData<Boolean> by lazy { MutableLiveData<Boolean>() }
    val error : MutableLiveData<ErrorResponse> by lazy { MutableLiveData<ErrorResponse>() }

    private var userMutableLiveData = MutableLiveData<UserSigninRequest>()


    fun getLoginUserLiveData(): LiveData<UserSigninRequest> = userMutableLiveData

    fun getIsLogged(): Boolean{
        return userRepository.getIsLogged()
    }

    fun checkUserData(){
        val loginUser = UserSigninRequest(mEmailAddress.get(), mPassword.get())
        userMutableLiveData.value = loginUser
    }

    fun login() {

       var userSigninRequest= UserSigninRequest(mEmailAddress.get(), mPassword.get())
       loginUseCase.invoke(userSigninRequest)
       {
           it.either(
               { failure ->
                   logged.value = false
                   error.value= (failure as Failure.ServerError).errorResponse
                   failure
               },
               { user ->
                   logged.value = true
                   user
               }
           )
       }


    }





}
