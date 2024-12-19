/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.book;

/**
 *
 * @author lcaohoanq
 */
public class BookDTO {
    private String SKU;
    private String Name;
    private Double Price;
    private String description;
    private int quantity;

    public BookDTO(String SKU, String Name, Double Price, String description, int quantity) {
        this.SKU = SKU;
        this.Name = Name;
        this.Price = Price;
        this.description = description;
        this.quantity = quantity;
    }

    public String getSKU() {
        return SKU;
    }

    public String getName() {
        return Name;
    }

    public Double getPrice() {
        return Price;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "BookDTO{" + "SKU=" + SKU + ", Name=" + Name + ", Price=" + Price + ", description=" + description + ", quantity=" + quantity + '}';
    }
    
    
}
