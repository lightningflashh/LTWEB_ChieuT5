package vn.chithanh.dao;

import java.util.List;

import vn.chithanh.models.UserModel;

public interface IUserDAO {
	
	List<UserModel> findAll();
	
	UserModel findById(int id);
	
	void insert(UserModel user);
	
	UserModel login(String username, String password);
	
	UserModel findByUsername(String username);
	
	boolean register(String username, String password, String email, String fullname, String images);
	
	boolean checkExistEmail(String email);
	
	boolean checkExistUsername(String username);
}
