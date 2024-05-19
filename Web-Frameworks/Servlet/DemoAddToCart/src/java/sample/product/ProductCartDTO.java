/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.product;

/**
 *
 * @author Tony
 */
public class ProductCartDTO {
    private String id;
    private String name;
    private float price;
    private String description;
    private String size;
    private Integer quantity;
    private Integer quantityLoss;
    private Integer status;

    public ProductCartDTO() {
    }

    public ProductCartDTO(String id, String name, float price, String size, String description, Integer quantity, Integer quantityLoss, Integer status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.size = size;
        this.quantity = quantity;
        this.quantityLoss = quantityLoss;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantityLoss() {
        return quantityLoss;
    }

    public void setQuantityLoss(Integer quantityLoss) {
        this.quantityLoss = quantityLoss;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    
    
    
}
