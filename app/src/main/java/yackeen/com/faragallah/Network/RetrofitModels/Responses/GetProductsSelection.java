package yackeen.com.faragallah.Network.RetrofitModels.Responses;

/**
 * Created by Fawzy on 3/5/18.
 */

public class GetProductsSelection extends GetProducts {
    public GetProductsSelection(GetProducts getProducts) {
        setID(getProducts.getID());
        setImage(getProducts.getImage());
        setName(getProducts.getName());
        setProductSpesList(getProducts.getProductSpesList());
        setQRURL(getProducts.getQRURL());
        setSubCategory(getProducts.getSubCategory());
        setSelected(false);
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    private boolean selected;
}
