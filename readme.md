https://blog.csdn.net/soslinken/article/details/70231089
/**
* Component跟SubComponent的区别
* 1.方式一：如果全部都是使用Component 然后使用dependence属性来依赖====子组件为主角 父组件暴露方法给子组件注入到容器
* 逻辑分析：
* 第一步：那就是父组件需要暴露 容器（Activity/Fragment）所需要的实例
* daggger里面会首先执行以下代码：===目标是先生成父组件的实例
* 父组件写法如下:
* @Component(modules={AppModule.class})
* public interface AppComponent {
*//将AppModule中的SomeClassA1暴露出来，以便于其他依赖于AppComponent的Component调用
* SomeClassA1 someClassA1();
*//UserDaggerPresenterComponent依赖相当于继承AppComponent 因为子组件 需要一个IBasePresenter 而子组件所对应
* 的module并没有提供 如果需要父组件提供 那么父组件需要暴露一个Presenter
* IBasePresenter getPresenter();
*}
* Activity生成代码如下：
* ApplicationModule applicationModule=new ApplicationModule(this);
* DaggerApplicationComponent.builder().applicationModule(applicationModule).build(); //生成父组件实例
* 第二步：生成子类的实例
* UserDaggerPresenterSubComponent userDaggerPresenterSubComponent=UserDaggerPresenterSubComponent.builder().appComponent(appComponent).studentModule(new StudentModule()).build().inject(this)
* 2. 方式二：如果是使用Component跟SubComponent的结合方式====这种方式父组件为主角 父组件添加 子组件做注入到容器里面
* 逻辑分析：
* 父组件添加一个返回子组件的实例
* UserDaggerPresenterSubComponent addSub(UserDaggerSubPresenterModule module);
* 子组件注入方法
* void inject(UserSubDaggerActivity activity);
*/