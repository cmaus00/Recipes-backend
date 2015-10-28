package recipe.app;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Import;
import recipe.config.ApplicationConfiguration;

@Import(ApplicationConfiguration.class)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}