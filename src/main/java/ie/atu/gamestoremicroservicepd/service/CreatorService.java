package ie.atu.gamestoremicroservicepd.service;

import ie.atu.gamestoremicroservicepd.model.Creator;
import ie.atu.gamestoremicroservicepd.model.Game;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreatorService {
    private final List<Creator> creators = new ArrayList<>();

    public void existingCreators(Creator creator) {
        creator.createCreatorAccount(1, "Mojang", "mojang@gameStore.com", "Minecraft1");
        creators.add(creator);
        creator.createCreatorAccount(2, "Valve", "valve@gameStore.com", "Steam1");
        creators.add(creator);
        creator.createCreatorAccount(3, "Nintendo", "nintendo@gameStore.com", "Mario1");
        creators.add(creator);
    }

    public List<Creator> getListOfCreators(){
        return creators;
    }

}
