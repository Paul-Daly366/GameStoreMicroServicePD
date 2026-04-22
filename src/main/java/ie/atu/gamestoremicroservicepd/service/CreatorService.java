package ie.atu.gamestoremicroservicepd.service;

import ie.atu.gamestoremicroservicepd.exception.NameConflictException;
import ie.atu.gamestoremicroservicepd.model.Creator;
import ie.atu.gamestoremicroservicepd.model.Game;
import ie.atu.gamestoremicroservicepd.repository.CreatorRepo;
import ie.atu.gamestoremicroservicepd.repository.GameRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreatorService {

    private final CreatorRepo creatorRepo;
    private final GameRepo gameRepo;

    List<Creator> creators;


    public CreatorService(CreatorRepo creatorRepo, GameRepo gameRepo) {
        this.creatorRepo = creatorRepo;
        this.gameRepo = gameRepo;
    }

    //Post method, logic contained in this class
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

    //Get methods
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

    //Get method for games by a specific publisher
    public List<Game> getAllGamesByCreator(String name){
        return gameRepo.getGamesByPublisher(name);
    }
}
