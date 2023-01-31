package middle.generic;

import org.junit.jupiter.api.Test;

/**
 * 泛型例子
 *
 * @author 谢子轩
 * @date 2021/10/31 14/55
 */
public class GenericDemo {

    class ImGenericClass<T>{
        private T date;

        public ImGenericClass(T date) {
            this.date = date;
        }
    }

    @Test
    public void genericClass(){

    }

    public static void main(String[] args) {
        GenericDemo a = new GenericDemo();
        int i = a.hashCode();
        System.out.println(i);
    }
}
