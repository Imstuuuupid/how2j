package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HelloServiceProxy implements InvocationHandler {


    /**
     * 真实服务对象
     * @Author: xzx
     * @Date: 2020/9/15 9:28 上午
     **/
    private Object target;


    /**
     * 绑定服务对象并返回一个代理类
     * @Author: xzx
     * @Date: 2020/9/15 9:28 上午
     * @Param: [target]
     * @Return: java.lang.Object
     **/
    public Object bind(Object target){
        this.target=target;
//        获取代理对象
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("=======================  JDK动态代理  ===================================");
        Object result = null;
//        反射方法前调用
        System.out.println("准备反射了！");
//        反射方法，即调用HelloService的sayHello方法
        result=method.invoke(target,args);
//        反射方法后调用
        System.out.println("反射完成了！");
        return result;
    }
}
