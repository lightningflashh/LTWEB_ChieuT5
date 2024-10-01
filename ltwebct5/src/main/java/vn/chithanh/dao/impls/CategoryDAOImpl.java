package vn.chithanh.dao.impls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.chithanh.dao.ICategoryDAO;
import vn.chithanh.models.CategoryModel;
import vn.chithanh.configuations.DBConnectMySQL;

public class CategoryDAOImpl extends DBConnectMySQL implements ICategoryDAO{

	@Override
	public List<CategoryModel> findAll() {
		String sql = "SELECT * FROM categories";
		List<CategoryModel> categories = new ArrayList<>();
		try (Connection conn = super.getDatabaseConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet res = ps.executeQuery()) {

			while (res.next()) {
				CategoryModel category = new CategoryModel();
				category.setCategoryID(res.getInt("categoryID"));
                category.setCategoryName(res.getString("categoryName"));
                category.setImages(res.getString("images"));
                category.setStatus(res.getInt("status"));
                categories.add(category);
			}
			return categories;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CategoryModel findById(int categoryid) {
		String sql = "SELECT * FROM categories WHERE categoryID = ?";
		CategoryModel category = new CategoryModel();
		try (Connection conn = super.getDatabaseConnection(); 
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, categoryid);
			try (ResultSet res = ps.executeQuery()) {
				if (res.next()) {
					category.setCategoryID(res.getInt("categoryID"));
	                category.setCategoryName(res.getString("categoryName"));
	                category.setImages(res.getString("images"));
	                category.setStatus(res.getInt("status"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return category;
	}

	@Override
	public void insert(CategoryModel category) {
		String sqlInsert = "INSERT INTO categories(categoryName, images, status) VALUES(?, ?, ?)";
		try (Connection conn = super.getDatabaseConnection(); 
				PreparedStatement ps = conn.prepareStatement(sqlInsert)) {

			ps.setString(1, category.getCategoryName());
			ps.setString(2, category.getImages());
			ps.setInt(3, category.getStatus());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(CategoryModel category) {
		String sql = "UPDATE categories SET categoryName = ?, images = ?, status = ? WHERE categoryID = ?";
		try(Connection conn = super.getDatabaseConnection(); 
				PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setString(1, category.getCategoryName());
			ps.setString(2, category.getImages());
			ps.setInt(3, category.getStatus());
			ps.setInt(4, category.getCategoryID());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM categories WHERE categoryID = ?";
		try(Connection conn = super.getDatabaseConnection(); 
				PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<CategoryModel> findName(String keyword) {
		String sql = "SELECT * FROM categories WHERE categoryName like ?";
		List<CategoryModel> categories = new ArrayList<>();
		try (Connection conn = super.getDatabaseConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, "%" + keyword + "%");
			try (ResultSet res = ps.executeQuery()) {
				if (res.next()) {
					CategoryModel category = new CategoryModel();
					category.setCategoryID(res.getInt("categoryID"));
	                category.setCategoryName(res.getString("categoryName"));
	                category.setImages(res.getString("images"));
	                category.setStatus(res.getInt("status"));
	                categories.add(category);
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories;
	}

	@Override
	public void softDelete(CategoryModel category) {
		String sql = "UPDATE categories SET status = ? WHERE categoryID = ?";
		try(Connection conn = super.getDatabaseConnection(); 
				PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, category.getStatus() == 1 ? 0 : 1);
			ps.setInt(2, category.getCategoryID());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
