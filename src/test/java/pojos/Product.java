package pojos;

import lombok.Data;

@Data
public class Product {
    private String title;
    private double price;
    private String description;
    private String category;

    // Getters & Setters
}
