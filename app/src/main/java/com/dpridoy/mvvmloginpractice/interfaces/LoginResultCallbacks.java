package com.dpridoy.mvvmloginpractice.interfaces;

public interface LoginResultCallbacks {
    void onSuccess(String message);
    void onError(String message);
}
