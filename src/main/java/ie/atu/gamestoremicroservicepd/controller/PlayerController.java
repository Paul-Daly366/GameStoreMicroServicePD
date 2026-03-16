package ie.atu.gamestoremicroservicepd.controller;

import ie.atu.gamestoremicroservicepd.model.Player;
import ie.atu.gamestoremicroservicepd.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        Player saved = playerService.addPlayer(player);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers() {
        return ResponseEntity.status(HttpStatus.OK).body(playerService.getAllPlayers());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(playerService.getPlayerById(id));
    }

    @GetMapping("/addCredit/{id}/{credit}")
    public ResponseEntity<String> addCredit(@PathVariable("id") int id,@PathVariable("credit") int credit) {
        return ResponseEntity.ok(playerService.addCredit(credit,id));
    }
}
