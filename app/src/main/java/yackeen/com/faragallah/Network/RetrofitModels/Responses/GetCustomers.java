package yackeen.com.faragallah.Network.RetrofitModels.Responses;

import java.util.List;

import yackeen.com.faragallah.Network.RetrofitModels.Base.BaseResponse2;
import yackeen.com.faragallah.Network.RetrofitModels.Base.EmptyResponseObject;

/**
 * Created by elmar7om on 10/02/2018.
 */

public class GetCustomers extends EmptyResponseObject {
    private int ID;
    private String Name;
    private String SortIndex;
    private String Logo;
    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    private String Description;

    public String getLogo() {
        return Logo;
    }

    public void setLogo(String logo) {
        Logo = logo;
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

    public String getSortIndex() {
        return SortIndex;
    }

    public void setSortIndex(String sortIndex) {
        SortIndex = sortIndex;
    }

}
