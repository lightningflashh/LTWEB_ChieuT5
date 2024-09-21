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
						res.getString("fullname"), res.getString("email"), res.getString("images"),
						res.getInt("roleId"), res.getString("phone"), res.getDate("createDate")));
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
		try (Connection conn = super.getDatabaseConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, id);
			try (ResultSet res = ps.executeQuery()) {
				if (res.next()) {
					user = new UserModel(res.getInt("id"), res.getString("username"), res.getString("password"),
							res.getString("fullname"), res.getString("email"), res.getString("images"),
							res.getInt("roleId"), res.getString("phone"), res.getDate("createDate"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void insert(UserModel user) {
		String sqlInsert = "INSERT INTO users(username, password, fullname, email, images, roleid, phone, createDate) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = super.getDatabaseConnection(); 
				PreparedStatement ps = conn.prepareStatement(sqlInsert)) {

			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFullName());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getImages());
			ps.setInt(6, user.getRoleId());
			ps.setString(7, user.getPhone());
			ps.setDate(8, user.getCreateDate());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public UserModel findByUsername(String username) {
		String sql = "SELECT * FROM users WHERE username = ?";
		try (Connection conn = super.getDatabaseConnection(); 
				PreparedStatement ps = conn.prepareStatement(sql);) {

			ps.setString(1, username);
			try (ResultSet res = ps.executeQuery()) {
				if (res.next()) {
					return new UserModel(res.getInt("id"), res.getString("username"), res.getString("password"),
							res.getString("fullName"), res.getString("email"), res.getString("images"),
							res.getInt("roleId"), res.getString("phone"), res.getDate("createDate"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean checkExistEmail(String email) {
		String query = "SELECT 1 FROM users WHERE email = ?";
		try (Connection conn = super.getDatabaseConnection(); PreparedStatement ps = conn.prepareStatement(query)) {

			ps.setString(1, email);
			try (ResultSet res = ps.executeQuery()) {
				return res.next();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean checkExistUsername(String username) {
		String query = "SELECT 1 FROM users WHERE username = ?";
		try (Connection conn = super.getDatabaseConnection(); PreparedStatement ps = conn.prepareStatement(query)) {

			ps.setString(1, username);
			try (ResultSet res = ps.executeQuery()) {
				return res.next();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean checkExistPhone(String phone) {
		String query = "SELECT 1 FROM users WHERE phone = ?";
		try (Connection conn = super.getDatabaseConnection(); PreparedStatement ps = conn.prepareStatement(query)) {

			ps.setString(1, phone);
			try (ResultSet res = ps.executeQuery()) {
				return res.next();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public UserModel findOne(String username) {
		String sql = "SELECT  id, username, password, fullname, email, images, roleId, phone, createDate FROM users WHERE username = ?";
		try (Connection conn = super.getDatabaseConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, username);
			try (ResultSet res = ps.executeQuery()) {
				if (res.next()) {
					return new UserModel(
							res.getInt("id"),
							res.getString("username"), 
							res.getString("password"),
							res.getString("fullName"), 
							res.getString("email"), 
							res.getString("images"),
							res.getInt("roleId"), 
							res.getString("phone"), 
							res.getDate("createDate"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public boolean updatePassword(String username, String newPassword) {
		String sql = "UPDATE users SET password = ? WHERE username = ?";
		try (Connection conn = super.getDatabaseConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, newPassword); 
			ps.setString(2, username);
			int updated = ps.executeUpdate();
			return updated > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void insertRegister(UserModel user) {
		String sqlInsert = "INSERT INTO users(username, password, fullname, email, status, roleid, code) VALUES(?,?,?,?,?,?,?)";
		try (Connection conn = super.getDatabaseConnection(); 
				PreparedStatement ps = conn.prepareStatement(sqlInsert)) {
			System.out.println(user.getStatus());
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFullName());
			ps.setString(4, user.getEmail());
			ps.setInt(5, user.getStatus());
			ps.setInt(6, user.getRoleId());
			ps.setString(7, user.getCode());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateStatus(UserModel user) {
		String sql = "UPDATE users SET status=?, code=? WHERE email = ?";
		
		try(Connection conn = super.getDatabaseConnection(); 
				PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, user.getStatus());
			ps.setString(2, user.getCode());
			ps.setString(3, user.getEmail());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {

	}

	@Override
	public boolean update(UserModel user) {
		String sql = "UPDATE users SET fullName = ?, images = ?, phone = ? WHERE id = ?";
		try(Connection conn = super.getDatabaseConnection(); 
				PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setString(1, user.getFullName());
			ps.setString(2, user.getImages());
			ps.setString(3, user.getPhone());
			ps.setInt(4, user.getId());
			ps.executeUpdate();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
