package service;

import repository.UserRepository;
import models.UserDTO;

public class UserService {
    private final UserRepository userRepository = new UserRepository();

    public int registerUser(UserDTO user) {
        return userRepository.registerUser(user);
    }

    public UserDTO findUserById(int id) {
        return userRepository.findUserById(id);
    }

    public UserDTO findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    public static void main(String[] args) {
        try{
            UserService userService = new UserService();
            System.out.println(userService.registerUser(new UserDTO("hahaha", "test", "test")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
