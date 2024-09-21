package vn.chithanh.dao;

import java.util.List;

import vn.chithanh.models.UserModel;

public interface IUserDAO {
	
	List<UserModel> findAll();
	
	UserModel findById(int id);
	
	void insert(UserModel user);
	
	UserModel findByUsername(String username);
	
	UserModel findOne(String username);
	
	void insertRegister(UserModel user);
	
	void updateStatus(UserModel user);
	
	boolean checkExistUsername(String username);
	
	boolean checkExistEmail(String email);
	
	boolean checkExistPhone(String phone);
	
	boolean updatePassword(String username, String newPassword);
	
	boolean update(UserModel user);
	
}
