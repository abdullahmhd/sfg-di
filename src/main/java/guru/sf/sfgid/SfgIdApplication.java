package guru.sf.sfgid;

import guru.sf.sfgid.controllers.*;
import guru.sf.sfgid.services.CustomJmsProps;
import guru.sf.sfgid.services.CustomProps;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgIdApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SfgIdApplication.class, args);

        CustomProps customProps = ctx.getBean(CustomProps.class);
        System.out.println("------CustomProps--------");
        System.out.println("guru.test.user: "+customProps.getUser());
        System.out.println("guru.test.url: "+customProps.getUrl());

        CustomJmsProps customJmsProps = ctx.getBean(CustomJmsProps.class);
        System.out.println("------CustomJmsProps--------");
        System.out.println("guru.jms.jmsUser: "+customJmsProps.getJmsUser());
        System.out.println("guru.jms.jmsUrl: "+customJmsProps.getJmsUrl());

        PetController petController = ctx.getBean("petController", PetController.class);
        System.out.println("--- The Best Pet is ---");
        System.out.println(petController.whichPetIsTheBest());

        System.out.println("------- Profile/I18N");
        I18nController i18nController = (I18nController) ctx.getBean("i18nController");
        System.out.println(i18nController.sayHello());

        System.out.println("-------- Primary/Default");
        MyController myController = (MyController) ctx.getBean("myController");
        System.out.println(myController.sayGreeting());

        System.out.println("-------- Property");
        PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
        System.out.println(propertyInjectedController.getGreetings());

        System.out.println("-------- Setter");
        SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
        System.out.println(setterInjectedController.getGreetings());

        System.out.println("-------- Constructor");
        ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
        System.out.println(constructorInjectedController.getGreetings());

    }

}
