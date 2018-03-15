package yackeen.com.faragallah.Network.RetrofitModels.Responses;

import java.util.List;

import yackeen.com.faragallah.Network.RetrofitModels.Base.BaseResponse2;
import yackeen.com.faragallah.Network.RetrofitModels.Base.EmptyResponseObject;

/**
 * Created by elmar7om on 10/02/2018.
 */

public class GetSubCategories extends EmptyResponseObject {
    private int ID;
    private String Name;
    private String Category;
    String Image;

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }
}
