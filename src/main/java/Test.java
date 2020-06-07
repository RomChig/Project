import com.roma.models.User;
import com.roma.services.serviceImpl.UserServiceImpl;

import java.util.Optional;


public class Test {
    public static void main(String[] args) {
        Optional<User> user = new UserServiceImpl().findByName("Roma");
        System.out.println(user);
    }
}
