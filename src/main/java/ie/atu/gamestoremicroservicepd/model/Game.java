/*
    Game class, has values for a name, a price and a publisher
    Games can be bought if the 'Player' entity has enough 'Credit' (credit >= price)
    Game has a publisher, can be returned by publisher name
*/

package ie.atu.gamestoremicroservicepd.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY) //Hides id in JSON field
    private Long gameId;

    @NotBlank(message = "Game name cannot be left blank.")
    private String gameName;

    @Positive(message = "Game price must be greater than zero.")
    @Max(value=100, message="Game price must be less than 100") //Prevents pricing games too high
    private double price;

    @NotBlank(message = "Game publisher cannot be left blank.") //Allows for searching games by publisher
    private String publisher;

    private int sales = 0;
}
