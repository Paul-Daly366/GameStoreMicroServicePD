package ie.atu.gamestoremicroservicepd.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Creator {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private int creatorId;


    private String creatorName;

    private String creatorEmail;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String creatorPassword;

    public void createCreatorAccount(int creatorId, String creatorName, String creatorEmail, String creatorPassword) {
        this.creatorId=creatorId;
        this.creatorName=creatorName;
        this.creatorEmail=creatorEmail;
        this.creatorPassword=creatorPassword;
    }
}
