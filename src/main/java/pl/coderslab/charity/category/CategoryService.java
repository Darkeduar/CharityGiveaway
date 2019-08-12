package pl.coderslab.charity.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public void createCategory(Category category){
        categoryRepository.save(category);
    }

    public void editCategory(Category category){
        categoryRepository.save(category);
    }

    public Category getCategoryById(Long id){
        return categoryRepository.getOne(id);
    }

    public void deleteCategory(Long id){
        categoryRepository.delete(categoryRepository.getOne(id));
    }
}
