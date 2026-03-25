package ie.atu.gamestoremicroservicepd.repository;

import ie.atu.gamestoremicroservicepd.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepo extends JpaRepository<Player, Long> {
    Player getByPlayerId(Long playerId);
    List<Player> getByPlayerName(String playerName);
    Player getByNickname(String nickname);
}
