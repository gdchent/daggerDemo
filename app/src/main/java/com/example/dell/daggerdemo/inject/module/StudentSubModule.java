package com.example.dell.daggerdemo.inject.module;


import com.example.dell.daggerdemo.bean.Student;

import dagger.Module;
import dagger.Provides;

@Module
public class StudentSubModule {



    //子组件所对应的module创建一个Student实例
    @Provides
    public Student providerStudent(){
        return new Student();
    }
}
