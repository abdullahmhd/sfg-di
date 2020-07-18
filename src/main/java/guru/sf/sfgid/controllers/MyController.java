package guru.sf.sfgid.controllers;

import guru.sf.sfgid.services.GreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    private GreetingService greetingService;

    public MyController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello() {

        return this.greetingService.sayHello();
    }
}
