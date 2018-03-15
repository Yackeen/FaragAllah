package yackeen.com.faragallah.Network.RetrofitModels.Requests;

import yackeen.com.faragallah.Network.RetrofitModels.Base.BaseRequestBody;

/**
 * Created by Abdelrhman Walid on 5/18/2017.
 */

public class GetCustomersBody extends BaseRequestBody {

    public String getMarketID() {
        return MarketID;
    }

    public void setMarketID(String marketID) {
        MarketID = marketID;
    }

    private String MarketID;
}
