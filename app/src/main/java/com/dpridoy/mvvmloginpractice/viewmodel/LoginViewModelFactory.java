package com.dpridoy.mvvmloginpractice.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.dpridoy.mvvmloginpractice.interfaces.LoginResultCallbacks;

public class LoginViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    LoginResultCallbacks loginResultCallbacks;

    public LoginViewModelFactory(LoginResultCallbacks loginResultCallbacks) {
        this.loginResultCallbacks = loginResultCallbacks;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T)new LoginViewModel(loginResultCallbacks);
    }
}
