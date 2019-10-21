package com.mongo.sample;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.types.Decimal128;

import java.math.BigDecimal;

/**
 * Decimal128 Quick tour
 */
public class Decimal128QuickTour {
    /**
     * Run this main method to see the output of this quick example.
     *
     * @param args takes an optional single argument for the connection string
     */
    public static void main(final String[] args) {
        MongoClient mongoClient;

        if (args.length == 0) {
            // connect to the local database server
            mongoClient = MongoClients.create();
        } else {
            mongoClient = MongoClients.create(args[0]);
        }


        // get handle to "mydb" database
        MongoDatabase database = mongoClient.getDatabase("mydb");


        // get a handle to the "test" collection
        MongoCollection<Document> collection = database.getCollection("test");

        // drop all the data in it
        collection.drop();

        // make a document and insert it
        Document doc = new Document("name", "MongoDB")
                               .append("amount1", Decimal128.parse(".10"))
                               .append("amount2", new Decimal128(42L))
                               .append("amount3", new Decimal128(new BigDecimal(".200")));

        collection.insertOne(doc);


        Document first = collection.find().filter(Filters.eq("amount1", new Decimal128(new BigDecimal(".10")))).first();

        Decimal128 amount3 = (Decimal128) first.get("amount3");
        BigDecimal amount2AsBigDecimal = amount3.bigDecimalValue();

        System.out.println(amount3.toString());
        System.out.println(amount2AsBigDecimal.toString());

    }
}