package yackeen.com.faragallah.Network.RetrofitModels.Requests;

import yackeen.com.faragallah.Network.RetrofitModels.Base.BaseRequestBody;

/**
 * Created by Abdelrhman Walid on 5/18/2017.
 */

public class GetAboutDetailBody extends BaseRequestBody {

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    private String ID;
}
