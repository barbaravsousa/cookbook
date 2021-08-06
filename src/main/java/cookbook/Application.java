package cookbook;

import org.springframework.boot.SpringApplication;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@NoArgsConstructor
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
