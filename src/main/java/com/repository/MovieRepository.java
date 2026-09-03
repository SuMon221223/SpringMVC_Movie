package com.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.model.MovieBean;

@Repository
public class MovieRepository {

	public List<MovieBean> getMoviesByCatId(int categoryId){
		List<MovieBean> movlist = new ArrayList<MovieBean>();
		//SELECT * FROM mydb.category
		String sql="SELECT * FROM mydb.movie where category_id=?;";
		try(Connection con =DBConnection.getConnection();
			 PreparedStatement ps = con.prepareStatement(sql);
			) {
			
			ps.setInt(1, categoryId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				MovieBean obj = new MovieBean();
				obj.setId(rs.getInt("id"));
				obj.setTitle(rs.getString("title"));
				obj.setDescription(rs.getString("description"));
				obj.setDuration(rs.getString("duration"));
				obj.setReleaseYear(rs.getDate("release_year").toLocalDate());
				obj.setCategoryId(rs.getInt("category_id"));
				
				movlist.add(obj);
				
			}
			
		} catch (SQLException e) {
			System.out.println("movie list error : "+ e.getMessage());
		}
		return movlist;		
	}

	public int rentedMovie(int memeberId,int movieId) {

		int i = 0;

		String sql = "insert into member_rented(member_id,movie_id) values(?,?);";

		try (Connection con = DBConnection.getConnection(); 
			PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, memeberId);
			ps.setInt(2, movieId);
			
			i = ps.executeUpdate();

			
		} catch (SQLException e) {
			System.out.println("movie rented error : " + e.getMessage());
		}

		return i;

	}
	
	public List<MovieBean> getAllMovies() {

	    List<MovieBean> movlist = new ArrayList<MovieBean>();

	    String sql = "SELECT * FROM mydb.movie;";

	    try (
	        Connection con = DBConnection.getConnection();
	        PreparedStatement ps = con.prepareStatement(sql);
	    ) {

	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {

	            MovieBean obj = new MovieBean();

	            obj.setId(rs.getInt("id"));
	            obj.setTitle(rs.getString("title"));
	            obj.setDescription(rs.getString("description"));
	            obj.setDuration(rs.getString("duration"));
	            obj.setReleaseYear(
	                rs.getDate("release_year").toLocalDate()
	            );
	            obj.setCategoryId(rs.getInt("category_id"));

	            movlist.add(obj);
	        }

	    } catch (SQLException e) {
	        System.out.println("all movie list error : " + e.getMessage());
	    }

	    return movlist;
	}
	
	public MovieBean getMovieById(int id) {

	    MovieBean obj = null;

	    String sql = "SELECT * FROM movie WHERE id=?";

	    try (
	        Connection con = DBConnection.getConnection();
	        PreparedStatement ps = con.prepareStatement(sql)
	    ) {

	        ps.setInt(1, id);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {

	            obj = new MovieBean();

	            obj.setId(rs.getInt("id"));
	            obj.setTitle(rs.getString("title"));
	            obj.setDescription(rs.getString("description"));
	            obj.setReleaseYear(
	                rs.getDate("release_year").toLocalDate()
	            );
	            obj.setDuration(rs.getString("duration"));
	            obj.setCategoryId(rs.getInt("category_id"));
	        }

	    } catch (SQLException e) {
	        System.out.println("get movie error : " + e.getMessage());
	    }

	    return obj;
	}
	
	public int UpdateMovie(MovieBean obj) {

		int i = 0;

		String sql = "UPDATE movie\r\n"
				+ "SET title=?\r\n"
				+ "WHERE id=?";

		try (Connection con = DBConnection.getConnection(); 
			PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, obj.getTitle());
			ps.setInt(2, obj.getId());
			i = ps.executeUpdate();

			
		} catch (SQLException e) {
			System.out.println("update movie error : " + e.getMessage());
		}

		return i;

	}
	
	
	public int removeMovie(int id) {

	    int i = 0;

	    String sql = "DELETE FROM movie WHERE id=?";

	    try (
	        Connection con = DBConnection.getConnection();
	        PreparedStatement ps = con.prepareStatement(sql);
	    ) {

	        ps.setInt(1, id);

	        i = ps.executeUpdate();

	    } catch (SQLException e) {
	        System.out.println("movie remove error : " + e.getMessage());
	    }

	    return i;
	}

}
