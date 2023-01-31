package senior.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface JdbcCon {

    String ip() default "127.0.0.1";

    int port() default 3306;

    String user();

    String password();

    String database();

    String encoding() default "UTF-8";

}
