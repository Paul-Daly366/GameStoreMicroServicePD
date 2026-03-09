package ie.atu.gamestoremicroservicepd.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @NotBlank(message = "Game name cannot be left blank.")
    private String name;

    @Positive(message = "Price must be greater than zero.")
    private double price;

    @NotBlank(message = "Game publisher cannot be left blank.")
    private String publisher;
}
