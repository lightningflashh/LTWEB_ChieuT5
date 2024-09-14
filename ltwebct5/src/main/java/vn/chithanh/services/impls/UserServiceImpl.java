package vn.chithanh.services.impls;

import vn.chithanh.dao.IUserDAO;
import vn.chithanh.dao.impls.UserDAOImpl;
import vn.chithanh.models.UserModel;
import vn.chithanh.services.IUserService;

public class UserServiceImpl implements IUserService {
	
	// get all methods from UserDAO
	IUserDAO userDAO = new UserDAOImpl();

	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.findByUserName(username);
		if(user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	@Override
	public UserModel findByUserName(String username) {
		return userDAO.findByUsername(username);
	}
	
	@Override
	public UserModel findOne(String username) {
		return userDAO.findOne(username);
	}

	@Override
	public void insert(UserModel user) {
		userDAO.insert(user);
		
	}

	@Override
	public boolean register(String username, String password, String fullName, String email, String images, String phone) {
	    
		if (this.checkExistUsername(username)) {
	        return false;
	    }
		
		if (this.checkExistEmail(email)) {
			return false;
		}
		
		if (this.checkExistPhone(phone)) {
			return false;
		}

	    // Get the current date
	    java.sql.Date date = new java.sql.Date(System.currentTimeMillis());

	  
	    userDAO.insert(new UserModel(username, password, fullName, email, images, 3, phone, date));

	    return true;
	}

	@Override
	public boolean checkExistEmail(String email) {
		return userDAO.checkExistEmail(email);
	}

	@Override
	public boolean checkExistUsername(String username) {
		return userDAO.checkExistUsername(username);
	}

	@Override
	public boolean checkExistPhone(String phone) {
		return userDAO.checkExistPhone(phone);
	}
	
	@Override
	public boolean updatePassword(String username, String newPassword) {
		return userDAO.updatePassword(username, newPassword);
	}
	
	public static void main(String[] args) {
	    UserServiceImpl userService = new UserServiceImpl();

	    boolean isRegistered = userService.register(
	        "user",    
	        "123", 
	        "Nguyen Van Binh",     
	        "nvb@example.com", 
	        "path/to/image4.jpg",          
	        "125-456-7890"  
	    );

	  
	    if (isRegistered) {
	        System.out.println("User registered successfully!");
	    } else {
	        System.out.println("Username already exists. Registration failed.");
	    }

	}

}
