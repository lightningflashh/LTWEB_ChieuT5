package vn.chithanh.dao.impls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.chithanh.configuations.DBConnectMySQL;
import vn.chithanh.dao.IUserDAO;
import vn.chithanh.models.UserModel;

public class UserDAOImpl extends DBConnectMySQL implements IUserDAO {

	@Override
	public List<UserModel> findAll() {
		String sql = "SELECT * FROM users";
		List<UserModel> list = new ArrayList<>();
		try (Connection conn = super.getDatabaseConnection();
			 PreparedStatement ps = conn.prepareStatement(sql);
			 ResultSet res = ps.executeQuery()) {

			while (res.next()) {
				list.add(new UserModel(res.getInt("id"), res.getString("username"), res.getString("password"),
						res.getString("email"), res.getString("fullname"), res.getString("images")));
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();  
		}
		return list;
	}

	@Override
	public UserModel findById(int id) {
		String sql = "SELECT * FROM users WHERE id = ?";
		UserModel user = null;
		try (Connection conn = super.getDatabaseConnection();
			 PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, id);
			try (ResultSet res = ps.executeQuery()) {
				if (res.next()) {
					user = new UserModel(res.getInt("id"), res.getString("username"), res.getString("password"),
							res.getString("email"), res.getString("fullname"), res.getString("images"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();  
		}
		return user;
	}

	@Override
	public void insert(UserModel user) {
		String sqlInsert = "INSERT INTO users(username, password, email, fullname, images) VALUES(?, ?, ?, ?, ?)";
		try (Connection conn = super.getDatabaseConnection();
			 PreparedStatement ps = conn.prepareStatement(sqlInsert)) {

			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getFullname());
			ps.setString(5, user.getImages());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.findByUsername(username);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	@Override
	public UserModel findByUsername(String username) {
		String sql = "SELECT * FROM users WHERE username = ?";
		try (Connection conn = super.getDatabaseConnection();
			 PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, username);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return new UserModel(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
							rs.getString("email"), rs.getString("fullname"), rs.getString("images"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();  
		}
		return null;
	}

	@Override
	public boolean register(String username, String password, String email, String fullname, String images) {
		if (this.checkExistUsername(username) || this.checkExistEmail(email)) {
			return false;
		}
		this.insert(new UserModel(username, password, email, fullname, images));
		return true;
	}

	@Override
	public boolean checkExistEmail(String email) {
		String query = "SELECT 1 FROM users WHERE email = ?";
		try (Connection conn = super.getDatabaseConnection();
			 PreparedStatement ps = conn.prepareStatement(query)) {

			ps.setString(1, email);
			try (ResultSet res = ps.executeQuery()) {
				return res.next();
			}
		} catch (Exception ex) {
			ex.printStackTrace();  // Consider logging
		}
		return false;
	}

	@Override
	public boolean checkExistUsername(String username) {
		String query = "SELECT 1 FROM users WHERE username = ?";
		try (Connection conn = super.getDatabaseConnection();
			 PreparedStatement ps = conn.prepareStatement(query)) {

			ps.setString(1, username);
			try (ResultSet res = ps.executeQuery()) {
				return res.next();
			}
		} catch (Exception ex) {
			ex.printStackTrace();  // Consider logging
		}
		return false;
	}

	public static void main(String[] args) {
		UserDAOImpl userDao = new UserDAOImpl();

//		userDao.insert(new UserModel("cheesethank", "0429@", "cheesethankne2004@yahoo.com", "Chi Thanh", "profile_pic3.jpg"));
//
//		List<UserModel> list = userDao.findAll();
//
//		UserModel findUserById = userDao.findById(2);
//		System.out.println(findUserById.toString());
		
		
//
//		for (UserModel user : list) {
//			System.out.println(user.toString());
//		}
		
//		if (userDao.login("cheesethank", "0429@") != null) {
//			System.out.println("Successfully!");
//		} else {
//			System.out.println("Fail!");
//		}
		
		Boolean check = userDao.register("tranbinh", "0329@", "binhtr@yahoo.com", "Bình Trần", "profile_pic4.jpg");
		
		if(!check) {
			System.out.println("Fail!");
		} else {
			System.out.println("Successfully!");
		}
		
	}
}
