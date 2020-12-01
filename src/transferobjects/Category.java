package transferobjects;

import java.io.Serializable;

public class Category implements Serializable {
    public String categoryName;

    public String getCategory() {
        return categoryName;
    }

    public void setCategory(String category) {
        this.categoryName = category;
    }
}
