package yackeen.com.faragallah.Network.RetrofitModels.Responses;

import yackeen.com.faragallah.Network.RetrofitModels.Base.EmptyResponseObject;

/**
 * Created by elmar7om on 10/02/2018.
 */

public class GetAboutDetail extends EmptyResponseObject {
    private String Description;
    private String Title;
    private String ContentImage;
    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }



    public String getContentImage() {
        return ContentImage;
    }

    public void setContentImage(String contentImage) {
        ContentImage = contentImage;
    }



    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
