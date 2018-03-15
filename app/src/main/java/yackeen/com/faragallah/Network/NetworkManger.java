package yackeen.com.faragallah.Network;

import yackeen.com.faragallah.Network.RetrofitModels.Base.BaseCallBack;
import yackeen.com.faragallah.Network.RetrofitModels.Base.BaseCallBack2;
import yackeen.com.faragallah.Network.RetrofitModels.Base.BaseRequestBody;
import yackeen.com.faragallah.Network.RetrofitModels.Requests.EmptyBody;
import yackeen.com.faragallah.Network.RetrofitModels.Requests.GetAboutDetailBody;
import yackeen.com.faragallah.Network.RetrofitModels.Requests.GetCustomersBody;
import yackeen.com.faragallah.Network.RetrofitModels.Requests.GetProductsBody;
import yackeen.com.faragallah.Network.RetrofitModels.Requests.GetSubCategoriesBody;
import yackeen.com.faragallah.Network.RetrofitModels.Responses.GetAbout;
import yackeen.com.faragallah.Network.RetrofitModels.Responses.GetAboutDetail;
import yackeen.com.faragallah.Network.RetrofitModels.Responses.GetCategories;
import yackeen.com.faragallah.Network.RetrofitModels.Responses.GetCertification;
import yackeen.com.faragallah.Network.RetrofitModels.Responses.GetContactUs;
import yackeen.com.faragallah.Network.RetrofitModels.Responses.GetCustomers;
import yackeen.com.faragallah.Network.RetrofitModels.Responses.GetProducts;
import yackeen.com.faragallah.Network.RetrofitModels.Responses.GetSubCategories;

/**
 * Created by elmar7om on 09/02/2018.
 */

public class NetworkManger {
    public static void GetAbout(BaseRequestBody body) {
        APIServices.GetService().GetAbout(body)
                .enqueue(new BaseCallBack2<GetAbout>());
    }
    public static void GetAboutDetail(GetAboutDetailBody body) {
        APIServices.GetService().GetAboutDetail(body)
                .enqueue(new BaseCallBack<GetAboutDetail>());
    }
    public static void GetCertification(BaseRequestBody body) {
        APIServices.GetService().GetCertification(body)
                .enqueue(new BaseCallBack2<GetCertification>());
    }
    public static void GetCustomers(BaseRequestBody body) {
        APIServices.GetService().GetCustomers(body)
                .enqueue(new BaseCallBack2<GetCustomers>());
    }
    public static void GetContactUs(EmptyBody body) {
        APIServices.GetService().GetContactUs(body)
                .enqueue(new BaseCallBack<GetContactUs>());
    }
    public static void GetCategories(BaseRequestBody body) {
        APIServices.GetService().GetCategories(body)
                .enqueue(new BaseCallBack2<GetCategories>());
    }
    public static void GetSubCategories(GetSubCategoriesBody body) {
        APIServices.GetService().GetSubCategories(body)
                .enqueue(new BaseCallBack2<GetSubCategories>());
    }
    public static void GetProductss(GetProductsBody body) {
        APIServices.GetService().GetProducts(body)
                .enqueue(new BaseCallBack2<GetProducts>());
    }
}
