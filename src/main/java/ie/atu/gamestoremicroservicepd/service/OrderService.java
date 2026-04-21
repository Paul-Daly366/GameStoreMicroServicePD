package ie.atu.gamestoremicroservicepd.service;

import ie.atu.gamestoremicroservicepd.model.Game;
import ie.atu.gamestoremicroservicepd.model.Order;
import ie.atu.gamestoremicroservicepd.model.Player;
import ie.atu.gamestoremicroservicepd.repository.GameRepo;
import ie.atu.gamestoremicroservicepd.repository.OrderRepo;
import ie.atu.gamestoremicroservicepd.repository.PlayerRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private List<Player> players;
    private List<Game> games;
    private OrderRepo orderRepo;
    private final GameRepo gameRepo;
    private final PlayerRepo playerRepo;

    public OrderService(OrderRepo orderRepo, GameRepo gameRepo, PlayerRepo playerRepo) {
        this.orderRepo = orderRepo;
        this.gameRepo = gameRepo;
        this.playerRepo = playerRepo;
    }

    public String playerPurchaseGame(String purchaserNickname, String soldGame){
        String result = "Unknown Error.";
        boolean noGameFound = false; //Error handling booleans
        boolean noPlayerFound = false; //I found the for loops difficult to save intended strings
        boolean notEnoughCredit = false;
        players = playerRepo.findAll(); //To find the correct player entity
        games = gameRepo.findAll(); //To find the correct game entity

        for(Player currentPlayer : players){
            if(currentPlayer.getNickname().equals(purchaserNickname)){
                noPlayerFound = false;
                for(Game currentGame : games){
                    if(currentGame.getGameName().equals(soldGame)){
                        noGameFound = false;
                        if(currentPlayer.getCredit()>=currentGame.getPrice()){
                            currentPlayer.setCredit(currentPlayer.getCredit()-currentGame.getPrice());
                            playerRepo.save(currentPlayer);
                            Order order = new Order();
                            order.setPurchaserNickname(purchaserNickname);
                            order.setGameCreatorName(currentGame.getPublisher());
                            order.setSoldGame(soldGame);
                            orderRepo.save(order);
                            result = "Purchase successful";
                            return result; //Rest of loop irrelevant, ends function here
                        }
                        else{ //Correct player & game, but not enough credit
                            notEnoughCredit = true;
                        }
                        break;
                    }
                    else{ //Correct player, but incorrect game
                        noGameFound = true;
                    }
                }
                break;
            }
            else{ //Incorrect player
                noPlayerFound = true;
            }
        }
        if(notEnoughCredit){
            result = "Purchase failed, not enough credit in account.";
        }
        else if (noPlayerFound) {
            result = "Purchase failed, no player by that nickname in database.";
        }
        else if (noGameFound) {
            result = "Purchase failed, no game by that name in database.";
        }
        return result;
    }

    public List<Order> getAllOrders(){
        return orderRepo.findAll();
    }

    public Order getOrderById(Long orderId){
        return orderRepo.getByOrderId(orderId);
    }


    public List<Order> getAllByPurchaserNickname(String purchaserNickname){
        return orderRepo.getAllByPurchaserNickname(purchaserNickname);
    }

    public List<Order> getAllBySoldGame(String soldGame){
        return orderRepo.getAllBySoldGame(soldGame);
    }
}
