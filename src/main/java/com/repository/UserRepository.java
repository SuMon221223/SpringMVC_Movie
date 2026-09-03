package com.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Repository;
import com.model.UserBean;

@Repository
public class UserRepository {
	
	public int CreateUser(UserBean obj) {

		int i = 0;

		String sql = "insert into memeber(name,gender,address,salutation_id) values(?,?,?,?)";

		try (Connection con = DBConnection.getConnection(); 
			PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, obj.getName());
			ps.setString(2, obj.getGender());
			ps.setString(3, obj.getAddress());
			ps.setInt(4, obj.getSalutationType());
			
			i = ps.executeUpdate();
		
		} catch (SQLException e) {
			System.out.println("create user error : " + e.getMessage());
		}

		return i;
	}
	
public UserBean checkLogin(String name){
		
		UserBean obj = null;
		
		String sql="SELECT * FROM mydb.memeber where name = ?";
		
		try(Connection con =DBConnection.getConnection();
			 PreparedStatement ps = con.prepareStatement(sql);
			) {
			
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				obj = new UserBean();
				obj.setId(rs.getInt("id"));
				obj.setName(rs.getString("name"));
				obj.setGender(rs.getString("gender"));
				obj.setAddress(rs.getString("address"));
				
			}
			
		} catch (SQLException e) {
			System.out.println("get user error"+ e.getMessage());
		}
		return obj;		
	}


}
