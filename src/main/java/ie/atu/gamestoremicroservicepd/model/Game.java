package ie.atu.gamestoremicroservicepd.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long gameId;

    @NotBlank(message = "Game name cannot be left blank.")
    private String name;

    @Positive(message = "Price must be greater than zero.")
    private double price;

    @NotBlank(message = "Game publisher cannot be left blank.")
    private String publisher;
}
