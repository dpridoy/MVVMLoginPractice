package com.dpridoy.mvvmloginpractice.viewmodel;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.lifecycle.ViewModel;

import com.dpridoy.mvvmloginpractice.interfaces.LoginResultCallbacks;
import com.dpridoy.mvvmloginpractice.model.User;

public class LoginViewModel extends ViewModel {
    private User user;
    private LoginResultCallbacks loginResultCallbacks;

    public LoginViewModel(LoginResultCallbacks loginResultCallbacks){
        this.loginResultCallbacks=loginResultCallbacks;
        this.user=new User();
    }

    public TextWatcher getEmailTextWatcher(){
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                user.setEmail(toString());
            }
        };
    }

    public TextWatcher getPasswordTextWatcher(){
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                user.setPassword(toString());
            }
        };
    }

    public void onLoginClicked(View view){
        int errorCode=user.isValidData();
        if(errorCode==0){
            loginResultCallbacks.onError("Please insert email");
        }
//        else if (errorCode==1){
//            loginResultCallbacks.onError("Invalid Email!!");
//        }
        else if (errorCode==2){
            loginResultCallbacks.onError("Password length must me 6 or more");
        }
        else {
            loginResultCallbacks.onSuccess("Login Success!");
        }
    }
}
