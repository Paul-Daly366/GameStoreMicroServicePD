/* NON FUNCTIONAL ATM
package ie.atu.gamestoremicroservicepd.DataLoader;

import ie.atu.gamestoremicroservicepd.model.Player;
import ie.atu.gamestoremicroservicepd.repository.PlayerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(PlayerRepo playerRepo){
        return args -> {
            if (playerRepo.count() > 0){
                return;
            }
            Player p1 = new  Player();
            p1.setPlayerId(0L);
            p1.setPlayerName("Paul");
            p1.setEmail("pd366@atu.ie");
            p1.setNickname("Pd366");
            p1.setCredit(20.0);
            playerRepo.save(p1);

            Player p2 = new  Player();
            p2.setPlayerId(1L);
            p2.setPlayerName("Isabel");
            p2.setEmail("ir7@atu.ie");
            p2.setNickname("Ir7");
            p2.setCredit(30.0);
            playerRepo.save(p2);
            System.out.println("Dummy player data loaded");
        };
    }
} */
