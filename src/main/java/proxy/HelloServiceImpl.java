package proxy;

public class HelloServiceImpl implements HelloService{
    @Override
    public void sayHello(String name) {
        System.out.println(name+" hello !");
    }
}
