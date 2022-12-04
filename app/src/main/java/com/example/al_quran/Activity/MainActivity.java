package com.example.al_quran.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;

import com.example.al_quran.R;
import com.example.al_quran.Utility.AppPrefarance;
import com.example.al_quran.databinding.ActivityMainBinding;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
private Context cTx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        cTx=this;
        AppPrefarance.setLanguage(cTx,"en");
        clickMethod();
        binding.getRoot();
    }

    private void clickMethod() {
        Date d = new Date();
        CharSequence s  = DateFormat.format("EEE MMMM, yyyy ", d.getTime());
        Log.e("ffff",s.toString());
        binding.tvDate.setText(s+"");
        binding.tvDateBen.setText(s+"");
        binding.Quran.setOnClickListener(m -> {
         startActivity(new Intent(this,QuranActivity.class));
        });
    }
}