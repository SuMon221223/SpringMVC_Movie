package com.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.model.CategoryBean;

@Repository
public class CategoryRepository {
	
	public List<CategoryBean> getAllCategories(){
		List<CategoryBean> catlist = new ArrayList<CategoryBean>();
		//SELECT * FROM mydb.category
		String sql="SELECT * FROM mydb.category where status=?";
		try(Connection con =DBConnection.getConnection();
			 PreparedStatement ps = con.prepareStatement(sql);
			) {
			
			ps.setBoolean(1, true);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CategoryBean obj = new CategoryBean();
				obj.setId(rs.getInt("Id"));
				obj.setName(rs.getString("name"));
				
				catlist.add(obj);
			}
			
		} catch (SQLException e) {
			System.out.println("category list error : "+ e.getMessage());
		}
		
		return catlist;		
	}
	
	public int CreateCategory(CategoryBean obj) {

		int i = 0;

		String sql = "insert into category(name) values(?)";

		try (Connection con = DBConnection.getConnection(); 
			PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, obj.getName());
			
			i = ps.executeUpdate();

			
		} catch (SQLException e) {
			System.out.println("create category error : " + e.getMessage());
		}

		return i;

	}
	
	
	public CategoryBean getById(Integer id){
		CategoryBean obj = null;
		String sql="SELECT * FROM mydb.category where id=?";
		try(Connection con =DBConnection.getConnection();
			 PreparedStatement ps = con.prepareStatement(sql);
			) {
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				obj = new CategoryBean();
				obj.setId(rs.getInt("id"));//Id
				obj.setName(rs.getString("name"));
				
			}
			
		} catch (SQLException e) {
			System.out.println("getbyid error : "+ e.getMessage());
		}
		
		return obj;		
	}
	
	public int UpdateCategory(CategoryBean obj) {

		int i = 0;

		String sql = "update category set name=? where id=?";

		try (Connection con = DBConnection.getConnection(); 
			PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, obj.getName());
			ps.setInt(2, obj.getId());
			
			i = ps.executeUpdate();

			
		} catch (SQLException e) {
			System.out.println("update category error : " + e.getMessage());
		}

		return i;

	}
	
	
	public int RemoveCategory(Integer id) {

		int i = 0;

		String sql = "update category set status=? where id=?";

		try (Connection con = DBConnection.getConnection(); 
			PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setBoolean(1, false);
			ps.setInt(2, id);
			
			i = ps.executeUpdate();

			
		} catch (SQLException e) {
			System.out.println("remove category error : " + e.getMessage());
		}

		return i;

	}
	
	

}
