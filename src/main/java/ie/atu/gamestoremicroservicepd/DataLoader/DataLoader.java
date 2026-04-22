
package ie.atu.gamestoremicroservicepd.DataLoader;

import ie.atu.gamestoremicroservicepd.model.Creator;
import ie.atu.gamestoremicroservicepd.model.Game;
import ie.atu.gamestoremicroservicepd.model.Player;
import ie.atu.gamestoremicroservicepd.repository.CreatorRepo;
import ie.atu.gamestoremicroservicepd.repository.GameRepo;
import ie.atu.gamestoremicroservicepd.repository.PlayerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(PlayerRepo playerRepo, CreatorRepo creatorRepo, GameRepo gameRepo) {
        return args -> {
            if (playerRepo.count() == 0){
                Player p1 = new Player();
                p1.setPlayerName("Paul");
                p1.setEmail("pd366@atu.ie");
                p1.setNickname("Pd366");
                p1.setCredit(40.0);
                playerRepo.save(p1);

                Player p2 = new Player();
                p2.setPlayerName("Isabel");
                p2.setEmail("ir7@atu.ie");
                p2.setNickname("Ir7");
                p2.setCredit(60.0);
                playerRepo.save(p2);
                System.out.println(" ~~~ Pre-made Player data loaded");
            }
            if(creatorRepo.count() == 0){
                Creator c1 = new Creator();
                c1.setCreatorName("Mojang");
                c1.setCreatorEmail("mojang@store.ie");
                creatorRepo.save(c1);

                Creator c2 = new Creator();
                c2.setCreatorName("Nintendo");
                c2.setCreatorEmail("nintendo@store.ie");
                creatorRepo.save(c2);
                System.out.println(" ~~~ Pre-made Creator data loaded");
            }
            if(gameRepo.count() == 0){
                Game g1 = new Game();
                g1.setGameName("Minecraft");
                g1.setPrice(20);
                g1.setPublisher("Mojang");
                g1.setSales(200);
                gameRepo.save(g1);

                Game g2 = new Game();
                g2.setGameName("Pokemon");
                g2.setPrice(60);
                g2.setPublisher("Nintendo");
                g2.setSales(100);
                gameRepo.save(g2);

                Game g3 = new Game();
                g3.setGameName("Minecraft 2");
                g3.setPrice(30);
                g3.setPublisher("Mojang");
                g3.setSales(250);
                gameRepo.save(g3);
                System.out.println(" ~~~ Pre-made Game data loaded");
            }
        };
    }
}
