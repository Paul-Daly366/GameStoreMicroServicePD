package ie.atu.gamestoremicroservicepd.service;

import ie.atu.gamestoremicroservicepd.model.Player;
import ie.atu.gamestoremicroservicepd.repository.PlayerRepo;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    private List<Player> players;
    private final PlayerRepo playerRepo;

    public PlayerService(PlayerRepo playerRepo) {
        this.playerRepo = playerRepo;
    }

    public Player addPlayer(@Valid Player player){
        playerRepo.save(player);
        return player;
    }

    public List<Player> getAllPlayers(){
        return playerRepo.findAll();
    }

    public Player getPlayerById(long playerId){
        return playerRepo.findByPlayerId(playerId);
    }

    public double addCredit(double credit, Long playerId){
        Player temp = playerRepo.findByPlayerId(playerId);
        temp.setCredit(temp.getCredit()+credit);
        playerRepo.save(temp);
        return temp.getCredit();
    }
}
