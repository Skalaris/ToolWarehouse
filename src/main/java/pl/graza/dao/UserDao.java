package pl.graza.dao;

import pl.graza.model.User;

import java.util.Optional;

public interface UserDao {

    Optional<User> getUser(String login);
}
