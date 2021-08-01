package com.demo.lambda.dynamodb;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.PutItemSpec;
import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.Random;

public class SavePersonHandler implements RequestHandler<PersonRequest, PersonResponse> {
    private DynamoDB dynamoDb;

    private String DYNAMODB_TABLE_NAME = "Person";

    private Regions REGION = Regions.US_EAST_2;

    public PersonResponse handleRequest(PersonRequest personRequest, Context context) {
        this.initDynamoDbClient();

        persistData(personRequest);

        PersonResponse personResponse = new PersonResponse();
        personResponse.setMessage("Saved Successfully!!!");
        return personResponse;
    }

    private PutItemOutcome persistData(PersonRequest personRequest) throws ConditionalCheckFailedException {
        return this.dynamoDb.getTable(DYNAMODB_TABLE_NAME)
                .putItem(
                        new PutItemSpec().withItem(new Item()
                                .withNumber("id", System.currentTimeMillis())
                                .withString("firstName", personRequest.getFirstName())
                                .withString("lastName", personRequest.getLastName())
                                .withNumber("age", new Random().nextInt(60))
                                .withString("address", personRequest.getAddress())));
    }

    private void initDynamoDbClient() {
        AmazonDynamoDB ddb = AmazonDynamoDBClientBuilder.standard()
                .withRegion(REGION)
                .build();

        this.dynamoDb = new DynamoDB(ddb);
    }
}
