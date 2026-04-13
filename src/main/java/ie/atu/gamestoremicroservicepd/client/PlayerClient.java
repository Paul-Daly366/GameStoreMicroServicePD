package ie.atu.gamestoremicroservicepd.client;

import ie.atu.gamestoremicroservicepd.model.Player;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="LoginStoreMicSerPD", url="http://localhost:8081")
public interface PlayerClient {

    @GetMapping("/players/id/{playerId}")
    Player retrievePlayerByPlayerId(@PathVariable Long playerId);

    @GetMapping("/players/nickname/{nickname}")
    Player retrievePlayerByNickname(@PathVariable String nickname);
}
