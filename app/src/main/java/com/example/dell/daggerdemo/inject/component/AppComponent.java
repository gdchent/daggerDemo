package com.example.dell.daggerdemo.inject.component;


import com.example.dell.daggerdemo.bean.Student;
import com.example.dell.daggerdemo.inject.module.AppModule;
import com.example.dell.daggerdemo.inject.scope.ActivityScope;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class})
public interface AppComponent {

}
