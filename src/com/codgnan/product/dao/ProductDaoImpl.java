package com.codgnan.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import com.codegnan.exceptions.ProductNotFoundException;
import com.codgnan.productinventory.program.Product;
import com.codgnan.productinventory.program.ConnectionFactory;

public class ProductDaoImpl implements ProductDao{

	@Override
	public void save(Product product) {
		String sqlQuery = "INSERT INTO productdetails (productid,productname, productprice, productquantity) VALUES (?,?,?,?)";
        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
            pstmt.setInt(1, product.getProductid());
            pstmt.setString(2, product.getProductname());
            pstmt.setDouble(3, product.getProductprice());
            pstmt.setInt(4, product.getProductquantity());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println(" Product inserted successfully ");
            }
	}catch(SQLException sqlex) {
    	sqlex.printStackTrace();
    }
	}

	@Override
	public List<Product> findAll() {
		List<Product> list = new ArrayList<>();
		String sqlQuery = "SELECT * FROM productdetails";
        try {
            Connection conn = ConnectionFactory.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlQuery);
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4)));
            }
	}catch(SQLException sqle) {
		sqle.printStackTrace();
	}
        return list;
	}

	@Override
	public Product findById(int id) throws ProductNotFoundException {
		String sqlQuery = "select* from productdetails WHERE productid=?";
        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4));
            }else {
            	throw new ProductNotFoundException("Product Id not found: "+id);
            }
        } catch (SQLException e) {
            throw new ProductNotFoundException("Database error : " + e.getMessage());
        }
	}

	@Override
	public void update(Product product) throws ProductNotFoundException {
		String sqlQuery = "UPDATE productdetails SET productprice=?,productname=?,productquantity=? where productid=?";
        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
            pstmt.setDouble(1,product.getProductprice());
            pstmt.setString(2,product.getProductname());
            pstmt.setInt(3,product.getProductquantity());
            pstmt.setInt(4, product.getProductid());
            
            int rowsAffected = pstmt.executeUpdate();
            if(rowsAffected == 0) {
            	throw new ProductNotFoundException("productid is not found for update: "+product.getProductid());
            }else {
            	System.out.println("updated: " + product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	@Override
	public void deleteById(int id) throws ProductNotFoundException {
	    String sqlQuery = "DELETE FROM productdetails WHERE productid=?";
	    try {
	        Connection conn = ConnectionFactory.getConnection();
	        PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
	        pstmt.setInt(1, id);

	        int rows = pstmt.executeUpdate();
	        if (rows == 0) {
	            throw new ProductNotFoundException("productid is not found for delete: " + id);
	        } else {
	            System.out.println("Deleted Id: " + id);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}


	