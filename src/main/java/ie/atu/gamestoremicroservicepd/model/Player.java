/*
    Player class, has values for name, email, nickname (must be unique) and credit
    Player name can't enforce uniqueness, so nickname is a unique identifier instead
    Player credit can be added to with addCredit(), and removed from when buying games (TBD)
*/
package ie.atu.gamestoremicroservicepd.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long playerId;

    @NotBlank(message = "Player name cannot be left blank.") //PlayerName required
    private String playerName;

    @NotBlank(message = "Player email cannot be left blank.")
    @Email(message = "Player email must be a valid email.") //Forces a real email, while also giving an example in the field
    private String email;

    @NotBlank(message = "Player nickname cannot be left blank.") //Nickname required and must be unique (handled in service layer)
    private String nickname;

    private double credit = 0;
}
