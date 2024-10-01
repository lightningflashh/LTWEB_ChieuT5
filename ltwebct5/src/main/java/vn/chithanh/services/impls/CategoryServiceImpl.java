package vn.chithanh.services.impls;

import java.util.List;

import vn.chithanh.dao.impls.CategoryDAOImpl;
import vn.chithanh.models.CategoryModel;
import vn.chithanh.services.ICategoryService;

public class CategoryServiceImpl implements ICategoryService{
	
	CategoryDAOImpl catDAO = new CategoryDAOImpl();

	@Override
	public List<CategoryModel> findAll() {
		return catDAO.findAll();
	}

	@Override
	public CategoryModel findById(int categoryid) {
		return catDAO.findById(categoryid);
	}

	@Override
	public void insert(CategoryModel category) {
		if(catDAO.findById(category.getCategoryID()) == null) {
			catDAO.insert(category);
		}
	}

	@Override
	public void update(CategoryModel category) {
		if (catDAO.findById(category.getCategoryID()) != null) {
			catDAO.update(category);
		}
	}

	@Override
	public void delete(int id) {
		if (catDAO.findById(id) != null) {
			catDAO.delete(id);
		}
	}

	@Override
	public List<CategoryModel> findName(String keyword) {
		return catDAO.findName(keyword);
	}

	@Override
	public void softDelete(CategoryModel category) {
		catDAO.softDelete(category);
	}

}
