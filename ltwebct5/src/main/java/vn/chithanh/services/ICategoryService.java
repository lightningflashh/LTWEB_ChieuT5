package vn.chithanh.services;

import java.util.List;

import vn.chithanh.models.CategoryModel;

public interface ICategoryService {
	List<CategoryModel> findAll();
	CategoryModel findById(int categoryid);
	void insert(CategoryModel category);
	void update(CategoryModel category);
	void delete(int id);
	List<CategoryModel> findName(String keyword);
	void softDelete(CategoryModel category);
}
