package yackeen.com.faragallah.Network.RetrofitModels.Requests;

import yackeen.com.faragallah.Network.RetrofitModels.Base.BaseRequestBody;

/**
 * Created by Abdelrhman Walid on 5/18/2017.
 */

public class GetProductsBody extends BaseRequestBody {

    public int getSubCategoryID() {
        return SubCategoryID;
    }

    public void setSubCategoryID(int subCategoryID) {
        SubCategoryID = subCategoryID;
    }

    private int SubCategoryID;
}
