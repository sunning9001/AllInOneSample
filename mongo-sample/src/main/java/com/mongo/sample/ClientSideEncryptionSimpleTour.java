package com.mongo.sample;

import com.mongodb.AutoEncryptionSettings;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

/**
 * ClientSideEncryption Simple tour
 */
public class ClientSideEncryptionSimpleTour {

    /**
     * Run this main method to see the output of this quick example.
     *
     * Requires the mongodb-crypt library in the class path and mongocryptd on the system path.
     * Assumes the schema has already been created in MongoDB.
     *
     * @param args ignored args
     */
    public static void main(final String[] args) {

        // This would have to be the same master key as was used to create the encryption key
        final byte[] localMasterKey = new byte[96];
        new SecureRandom().nextBytes(localMasterKey);

        Map<String, Map<String, Object>> kmsProviders = new HashMap<String, Map<String, Object>>() {{
           put("local", new HashMap<String, Object>() {{
               put("key", localMasterKey);
           }});
        }};

        String keyVaultNamespace = "admin.datakeys";

        AutoEncryptionSettings autoEncryptionSettings = AutoEncryptionSettings.builder()
                .keyVaultNamespace(keyVaultNamespace)
                .kmsProviders(kmsProviders)
                .build();

        MongoClientSettings clientSettings = MongoClientSettings.builder()
                .autoEncryptionSettings(autoEncryptionSettings)
                .build();

        MongoClient mongoClient = MongoClients.create(clientSettings);
        MongoCollection<Document> collection = mongoClient.getDatabase("test").getCollection("coll");
        collection.drop(); // Clear old data

        collection.insertOne(new Document("encryptedField", "123456789"));

        System.out.println(collection.find().first().toJson());

        // release resources
        mongoClient.close();
    }
}