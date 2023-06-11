import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MockingTest {
    @Mock
    private UserService userService;

    private final UserController userController;

    public MockingTest() {
        MockitoAnnotations.openMocks(this);
        userController = new UserController(userService);
    }

    @Test
    public void testGetUser() {
        // Arrange
        int userId = 1;
        User expectedUser = new User(userId, "John Doe");
        when(userService.getUserById(userId)).thenReturn(expectedUser);

        // Act
        User actualUser = userController.getUser(userId);

        // Assert
        assertEquals(expectedUser, actualUser);
        verify(userService, times(1)).getUserById(userId);
    }

    @Test
    public void testCreateUser() {
        // Arrange
        User newUser = new User(2, "Jane Smith");

        // Act
        userController.createUser(newUser);

        // Assert
        verify(userService, times(1)).addUser(newUser);
    }
}

