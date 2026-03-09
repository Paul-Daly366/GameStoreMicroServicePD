package ie.atu.gamestoremicroservicepd.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Creator {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long creatorId;

    @NotBlank(message = "Name cannot be left blank.")
    private String creatorName;

    @Email(message = "Email must be a valid email.")
    private String creatorEmail;

    //@Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @NotBlank(message = "Password cannot be left blank.")
    private String creatorPassword;
}
