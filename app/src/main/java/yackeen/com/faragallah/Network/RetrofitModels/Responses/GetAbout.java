package yackeen.com.faragallah.Network.RetrofitModels.Responses;

import java.util.List;

import yackeen.com.faragallah.Network.RetrofitModels.Base.BaseResponse2;
import yackeen.com.faragallah.Network.RetrofitModels.Base.EmptyResponseObject;

/**
 * Created by elmar7om on 10/02/2018.
 */

public class GetAbout extends EmptyResponseObject {
    private int ID;
    private String Name;
    String HeaderImage;

    public String getHeaderImage() {
        return HeaderImage;
    }

    public void setHeaderImage(String headerImage) {
        HeaderImage = headerImage;
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

}
