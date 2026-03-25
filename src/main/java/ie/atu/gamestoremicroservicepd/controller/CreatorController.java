package ie.atu.gamestoremicroservicepd.controller;

import ie.atu.gamestoremicroservicepd.model.Creator;
import ie.atu.gamestoremicroservicepd.service.CreatorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/creators")
public class CreatorController {

    private final CreatorService creatorService;

    public CreatorController(CreatorService creatorService) {
        this.creatorService = creatorService;
    }

    @PostMapping
    public ResponseEntity<Creator> addCreator(@Valid @RequestBody Creator creator){
        Creator saved =  creatorService.addCreator(creator);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Creator>> getAllCreators() {
        return ResponseEntity.ok(creatorService.getAllCreators());
    }

    @GetMapping("/id/{creatorId}")
    public ResponseEntity<Creator> getCreatorById(@PathVariable("creatorId") Long creatorId){
        return ResponseEntity.ok(creatorService.getCreatorByCreatorId(creatorId));
    }

    @GetMapping("/name/{creatorName}")
    public ResponseEntity<Creator> getCreatorByName(@PathVariable("creatorName") String creatorName){
        return ResponseEntity.ok(creatorService.getCreatorByCreatorName(creatorName));
    }

    @GetMapping("/email/{creatorEmail}")
    public ResponseEntity<Creator> getCreatorByEmail(@PathVariable("creatorEmail") String creatorEmail){
        return ResponseEntity.ok(creatorService.getCreatorByCreatorEmail(creatorEmail));
    }
}
