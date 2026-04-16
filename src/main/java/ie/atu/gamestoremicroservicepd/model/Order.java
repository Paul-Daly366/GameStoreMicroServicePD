/*
    Order class, has values for associated player, creator, and purchased game
    Functions as a way to preserve player purchased games
*/

package ie.atu.gamestoremicroservicepd.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY) //Hides id in JSON field
    private Long OrderId;

    private String purchaserNickname;

    private String gameCreatorName;

    private String soldGame;
}
