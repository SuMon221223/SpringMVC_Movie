package com.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.model.SalutationBean;

@Repository
public class SalutataionRepository {
	
	public List<SalutationBean> getAllSalutaion(){
		List<SalutationBean> list = new ArrayList<SalutationBean>();
	
		String sql="SELECT * FROM mydb.salutation";
		try(Connection con =DBConnection.getConnection();
			 PreparedStatement ps = con.prepareStatement(sql);
			) {
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SalutationBean obj = new SalutationBean();
				obj.setId(rs.getInt("Id"));
				obj.setType(rs.getString("type"));
				
				list.add(obj);
			}
			
		} catch (SQLException e) {
			System.out.println("salutaion list error : "+ e.getMessage());
		}
		
		return list;		
	}

}
