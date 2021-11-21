package application;

import config.ApplicationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@ComponentScan
@Import(ApplicationConfig.class)
public class ApplicationMain {
    public static void main(String... args){
        SpringApplication.run(ApplicationMain.class, args);

    }
}
