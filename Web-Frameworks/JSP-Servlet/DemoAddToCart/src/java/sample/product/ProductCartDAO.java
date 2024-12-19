/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.product;


import sample.product.ProductCartDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DBUtils;

/**
 *
 * @author Tony
 */
public class ProductCartDAO {
    Connection connection;
    PreparedStatement ps;
    ResultSet rs;
    
    
    
    
    
    public boolean deleteProduct(String id) {
        String sql = "UPDATE tblProduct SET status = 1 WHERE id = ?;";
        boolean response = true;
        
        try {
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            response = ps.executeUpdate() > 0 ? true : false;
        } catch (Exception ex) {}
        
        return response;
    }
    
    
    
     public boolean updateProduct(String id, float price, String description, String name, String size) {
        String sql = "UPDATE tblProduct SET price = ?, description = ?, name = ?, size = ? WHERE id = ?;";
        boolean response = true;
        try {
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setFloat(1, price);
            ps.setString(2, description);
            ps.setString(3, name);
            ps.setString(4, size);
            ps.setString(5, id);
            response = ps.executeUpdate() > 0 ? true : false;
        } catch (Exception ex) {
        }
        return response;
    }
    
        
    public List<ProductCartDTO> getAllProduct() {
        List<ProductCartDTO> ProductCartList = new ArrayList<ProductCartDTO>();
        ProductCartDTO productCart;
        String sql = "SELECT * FROM tblProductCart;";
        try {
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                productCart = new ProductCartDTO(
                        rs.getString("id"), 
                        rs.getString("name"), 
                        rs.getFloat("price"), 
                        rs.getString("size"),
                        rs.getString("description"),
                        rs.getInt("quantity"),
                        rs.getInt("quantityLoss"),
                        rs.getInt("status")
                );
                if(productCart.getStatus()==0){
                    ProductCartList.add(productCart);
                }
                
            }
        } catch (Exception ex) {
        }
        
        return ProductCartList;
    }
    
    
    
    public List<ProductCartDTO> getAllByIdAndName(String description) {
        List<ProductCartDTO> ProductCartList = new ArrayList<ProductCartDTO>();
        ProductCartDTO productCart;
        String sql = "SELECT * FROM tblProductCart WHERE description LIKE ?;";
        try {
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, '%' + description + '%');
            
            rs = ps.executeQuery();
            while (rs.next()) {
                productCart = new ProductCartDTO(
                        rs.getString("id"), 
                        rs.getString("name"), 
                        rs.getFloat("price"), 
                        rs.getString("size"),
                        rs.getString("description"),
                        rs.getInt("quantity"),
                        rs.getInt("quantityLoss"),
                        rs.getInt("status")
                );
                if(productCart.getStatus()==0){
                    ProductCartList.add(productCart);
                }
                
            }
        } catch (Exception ex) {
        }
        
        return ProductCartList;
    }
    
 
}
