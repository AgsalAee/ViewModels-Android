package com.example.viewmodelfragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.viewmodelfragment.R;
import com.example.viewmodelfragment.databinding.FragmentInputBinding;
import com.example.viewmodelfragment.viewmodels.LoginViewModel;

import android.view.LayoutInflater;
import android.view.ViewGroup;

public class InputFragment extends Fragment {

    public LoginViewModel mViewModels;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentInputBinding fragmentInputBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_input,container,false);
        mViewModels = new ViewModelProvider(this).get(LoginViewModel.class);
        fragmentInputBinding.setUserViewModel(mViewModels);
        fragmentInputBinding.setLifecycleOwner(this);
        return fragmentInputBinding.getRoot();
    }


    @BindingAdapter({"toastMessage"})
    public static void runMe(View view, String message) {
        if (message != null)
            Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
    }

}