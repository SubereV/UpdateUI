package Entity;

public class Category {
    private int categoryId, fatherCategoryId; 
    private String name; 

    public Category() {
    }

    public Category(int categoryId, int fatherCategoryId, String name) {
        this.categoryId = categoryId;
        this.fatherCategoryId = fatherCategoryId;
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getFatherCategoryId() {
        return fatherCategoryId;
    }

    public void setFatherCategoryId(int fatherCategoryId) {
        this.fatherCategoryId = fatherCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
