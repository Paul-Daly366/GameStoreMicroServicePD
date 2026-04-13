package ie.atu.gamestoremicroservicepd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GameStoreMicroServicePdApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameStoreMicroServicePdApplication.class, args);
    }

}
