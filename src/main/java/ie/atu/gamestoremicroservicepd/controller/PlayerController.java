package ie.atu.gamestoremicroservicepd.controller;

import ie.atu.gamestoremicroservicepd.model.Player;
import ie.atu.gamestoremicroservicepd.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/login-by-id/{playerId}")
    public ResponseEntity<Player> addPlayerById(@PathVariable Long playerId) {
        Player saved = playerService.addPlayerFromLoginMicroServiceByPlayerId(playerId);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/login-by-nickname/{nickname}")
    public ResponseEntity<Player> addPlayerByNickname(@PathVariable String nickname) {
        Player saved = playerService.addPlayerFromLoginMicroServiceByPlayerNickname(nickname);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Player>> getAllPlayers() {
        return ResponseEntity.status(HttpStatus.OK).body(playerService.getAllPlayers());
    }

    @GetMapping("/id/{playerId}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Integer playerId) {
        return ResponseEntity.status(HttpStatus.OK).body(playerService.getByPlayerId(playerId));
    }

    @GetMapping("/name/{playerName}")
    public ResponseEntity<List<Player>> getByPlayerName(@PathVariable String playerName) {
        return ResponseEntity.status(HttpStatus.OK).body(playerService.getByPlayerName(playerName));
    }

    @GetMapping("/nickname/{nickname}")
    public ResponseEntity<Player> getByNickname(@PathVariable String nickname) {
        return ResponseEntity.status(HttpStatus.OK).body(playerService.getPlayerByNickname(nickname));
    }

    @GetMapping("/addCredit/{nickname}&{credit}")
    public ResponseEntity<String> addCredit(@PathVariable("nickname") String nickname,@PathVariable("credit") double credit) {
        return ResponseEntity.ok(playerService.addCredit(credit,nickname));
    }
}
