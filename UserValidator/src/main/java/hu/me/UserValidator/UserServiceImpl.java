package hu.me.UserValidator;

import java.util.ArrayList;

public class UserServiceImpl implements UserService {

    @Override
    public void saveUser(User user) {
        ArrayList<User> userList = new ArrayList<>();
        userList.add(user);
    }

}
