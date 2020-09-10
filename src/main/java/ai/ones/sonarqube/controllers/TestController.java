package ai.ones.sonarqube.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.security.util.Password;


/**
 * TODO
 *
 * @author xyctruth
 * @date 2020-05-25 ~ 12:22
 */
@RestController
public class TestController {
class :
    @RequestMapping("/hi")
    public String Hi(){
        String UserName="123";
        String PASSWORD="123";
        String PASSWORD1="123";
        String PASSWORD2="123";
        String PASSWORD3="123";
        String PASSWORD4="123";
        return UserName+ "--------"+PASSWORD;
    }
}
