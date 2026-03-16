package ie.atu.gamestoremicroservicepd.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @NotBlank(message = "Player name cannot be left blank.")
    private String name;

    //@NotBlank(message = "Player nickname cannot be left blank.")
    //private String nickname;

    private double credit = 0;

    //@NotBlank(message = "Email cannot be left blank.")
    //private String email;

}
