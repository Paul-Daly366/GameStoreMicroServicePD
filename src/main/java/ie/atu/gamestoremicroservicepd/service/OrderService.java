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
    private List<Order> orders;
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
        players = playerRepo.findAll();
        games = gameRepo.findAll();
        //orders = orderRepo.findAll();
        //Player not enough credit

        for(Player currentPlayer : players){
            if(currentPlayer.getNickname().equals(purchaserNickname)){
                for(Game currentGame : games){
                    if(currentGame.getGameName().equals(soldGame)){
                        Order order = new Order();
                        order.setPurchaserNickname(purchaserNickname);
                        order.setGameCreatorName(currentGame.getPublisher());
                        order.setSoldGame(soldGame);
                        orderRepo.save(order);
                        return "Purchase successful";
                        //return "Function Success"; //Test sentence to test the if & for loops logic
                    }
                    else{
                        return "Purchase failed, no game by that name in database.";
                    }
                }
            }
            else{
                return "Purchase failed, no player by that nickname in database.";
            }
        }

        return "Purchase failed, unknown error.";
    }

    public List<Order> getAllOrders(){
        return orderRepo.findAll();
    }

    public Order getOrderById(Long orderId){
        return orderRepo.getByOrderId(orderId);
    }

    /*
    public List<Order> getAllOrdersByPurchaserNickname(String purchaserNickname){
        return orderRepo.getAllOrdersByPurchaserNickname(purchaserNickname);
    }

    public List<Order> getAllOrdersOfSoldGame(String soldGame){
        return orderRepo.getAllOrdersOfSoldGame(soldGame);
    }*/
}
