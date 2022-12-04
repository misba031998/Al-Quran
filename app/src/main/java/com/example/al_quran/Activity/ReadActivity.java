package com.example.al_quran.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.al_quran.R;
import com.example.al_quran.databinding.ReadActivityBinding;

public class ReadActivity extends AppCompatActivity {
    private ReadActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.read_activity);
        clickMetod();
        binding.getRoot();
    }

    private void clickMetod() {

    }
}