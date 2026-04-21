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
        //Not allowing multiples games with the same name, for copyright and player ease of use
        games = gameRepo.findAll();
        for (Game existing : games) {
            if (existing.getGameName().equals(game.getGameName())) {
                throw new NameConflictException("Game name already exists");
            }
        }
        gameRepo.save(game);
        return game;
    }

    public List<Game> getAllGames(){
        return gameRepo.findAll();
    }

    public Game getByGameId(Long id){
        return gameRepo.getGameByGameId(id);
    }

    public Game getByGameName(String name){
        return gameRepo.getGameByGameName(name);
    }

    public List<Game> getGamesByPublisher(String publisher){
        return gameRepo.getGamesByPublisher(publisher);
    }

    public String getGameSales(String gameName){
        games = gameRepo.findAll();
        for(Game game:games){
            if(game.getGameName().equals(gameName)){
                return String.format("%s sales: %2d", game.getGameName(), game.getSales());
            }
        }
        return "No game by that name found.";
    }

    public String getAllGameSalesByPublisher(String publisher){
        games = gameRepo.findAll();
        String fullSalesReport = String.format("%s sales: \n", publisher);
        String tempString = "";
        for(Game game:games){
            if(game.getPublisher().equals(publisher)){
                tempString = getGameSales(game.getGameName()) + "\n";
                fullSalesReport = fullSalesReport.concat(tempString);
            }
        }
        if(fullSalesReport.equals(String.format("%s sales: \n", publisher))){
            return "No games found by that publisher";
        }
        return fullSalesReport;
    }
}
