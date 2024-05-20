package com.amaap.marsrover.repository.db.impl;

import com.amaap.marsrover.repository.db.InMemoryDatabase;
import com.amaap.marsrover.repository.dto.PlateauDto;
import com.amaap.marsrover.repository.dto.RoverDto;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Optional;

import static com.mongodb.client.model.Filters.eq;

public class MongoDB implements InMemoryDatabase {

    private final MongoClient mongoClient;
    private final MongoDatabase database;
    private MongoCollection<Document> roverCollection;
    private MongoCollection<Document> plateauCollection;

    public MongoDB() {
        mongoClient = MongoClients.create("mongodb://localhost:27017");
        database = mongoClient.getDatabase("marsrover");
        roverCollection = database.getCollection("rovers");
        plateauCollection = database.getCollection("plateau");
    }


    @Override
    public RoverDto save(RoverDto rover) {
        int id = getNextSequence("roverId");

        rover.setId(id);

        Document roverDocument = new Document("id", rover.getId())
                .append("isDeployed", rover.isDeployed());

        roverCollection.insertOne(roverDocument);

        return rover;
    }

    @Override
    public Optional<RoverDto> get(int id) {
        Document query = new Document("_id", id);
        Document result = roverCollection.find(query).first();
        RoverDto roverDto = new RoverDto();
        roverDto.setId(1);
        roverDto.setDeployed(result.getBoolean("isDeployed"));
        return Optional.of(roverDto);
    }

    @Override
    public PlateauDto insert(PlateauDto plateauDto) {
        Document plateauDocument = new Document("length", plateauDto.getLength())
                .append("breadth", plateauDto.getBreadth())
                .append("rovers", plateauDto.getRovers());

        plateauCollection.insertOne(plateauDocument);

        return plateauDto;
    }

    @Override
    public Optional<PlateauDto> find(int id) {
        Document query = new Document("_id", id);
        Document result = plateauCollection.find(query).first();
        if (result != null) {
            PlateauDto plateauDto = new PlateauDto(result.getInteger("length"), result.getInteger("breadth"));
            return Optional.of(plateauDto);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void update(RoverDto roverDto) {
        roverCollection.updateOne(eq("id", roverDto.getId()), new Document("$set", new Document("isDeployed", true)));
    }

    private int getNextSequence(String sequenceName) {
        Document filter = new Document("_id", sequenceName);
        Document update = new Document("$inc", new Document("seq", 1));
        Document result = mongoClient.getDatabase("marsrover").getCollection("counters").findOneAndUpdate(filter, update);
        if (result == null) {
            // If the sequence doesn't exist, create it with initial value 1
            mongoClient.getDatabase("marsrover").getCollection("counters").insertOne(new Document("_id", sequenceName).append("seq", 1));
            return 1;
        }
        return result.getInteger("seq");
    }
}

