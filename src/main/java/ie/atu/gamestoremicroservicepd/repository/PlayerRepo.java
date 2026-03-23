package ie.atu.gamestoremicroservicepd.repository;

import ie.atu.gamestoremicroservicepd.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepo extends JpaRepository<Player, Long> {
    Player findByPlayerId(Long playerId);
}
