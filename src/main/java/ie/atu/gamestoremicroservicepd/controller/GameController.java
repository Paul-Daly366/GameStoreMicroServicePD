package ie.atu.gamestoremicroservicepd.controller;

import ie.atu.gamestoremicroservicepd.model.Game;
import ie.atu.gamestoremicroservicepd.service.GameService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    public ResponseEntity<Game> addGame(@Valid @RequestBody Game game) {
        Game saved = gameService.addGame(game);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Game>> getAllGames() {
        return ResponseEntity.ok(gameService.getAllGames());
    }

    @GetMapping("/id/{gameId}")
    public ResponseEntity<Game> getGameById(@PathVariable("gameId") Long gameId) {
        return ResponseEntity.ok(gameService.getByGameId(gameId));
    }

    @GetMapping("/name/{gameName}")
    public ResponseEntity<Game> getGameByName(@PathVariable("gameName") String gameName) {
        return ResponseEntity.ok(gameService.getByGameName(gameName));
    }

    @GetMapping("/publisher/{publisher}")
    public ResponseEntity<List<Game>> getGamesByPublisher(@PathVariable("publisher") String publisher) {
        return  ResponseEntity.ok(gameService.getGamesByPublisher(publisher));
    }
}
