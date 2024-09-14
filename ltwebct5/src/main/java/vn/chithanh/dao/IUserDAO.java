package vn.chithanh.dao;

import java.util.List;

import vn.chithanh.models.UserModel;

public interface IUserDAO {
	
	List<UserModel> findAll();
	
	UserModel findById(int id);
	
	void insert(UserModel user);
	
//	UserModel login(String username, String password);
	
	UserModel findByUsername(String username);
	UserModel findOne(String username);
	
//	boolean register(String username, String password, String fullName, String email, String images, int roleId, String phone);
	
	boolean checkExistUsername(String username);
	
	boolean checkExistEmail(String email);
	
	boolean checkExistPhone(String phone);
	
	boolean updatePassword(String username, String newPassword);
	
}
