package com.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dto.SelectedMovieResponseDTO;
import com.model.MovieBean;

@Repository
public class UserSelectedMovieRepository {
	
	public int rentedMovie(int memeberId,Integer[] movieIds) {

		int i = 0;

		for(int id : movieIds) {
			String sql = "insert into member_rented(member_id,movie_id) values(?,?);";

			try (Connection con = DBConnection.getConnection(); 
				PreparedStatement ps = con.prepareStatement(sql)) {

				ps.setInt(1, memeberId);
				ps.setInt(2, id);
				
				i = ps.executeUpdate();
				
			} catch (SQLException e) {
				System.out.println("movie rented error : " + e.getMessage());
			}
		}
		
		return i;

	}
	
	
	public List<SelectedMovieResponseDTO> getMoviesByUserId(int userId){
		List<SelectedMovieResponseDTO> movlist = new ArrayList<SelectedMovieResponseDTO>();
		//SELECT * FROM mydb.category
		String sql="SELECT mr.id,mm.name,m.title FROM mydb.member_rented mr\r\n"
				+ "join movie m\r\n"
				+ "on m.id = mr.movie_id\r\n"
				+ "join memeber mm\r\n"
				+ "on mm.id = mr.member_id\r\n"
				+ "where mr.member_id=?;";
		try(Connection con =DBConnection.getConnection();
			 PreparedStatement ps = con.prepareStatement(sql);
			) {
			
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				SelectedMovieResponseDTO dto = new SelectedMovieResponseDTO();
				dto.setId(rs.getInt("id"));
				dto.setUsername(rs.getString("name"));
				dto.setMovieTitle(rs.getString("title"));
				
				movlist.add(dto);
			}
			
		} catch (SQLException e) {
			System.out.println("movie list error : "+ e.getMessage());
		}
		return movlist;		
	}

	
	

}
