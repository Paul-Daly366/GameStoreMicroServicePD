package ie.atu.gamestoremicroservicepd.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long playerId;

    @NotBlank(message = "Player name cannot be left blank.")
    private String playerName;

    @NotBlank(message = "Player email cannot be left blank.")
    @Email(message = "Player email must be a valid email.")
    private String email;

    @NotBlank(message = "Player nickname cannot be left blank.")
    private String nickname;

    private double credit = 0;
}
