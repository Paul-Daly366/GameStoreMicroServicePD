package ie.atu.gamestoremicroservicepd.service;

import ie.atu.gamestoremicroservicepd.client.PlayerClient;
import ie.atu.gamestoremicroservicepd.controller.PlayerController;
import ie.atu.gamestoremicroservicepd.exception.NameConflictException;
import ie.atu.gamestoremicroservicepd.model.Player;
import ie.atu.gamestoremicroservicepd.repository.PlayerRepo;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private List<Player> players;
    private final PlayerRepo playerRepo;
    private final PlayerClient playerClient;

    public PlayerService(PlayerRepo playerRepo, PlayerClient playerClient) {
        this.playerRepo = playerRepo;
        this.playerClient = playerClient;
    }

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

    public String addCredit(double credit, String nickname){
        Player temp = playerRepo.getByNickname(nickname);
        temp.setCredit(temp.getCredit()+credit);
        playerRepo.save(temp);
        return "Credit added successfully";
    }
}
