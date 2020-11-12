package ohtu.services;

import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;
import ohtu.data_access.UserDao;

public class AuthenticationService {

    private UserDao userDao;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(String username, String password) {
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean invalid(String username, String password) {
        // validity check of username and password

        //username taken
        if (userDao.findByName(username) != null) {
            return true;
        }

        //username too short
        if (username.length() < 3) {
            return true;
        }

        //password too short
        if (password.length() < 8) {
            return true;
        }

        //password consists of only letters
        int nonLetters = 0;
        for (char c : password.toCharArray()) {
            if (!Character.isLetter(c)) {
                nonLetters++;
            }
        }

        if (nonLetters < 1) {
            return true;
        }



        //otherwise return false
        return false;
    }
}
