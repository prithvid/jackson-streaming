package com.prithvid.jackson;

import java.math.BigDecimal;

/**
 * @author prithvi Diddahlli
 *         Date: 8/25/12
 *         Time: 9:05 AM
 */
public class Product {

    String part;
    String name;
    BigDecimal price;
    String description;
    byte[] image;

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return new StringBuffer("[")
                .append(part).append(",")
                .append(name).append(",")
                .append(price).append(",")
                .append(description).append(",")
                .append(image).append("]")
                .toString();
    }
}
