package ie.atu.gamestoremicroservicepd.service;

import ie.atu.gamestoremicroservicepd.exception.NameConflictException;
import ie.atu.gamestoremicroservicepd.model.Game;
import ie.atu.gamestoremicroservicepd.repository.GameRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private final GameRepo gameRepo;
    private List<Game> games;

    public GameService(GameRepo gameRepo) {
        this.gameRepo = gameRepo;
    }

    public Game addGame(Game game){
        //Confirm the name doesn't already exist
        games = gameRepo.findAll();
        for (Game existing : games) {
            if (existing.getName().equals(game.getName())) {
                throw new NameConflictException("Game name already exists");
            }
        }
        gameRepo.save(game);
        return game;
    }

    public Game findByGameId(Long id){
        return gameRepo.findGameByGameId(id);
    }

    public Game findByGameName(String name){
        return gameRepo.findGameByName(name);
    }

    public List<Game> getAllGames(){
        return gameRepo.findAll();
    }
}
