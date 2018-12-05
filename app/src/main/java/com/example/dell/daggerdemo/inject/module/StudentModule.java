package com.example.dell.daggerdemo.inject.module;


import com.example.dell.daggerdemo.bean.Student;
import com.example.dell.daggerdemo.inject.scope.ActivityScope;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class StudentModule {


    public StudentModule(){ }

    //假设我现在想在AppModule里面实例化
    @Provides
    @Singleton
    public Student providerStudent(){
        return new Student();
    }

}
