package com.example.dell.daggerdemo.inject.scope;

import javax.inject.Scope


@Scope  //声明这是一个自定义@Scope注解
@Retention(AnnotationRetention.RUNTIME)
annotation class  ActivityScope {

}
