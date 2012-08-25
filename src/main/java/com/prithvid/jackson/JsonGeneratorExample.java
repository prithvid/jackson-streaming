package com.prithvid.jackson;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;


/**
 * @author prithvi Diddahlli
 *         Date: 8/24/12
 *         Time: 4:12 PM
 */
public class JsonGeneratorExample {


    public static void main(String[] args) {

            JsonFactory jasonFactory = new JsonFactory();

        try {
            JsonGenerator jsonGenerator = jasonFactory
                    .createJsonGenerator(new File("product.json"), JsonEncoding.UTF8);
            jsonGenerator.writeStartObject();
            jsonGenerator.writeObjectFieldStart("product");
            jsonGenerator.writeStringField("part", "234682374923");
            jsonGenerator.writeStringField("name", "Name of product");
            jsonGenerator.writeNumberField("price", new BigDecimal(59.99).setScale(2, BigDecimal.ROUND_HALF_EVEN));
            jsonGenerator.writeStringField("description", "More info about product");
            jsonGenerator.writeBinaryField("image", new byte[10]);
            jsonGenerator.writeEndObject(); // End product
            jsonGenerator.writeEndObject();
            jsonGenerator.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
