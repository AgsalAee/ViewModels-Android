package com.example.viewmodelfragment.viewmodels;

import androidx.databinding.Bindable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.viewmodelfragment.models.User;

public class LoginViewModel extends ViewModel {

    public MutableLiveData<User> UserMutableLiveData = new MutableLiveData<>();
    private User user = new User(null,null);


    public String toastMessage = null;

    public String getToastMessage() {
        return toastMessage;
    }

    private void setToastMessage(String toastMessage) {
        this.toastMessage = toastMessage;
    }

    public void afterEmailTextChanged(CharSequence s) {
        user.setEmail(s.toString());
    }

    public void afterPasswordTextChanged(CharSequence s) {
        user.setPassword(s.toString());
    }

    public void onLoginClicked() {
        if (user.isInputDataValid()){
            user.setInfoMessage("berhasil");
        }
        else{
            user.setInfoMessage("gagal");
        }
        UserMutableLiveData.setValue(user);
        setToastMessage(user.getInfoMessage());
    }
}