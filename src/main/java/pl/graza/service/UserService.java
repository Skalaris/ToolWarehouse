package pl.graza.service;

import pl.graza.dao.UserDao;
import pl.graza.dao.UserDaoImpl;
import pl.graza.model.User;
import java.util.Optional;

public class UserService {

    private UserDao userDao = new UserDaoImpl();

    public boolean isUserValid (String login,String password){
        return userDao.getUser(login)
                .map(user -> password.equals(user.getPassword()) && login.equals(user.getLogin()))
                .orElse(false);

       /* Optional<User> optionalUser = userDao.getUser(login);
        if(optionalUser.isPresent()){
            User user= (User) optionalUser.get();
            if(user.getPassword().equals(password)){
                return true;
            }
        }
        return false;*/
    }

}
