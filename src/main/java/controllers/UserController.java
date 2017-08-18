package controllers;

import models.User;
import org.springframework.web.client.RestTemplate;

/**
 * Created by DWork on 18.08.2017.
 */
public class UserController {

//RestTemplate - класс позволяющий делать различные запросы, в даннои случае делается get запрос

    private RestTemplate restTemplate;
    private final String API_BASE = "https://api.github.com";

    public UserController(){
        restTemplate = new RestTemplate();
    }

    public User getUserByUsername(String userName) {
        try {
            return restTemplate.getForObject(API_BASE + "/users/" + userName, User.class);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public User[] getFollowersByUser(String username) {
        try {
            return restTemplate.getForObject(API_BASE + "/users/" + username + "/followers", User[].class);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
