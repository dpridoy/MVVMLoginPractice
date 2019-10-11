package com.dpridoy.mvvmloginpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.Toast;

import com.dpridoy.mvvmloginpractice.databinding.ActivityMainBinding;
import com.dpridoy.mvvmloginpractice.interfaces.LoginResultCallbacks;
import com.dpridoy.mvvmloginpractice.viewmodel.LoginViewModel;
import com.dpridoy.mvvmloginpractice.viewmodel.LoginViewModelFactory;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements LoginResultCallbacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        activityMainBinding.setViewModel(ViewModelProviders.of(
                this,
                new LoginViewModelFactory(this))
                .get(LoginViewModel.class));
    }

    @Override
    public void onSuccess(String message) {
        Toasty.success(this,message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String message) {
        Toasty.error(this,message,Toast.LENGTH_SHORT).show();
    }
}
