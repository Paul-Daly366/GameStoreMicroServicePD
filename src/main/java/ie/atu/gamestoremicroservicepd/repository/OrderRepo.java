package ie.atu.gamestoremicroservicepd.repository;

import ie.atu.gamestoremicroservicepd.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order,Long> {
    Order getByOrderId(Long orderId);
    List<Order> getAllByPurchaserNickname(String purchaserNickname);
    List<Order> getAllBySoldGame(String soldGame);
}
