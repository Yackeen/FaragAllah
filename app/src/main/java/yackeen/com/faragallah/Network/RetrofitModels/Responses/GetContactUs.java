package yackeen.com.faragallah.Network.RetrofitModels.Responses;

import yackeen.com.faragallah.Network.RetrofitModels.Base.EmptyResponseObject;

/**
 * Created by elmar7om on 10/02/2018.
 */

public class GetContactUs extends EmptyResponseObject {
    private String ContactEn;
    private  String ContactAr;

    public String getContactEn() {
        return ContactEn;
    }

    public void setContactEn(String contactEn) {
        this.ContactEn = contactEn;
    }

    public String getContactAr() {
        return ContactAr;
    }

    public void setContactAr(String contactAr) {
        ContactAr = contactAr;
    }

}
