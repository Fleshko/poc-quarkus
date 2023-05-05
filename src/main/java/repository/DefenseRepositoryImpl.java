package repository;

import api.DefenseDTO;
import api.DefenseRequest;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import domain.Defense;
import exception.ResourceNotFoundException;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import com.mongodb.client.MongoClient;
import jakarta.inject.Inject;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

@ApplicationScoped
public class DefenseRepositoryImpl implements PanacheMongoRepository {
    private final MongoClient mongoClient;

    @Inject
    public DefenseRepositoryImpl(MongoClient mongoClient) {
        this.mongoClient= mongoClient;
    }

    public boolean deleteDefenseByDefenseId(String defenseId) {
        MongoCollection<Document> collection = mongoClient.getDatabase("development")
                .getCollection("defenses");
        DeleteResult result = collection.deleteOne(eq("defenseId", defenseId));
        if (result.getDeletedCount() == 0) {
            throw new ResourceNotFoundException("Defense", "defenseId", defenseId);
        }
        return true;
    }

    public String createDefense(DefenseRequest defenseRequest){
        MongoCollection<Defense> collection = mongoClient.getDatabase("development")
                .getCollection("defenses", Defense.class);
        Defense defense = new Defense(defenseRequest.name(),
                defenseRequest.specialty(),
                defenseRequest.company(),
                defenseRequest.companyPromotor(),
                defenseRequest.pxlPromotor(),
                defenseRequest.researchPaperTitle());
        collection.insertOne(defense);
        return "defense created";
    }
    public DefenseDTO updateDefense(String defenseId, DefenseRequest defenseRequest){
        MongoCollection<Defense> collection = mongoClient.getDatabase("development")
                .getCollection("defenses", Defense.class);
        Defense updatedDefense = new Defense(defenseRequest.name(),
                defenseRequest.specialty(),
                defenseRequest.company(),
                defenseRequest.companyPromotor(),
                defenseRequest.pxlPromotor(),
                defenseRequest.researchPaperTitle());
        Defense oldDefense = collection.findOneAndReplace(eq("defenseId", defenseId), updatedDefense);
        if (oldDefense == null) {
            throw new ResourceNotFoundException("Defense", "defenseId", defenseId);
        }
        return DefenseDTO.fromDefense(updatedDefense);
    }
}

