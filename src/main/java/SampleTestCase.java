import controllers.UserController;
import models.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

/**
 * Created by Andrey on 17.08.2017.
 */
public class SampleTestCase {

    private UserController userController;


    @Before
    public void setUp() {
        userController = new UserController();
    }

    @Test
    public void testUserInfoResponse() {
        User remoteUser = userController.getUserByUsername("bzhest");
        assertTrue(remoteUser.getHtml_url().contains("https://github.com/bzhest"));
    }

    @Test
    public void testFollowers() {
        User [] followers = userController.getFollowersByUser("bzhest");
        assertTrue(followers.length == 1);
    }
}
