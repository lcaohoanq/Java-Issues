package com.lcaohoanq.services;

import com.lcaohoanq.utils.EnvUtils;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class DatabaseConnection {

    private MongoClientSettings settings;

    public DatabaseConnection() {
        // Load the connection string from the .env file
        String connectionString = String.format("mongodb+srv://%s:%s@snake-game.t2nmru9.mongodb.net/?retryWrites=true&w=majority&appName=Snake-Game",
            EnvUtils.get("DB_USER"),
            EnvUtils.get("DB_PASSWORD")
        );

        ServerApi serverApi = ServerApi.builder()
            .version(ServerApiVersion.V1)
            .build();

        this.settings = MongoClientSettings.builder()
            .applyConnectionString(new ConnectionString(connectionString))
            .serverApi(serverApi)
            .build();
    }

    private MongoClient createClient() {
        return MongoClients.create(this.settings);
    }

    private MongoDatabase getDatabase(MongoClient client, String name){
        return client.getDatabase(name);
    }

    private MongoCollection<Document> getCollection(MongoDatabase database, String name) {
        return database.getCollection(name);
    }

    public void findAllUsers() {
        try (MongoClient mongoClient = createClient()) {
            MongoDatabase database = getDatabase(mongoClient, EnvUtils.get("DB_NAME"));
            MongoCollection<Document> usersCollection = getCollection(database, EnvUtils.get("DB_COLLECTION"));
            FindIterable<Document> documents = usersCollection.find();
            for (Document document : documents) {
                System.out.println(document.toJson());
            }
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    public void findUserByUsername(String username){
        try (MongoClient mongoClient = createClient()) {
            MongoDatabase database = getDatabase(mongoClient, EnvUtils.get("DB_NAME"));
            MongoCollection<Document> usersCollection = getCollection(database, EnvUtils.get("DB_COLLECTION"));
            Document user = new Document("username", username);
            FindIterable<Document> documents = usersCollection.find(user);
            for (Document document : documents) {
                System.out.println(document.toJson());
            }
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new DatabaseConnection().findUserByUsername("minhnhu");
    }
}