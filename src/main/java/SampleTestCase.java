import models.User;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Andrey on 17.08.2017.
 */
public class SampleTestCase {
    @Test
    public void testUserInfoResponse(){
//RestTemplate - класс позволяющий елать различные запросы
        RestTemplate restTemplate = new RestTemplate();
         User user = restTemplate.getForObject("https://api.github.com/users/bzhest", User.class);//2-й аргумент - это класс, с помощью которого будем мапить JSON
        System.out.println(user);

    }
}
