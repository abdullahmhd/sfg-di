package guru.sf.sfgid.controllers;

import guru.sf.sfgid.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjectedController {

    @Autowired
    public GreetingService greetingService;

    public String  getGreetings() {
        return greetingService.sayHello();
    }

}
