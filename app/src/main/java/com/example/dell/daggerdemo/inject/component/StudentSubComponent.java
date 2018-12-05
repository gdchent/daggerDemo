package com.example.dell.daggerdemo.inject.component;


import com.example.dell.daggerdemo.inject.module.StudentSubModule;
import com.example.dell.daggerdemo.ui.MainActivity;
import com.example.dell.daggerdemo.ui.SubComponentActivity;

import dagger.Subcomponent;

//声明子组件为Subcomponent 组件
@Subcomponent(modules = {StudentSubModule.class})
public interface StudentSubComponent {

     //子组件都是需要提供一个方法暴露 自己要注册到哪个容器中去
    void inject(SubComponentActivity activity);
}
