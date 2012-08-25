package com.prithvid.jackson;

import com.fasterxml.jackson.core.*;

import java.io.File;
import java.io.IOException;

/**
 * @author prithvi Diddahlli
 *         Date: 8/25/12
 *         Time: 8:25 AM
 */
public class jsonParserExample {
    public static void main(String[] args) {

            JsonFactory jasonFactory = new JsonFactory();
        try {
            JsonParser jsonParser = jasonFactory
                    .createJsonParser(new File("product.json"));
            jsonParser.nextToken();   // Returns "{" (Which is JsonToken.START_OBJECT)

            Product product = new Product();
            while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                String fieldname = jsonParser.getCurrentName(); //product
                jsonParser.nextToken();// move to field value
                if ("product".equals(fieldname)) {
                    while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                        String field = jsonParser.getCurrentName(); // One of the product info
                        jsonParser.nextToken();
                        if ("part".equals(field)) {
                            product.setPart(jsonParser.getText());
                        } else if ("name".equals(field)) {
                            product.setName(jsonParser.getText());
                        } else if ("price".equals(field)) {
                            product.setPrice(jsonParser.getDecimalValue());
                        } else if ("description".equals(field)) {
                            product.setDescription(jsonParser.getText());
                        } else if ("image".equals(field)) {
                            product.setImage(jsonParser.getBinaryValue());
                        }
                    }
                }
            }
            System.out.println(product);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}