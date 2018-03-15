package yackeen.com.faragallah.Network.RetrofitModels.Requests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import yackeen.com.faragallah.Network.RetrofitModels.Base.BaseRequestBody;

/**
 * Created by Abdelrhman Walid on 5/18/2017.
 */

public class GetSubCategoriesBody extends BaseRequestBody {

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int categoryID) {
        CategoryID = categoryID;
    }

    private int CategoryID;
}
