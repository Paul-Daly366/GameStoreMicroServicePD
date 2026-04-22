package ie.atu.gamestoremicroservicepd.service;

import ie.atu.gamestoremicroservicepd.client.PlayerClient;
import ie.atu.gamestoremicroservicepd.exception.NameConflictException;
import ie.atu.gamestoremicroservicepd.model.Player;
import ie.atu.gamestoremicroservicepd.repository.PlayerRepo;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepo playerRepo;
    private final PlayerClient playerClient;

    List<Player> players;

    public PlayerService(PlayerRepo playerRepo, PlayerClient playerClient) {
        this.playerRepo = playerRepo;
        this.playerClient = playerClient;
    }

    //Methods to retrieve players from another microservice
    //This method retrieves via playerId
    //This also checks that the incoming object doesn't already exist in the repository
    public Player addPlayerFromLoginMicroServiceByPlayerId(Long playerId){
        players = playerRepo.findAll();
        for(Player existing : players){
            if(existing.getPlayerId().equals(playerId)){
                return existing;
            }
        }

        Player player = playerClient.retrievePlayerByPlayerId(playerId);
        playerRepo.save(player);
        return player;
    }
    //This method retrieves via nickname (also unique to each object)
    public Player addPlayerFromLoginMicroServiceByPlayerNickname(String nickname){
        players = playerRepo.findAll();
        for(Player existing : players){
            if(existing.getNickname().equals(nickname)){
                return existing;
            }
        }

        Player player = playerClient.retrievePlayerByNickname(nickname);
        playerRepo.save(player);
        return player;
    }

    //Post method, for testing outside of OpenFeign communication
    public Player testFuncPostPlayer(@Valid Player player){
        players = playerRepo.findAll();
        for(Player existing : players){
            if(existing.getNickname().equals(player.getNickname())){
                throw new NameConflictException("Player nickname already exists");
            }
        }
        playerRepo.save(player);
        return player;
    }

    //Get methods
    public List<Player> getAllPlayers(){
        return playerRepo.findAll();
    }

    public Player getByPlayerId(long playerId){
        return playerRepo.getByPlayerId(playerId);
    }

    public List<Player> getByPlayerName(String playerName){
        return playerRepo.getByPlayerName(playerName);
    }

    public Player getPlayerByNickname(String nickname){
        return playerRepo.getByNickname(nickname);
    }

    //Method to alter credit in player object, real code would communicate with a money microservice
    public String addCredit(double credit, String nickname){
        Player temp = playerRepo.getByNickname(nickname);
        temp.setCredit(temp.getCredit()+credit);
        playerRepo.save(temp);
        return "Credit added successfully";
    }
}
