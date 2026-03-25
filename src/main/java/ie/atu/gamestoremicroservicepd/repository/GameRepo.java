package ie.atu.gamestoremicroservicepd.repository;

import ie.atu.gamestoremicroservicepd.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepo extends JpaRepository<Game,Long> {
    Game getGameByGameId(Long gameId);
    Game getGameByGameName(String gameName);
    List<Game> getGamesByPublisher(String publisher);
}
