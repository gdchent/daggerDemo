package com.example.dell.daggerdemo.inject.component;

import com.example.dell.daggerdemo.inject.module.ApplicationModule;
import com.example.dell.daggerdemo.inject.module.StudentSubModule;

import dagger.Component;



//父组件
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

     //父组件暴露方法给子组件调用
    StudentSubComponent addStudentSubcomponent(StudentSubModule studentSubModule);
}
