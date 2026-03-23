package ie.atu.gamestoremicroservicepd.repository;

import ie.atu.gamestoremicroservicepd.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepo extends JpaRepository<Game,Long> {
    Game findGameByGameId(Long gameId);
    Game findGameByName(String name);
}
