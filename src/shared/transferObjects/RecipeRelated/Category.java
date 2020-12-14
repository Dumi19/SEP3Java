package shared.transferObjects.RecipeRelated;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable {
    public String categoryName;
    public List<RecipeCategory> RecipeCategories;

    public String getCategory() {
        return categoryName;
    }

    public void setCategory(String category) {
        this.categoryName = category;
    }

    public String toString(){
        return categoryName;
    }
}
