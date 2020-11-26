package transferobjects;

import java.io.Serializable;

public class Category implements Serializable {
    public String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
