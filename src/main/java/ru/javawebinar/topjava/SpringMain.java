package ru.javawebinar.topjava;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.web.user.AdminRestController;

import java.util.Arrays;

public class SpringMain {
    public static void main(String[] args) {
        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml")) {
            System.out.println("Bean definition names : " + Arrays.toString(appCtx.getBeanDefinitionNames()));

            AdminRestController adminRestController = appCtx.getBean(AdminRestController.class);
            adminRestController.create(new User(null, "userNameAdmin", "email1", "password1", Role.ROLE_ADMIN));
            appCtx.close();
        }
    }
}
