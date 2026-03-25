package ie.atu.gamestoremicroservicepd.service;

import ie.atu.gamestoremicroservicepd.exception.NameConflictException;
import ie.atu.gamestoremicroservicepd.model.Creator;
import ie.atu.gamestoremicroservicepd.repository.CreatorRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreatorService {

    private final CreatorRepo creatorRepo;
    private List<Creator> creators = new ArrayList<>();

    public CreatorService(CreatorRepo creatorRepo) {
        this.creatorRepo = creatorRepo;
    }

    public Creator addCreator(Creator creator){
        creators = creatorRepo.findAll();
        for(Creator existing : creators){
            if (existing.getCreatorName().equals(creator.getCreatorName())) {
                throw new NameConflictException("Creator name already exists");
            }
        }
        creatorRepo.save(creator);
        return creator;
    }

    public List<Creator> getAllCreators(){
        return creatorRepo.findAll();
    }

    public Creator getCreatorByCreatorId(Long id){
        return creatorRepo.getCreatorByCreatorId(id);
    }

    public Creator getCreatorByCreatorName(String name){
        return creatorRepo.getCreatorByCreatorName(name);
    }

    public Creator getCreatorByCreatorEmail(String email){
        return creatorRepo.getCreatorByCreatorEmail(email);
    }
}
