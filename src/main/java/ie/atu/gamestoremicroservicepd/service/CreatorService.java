package ie.atu.gamestoremicroservicepd.service;

import ie.atu.gamestoremicroservicepd.model.Creator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreatorService {

    private final List<Creator> creators = new ArrayList<>();
    private long nextId = 1;

    public Creator addCreator(Creator creator){
        creator.setCreatorId(nextId++);
        creators.add(creator);
        return creator;
    }

    public List<Creator> getAllCreators(){
        return creators;
    }

}
