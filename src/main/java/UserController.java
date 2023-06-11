// UserController.java
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public User getUser(int id) {
        return userService.getUserById(id);
    }

    public void createUser(User user) {
        userService.addUser(user);
    }
}
