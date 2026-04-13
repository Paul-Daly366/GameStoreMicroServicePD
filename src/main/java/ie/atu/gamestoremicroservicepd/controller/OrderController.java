package ie.atu.gamestoremicroservicepd.controller;

import ie.atu.gamestoremicroservicepd.model.Order;
import ie.atu.gamestoremicroservicepd.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/purchase/{purchaserNickname}&{soldGame}")
    public ResponseEntity<String> playerPurchaseGame(@PathVariable String purchaserNickname, @PathVariable String soldGame){
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.playerPurchaseGame(purchaserNickname, soldGame));
    }

    @GetMapping("/orderId/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long orderId){
        return ResponseEntity.ok(orderService.getOrderById(orderId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Order>> getAllOrders(){
        return ResponseEntity.ok(orderService.getAllOrders());
    }
}
