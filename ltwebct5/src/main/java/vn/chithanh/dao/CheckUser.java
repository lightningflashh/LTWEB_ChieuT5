package vn.chithanh.dao;

import java.util.List;

import vn.chithanh.dao.impls.UserDAOImpl;
import vn.chithanh.models.UserModel;

public class CheckUser{
	
	UserDAOImpl impl = new UserDAOImpl();
	public List<UserModel> users = impl.findAll();
	
	public void checkLogin(String username, String password) {
		if(username == null || password == null) {
			System.out.println("Nhập đầy đủ username và password!");
		} else {
			for(UserModel user : users) {
				if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
					System.out.println("Đăng nhập thành công");
				} else {
					System.out.println("Kiểm tra lại mật khẩu hoặc tài khoản");
				}
			}
		}
	}
}
