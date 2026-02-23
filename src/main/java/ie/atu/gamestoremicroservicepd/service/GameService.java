package ie.atu.gamestoremicroservicepd.service;

import ie.atu.gamestoremicroservicepd.model.Game;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    private final List<Game> games = new ArrayList<>();
    private long nextId = 1;

    public Game addGame(Game game){
        game.setId(nextId++);
        games.add(game);
        return game;
    }

    public List<Game> getAllGames(){
        return games;
    }
}
