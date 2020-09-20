package proxy;

public class TakeMethod {
    public static void main(String[] args) {
        HelloServiceProxy helloServiceProxy = new HelloServiceProxy();
        HelloService bind = (HelloService) helloServiceProxy.bind(new HelloServiceImpl());
        bind.sayHello("tom");
    }
}
