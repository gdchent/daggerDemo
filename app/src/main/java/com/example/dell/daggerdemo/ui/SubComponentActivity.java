package com.example.dell.daggerdemo.ui;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dell.daggerdemo.R;
import com.example.dell.daggerdemo.bean.Student;
import com.example.dell.daggerdemo.databinding.ActivitySubComponentBinding;
import com.example.dell.daggerdemo.inject.component.AppComponent;
import com.example.dell.daggerdemo.inject.component.ApplicationComponent;
import com.example.dell.daggerdemo.inject.component.DaggerAppComponent;
import com.example.dell.daggerdemo.inject.component.DaggerApplicationComponent;
import com.example.dell.daggerdemo.inject.module.AppModule;
import com.example.dell.daggerdemo.inject.module.StudentSubModule;

import javax.inject.Inject;

public class SubComponentActivity extends AppCompatActivity {



    @Inject
    Student student1 ;
    @Inject Student student2;

    ActivitySubComponentBinding binding=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=DataBindingUtil.setContentView(this,R.layout.activity_sub_component);
        binding.setVm(this);
        //该Activity使用的是component跟Subcomponent结合的方式
        ApplicationComponent applicationComponent =DaggerApplicationComponent.builder().build();
         //然后父组件添加子组件
        applicationComponent.addStudentSubcomponent(new StudentSubModule()).inject(this);

        binding.tvTest.setText("学生一的内存地址："+student1.toString()+",学生二内存地址："+student2.toString());
    }
}
