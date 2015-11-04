package recipe.app;

import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.jsondoc.springmvc.scanner.Spring4JSONDocScanner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Import;
import recipe.config.ApplicationConfiguration;

@Import(ApplicationConfiguration.class)
@EnableJSONDoc
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}