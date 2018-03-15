package yackeen.com.faragallah.Products;

import java.util.ArrayList;

import yackeen.com.faragallah.Network.RetrofitModels.Responses.GetProductsSelection;

/**
 * Created by elmar7om on 09/02/2018.
 */

public interface OnProductClickListener {
    public void onProductClicked(int position, int doubledIndex, ArrayList<GetProductsSelection> productsSelections);
}
