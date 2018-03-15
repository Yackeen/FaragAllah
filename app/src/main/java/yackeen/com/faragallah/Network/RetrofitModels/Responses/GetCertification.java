package yackeen.com.faragallah.Network.RetrofitModels.Responses;

import yackeen.com.faragallah.Network.RetrofitModels.Base.BaseResponse;
import yackeen.com.faragallah.Network.RetrofitModels.Base.EmptyResponseObject;

/**
 * Created by elmar7om on 10/02/2018.
 */

public class GetCertification extends EmptyResponseObject {
    private int ID;
    private int SortIndex;
    private String Name;
    private String Description;
    String Image;
    public int getSortIndex() {
        return SortIndex;
    }

    public void setSortIndex(int sortIndex) {
        SortIndex = sortIndex;
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

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }


}
