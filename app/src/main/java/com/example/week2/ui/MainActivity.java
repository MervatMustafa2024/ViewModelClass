package com.example.week2.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.week2.data.MainViewModel;
import com.example.week2.databinding.ActivityMainBinding;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBindingVar;
    private MainViewModel model;
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        activityMainBindingVar=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBindingVar.getRoot());
// Initialize ViewModel
        model = new ViewModelProvider(this).get(MainViewModel.class);

        model.editString.observe(this,s -> {

            activityMainBindingVar.txt1.setText("Hello: "+model.editString.getValue());

        });

        btn1=activityMainBindingVar.btn1;

        btn1.setOnClickListener((View v)->{

            model.editString.postValue( activityMainBindingVar.edt1.getText().toString());


        });






    }
}