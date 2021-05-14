package model;

import java.sql.*;

public class ResearchManagement {
	
	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gbdb?useTimezone=true&serverTimezone=UTC",
					"root", "");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return con;
	}

	public String readResearch() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border='1'><tr><th>Name</th>" + "<th>Email</th>"
					+ "<th>projectTitle</th>" + "<th>totalCost</th>" + "<th>duration</th>" + "<th>catogary</th>" + "<th>Update</th><th>Remove</th></tr>";

			String query = "select * from research";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			
			while (rs.next()) {
				String rid = Integer.toString(rs.getInt("rid"));
				String name = rs.getString("name");
				String email = rs.getString("email");
				String projectTitle = rs.getString("projectTitle");
				String totalCost = Double.toString(rs.getDouble("totalCost"));
				String duration = rs.getString("duration");
				String catogary = rs.getString("catogary");
				// Add into the html table
				output += "<td>" + name + "</td>";
				output += "<td>" + email + "</td>";
				output += "<td>" + projectTitle + "</td>";
				output += "<td>" + totalCost + "</td>";
				output += "<td>" + duration + "</td>";
				output += "<td>" + catogary + "</td>";
				// buttons
				output += "<td><input name='btnUpdate' type='button' value='Update' "
						+ "class='btnUpdate btn btn-secondary' data-itemid='" + rid + "'></td>"
						+ "<td><input name='btnRemove' type='button' value='Remove' "
						+ "class='btnRemove btn btn-danger' data-itemid='" + rid + "'></td></tr>";
			}
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading ";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String insertResearch(String name,String email,String projectTitle,String totalCost ,String duration,String catogary) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = " insert into research (`rid`,`name`,`email`,`projectTitle`,`totalCost`,`duration`,`catogary`)" + " values (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, name);
			preparedStmt.setString(3, email);
			preparedStmt.setString(4, projectTitle);
			preparedStmt.setDouble(5, Double.parseDouble(totalCost));
			preparedStmt.setString(6, duration);
			preparedStmt.setString(7, catogary);
			// execute the statement
			preparedStmt.execute();
			con.close();
			String newItems = readResearch();
			output = "{\"status\":\"success\", \"data\": \"" +newItems + "\"}";
//			output = "Inserted successfully";
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\":\"Error while inserting the item.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updateResearch(String rid, String name,String email,String projectTitle,String totalCost ,String duration,String catogary) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			String query = "UPDATE research SET name=?,email=?,projectTitle=?,totalCost=?,duration=?,catogary=? WHERE rid=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, name);
			preparedStmt.setString(2, email);
			preparedStmt.setString(3, projectTitle);
			preparedStmt.setDouble(4, Double.parseDouble(totalCost));
			preparedStmt.setString(5, duration);
			preparedStmt.setString(6, catogary);
			preparedStmt.setInt(7, Integer.parseInt(rid));
			// execute the statement
			preparedStmt.execute();
			con.close();
			String newItems = readResearch();
			output = "{\"status\":\"success\", \"data\": \"" +newItems + "\"}";
		} catch (Exception e) {
			output = "Error while updating";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String deleteResearch(String rid) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement
			String query = "delete from research where rid=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(rid));
			// execute the statement
			preparedStmt.execute();
			con.close();
			String newItems = readResearch();
			output = "{\"status\":\"success\", \"data\": \"" +newItems + "\"}";
	} catch (Exception e) {
			output = "Error while deleting";
			System.err.println(e.getMessage());
		}
		return output;
	}


}
