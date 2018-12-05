package com.example.dell.daggerdemo.inject.component;


import com.example.dell.daggerdemo.inject.module.StudentModule;
import com.example.dell.daggerdemo.inject.scope.ActivityScope;
import com.example.dell.daggerdemo.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;
@Singleton
@Component(modules ={StudentModule.class},dependencies = {AppComponent.class})
public interface StudentComponent {

      void inject(MainActivity mainActivity);  //子组件为主角  注入
}
