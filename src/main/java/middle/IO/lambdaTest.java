package middle.IO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class lambdaTest {

    public static void main(String[] args) {

        List<User> userList = new ArrayList<>();
        userList.add(new User(1L, "aaa"));
        userList.add(new User(2L, "bbb"));
        userList.add(new User(3L, "ccc"));
        userList.add(new User(4L, "ddd"));
        userList.add(new User(5L, "eee"));

        Map<Long, String> map = userList.stream()
                .collect(Collectors.toMap(User::getId, User::getUsername));

        map.forEach((a,b)->{
            System.out.println("key: "+a);
            System.out.println("value: "+b);

        } );
    }
}

class User{
    private Long id;
    private String username;

    public User(Long id, String desc) {
        this.id = id;
        this.username = desc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}