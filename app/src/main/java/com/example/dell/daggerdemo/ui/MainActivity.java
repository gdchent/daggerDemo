package com.example.dell.daggerdemo.ui;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dell.daggerdemo.R;
import com.example.dell.daggerdemo.bean.Student;
import com.example.dell.daggerdemo.databinding.ActivityMainBinding;
import com.example.dell.daggerdemo.inject.component.AppComponent;
import com.example.dell.daggerdemo.inject.component.DaggerAppComponent;
import com.example.dell.daggerdemo.inject.component.DaggerStudentComponent;
import com.example.dell.daggerdemo.inject.module.AppModule;
import com.example.dell.daggerdemo.inject.module.StudentModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {


    @Inject
    Student student1;

    @Inject
    Student student2;

    ActivityMainBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setMainAct(this);

        AppComponent appComponent=DaggerAppComponent.builder().appModule(new AppModule()).build();
        DaggerStudentComponent.builder().appComponent(appComponent).studentModule(new StudentModule()).build().inject(this);
        binding.tvTest.setText(student1.toString()+","+student2.toString());


    }
}
