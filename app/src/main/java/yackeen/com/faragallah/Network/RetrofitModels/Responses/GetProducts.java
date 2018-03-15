package yackeen.com.faragallah.Network.RetrofitModels.Responses;

import java.util.List;

import yackeen.com.faragallah.Network.RetrofitModels.Base.BaseResponse2;
import yackeen.com.faragallah.Network.RetrofitModels.Base.EmptyResponseObject;

/**
 * Created by elmar7om on 10/02/2018.
 */

public class GetProducts extends EmptyResponseObject {
    private int ID;
    private String Name;
    private String subCategory;
    private String Image;
    private String QRURL;
    private List<ProductSpesList> ProductSpesList;

    public List<GetProducts.ProductSpesList> getProductSpesList() {
        return ProductSpesList;
    }

    public void setProductSpesList(List<GetProducts.ProductSpesList> productSpesList) {
        ProductSpesList = productSpesList;
    }
    public String getQRURL() {
        return QRURL;
    }

    public void setQRURL(String QRURL) {
        this.QRURL = QRURL;
    }

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

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public class ProductSpesList {
        private String SpecName;
        private String SpecValueEn;

        public String getSpecName() {
            return SpecName;
        }

        public void setSpecName(String specName) {
            SpecName = specName;
        }

        public String getSpecValueEn() {
            return SpecValueEn;
        }

        public void setSpecValueEn(String specValueEn) {
            SpecValueEn = specValueEn;
        }


    }

}
