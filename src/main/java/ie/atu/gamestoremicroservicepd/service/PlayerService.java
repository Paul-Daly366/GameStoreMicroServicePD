package ie.atu.gamestoremicroservicepd.service;

import ie.atu.gamestoremicroservicepd.model.Player;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    private final List<Player> players = new ArrayList<>();
    private long nextId = 1;

    public Player addPlayer(Player player){
        player.setId(nextId++);
        players.add(player);
        return player;
    }

    public List<Player> getAllPlayers(){
        return players;
    }

    public Player getPlayerById(int id){
        return players.get(id);
    }

    public Player addCredit(double credit, int id){
        Player temp = players.getPlayerById(id);
        temp.setCredit(temp.getCredit() + credit);
        return temp;
    }
}
