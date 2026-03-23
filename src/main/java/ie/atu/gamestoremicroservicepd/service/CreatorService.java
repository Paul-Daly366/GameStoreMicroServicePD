package ie.atu.gamestoremicroservicepd.service;

import ie.atu.gamestoremicroservicepd.model.Creator;
import ie.atu.gamestoremicroservicepd.repository.CreatorRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreatorService {

    private final CreatorRepo creatorRepo;
    private List<Creator> creators = new ArrayList<>();
    private long nextId = 1;

    public CreatorService(CreatorRepo creatorRepo) {
        this.creatorRepo = creatorRepo;
    }

    public Creator addCreator(Creator creator){
        creatorRepo.save(creator);
        return creator;
    }

    public List<Creator> getAllCreators(){
        return creatorRepo.findAll();
    }

}
