package yackeen.com.faragallah.Network;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import yackeen.com.faragallah.Network.RetrofitModels.Base.BaseRequestBody;
import yackeen.com.faragallah.Network.RetrofitModels.Base.BaseResponse;
import yackeen.com.faragallah.Network.RetrofitModels.Base.BaseResponse2;
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

public interface RequestsInterface {
    @POST("About/GetAbout")
    Call<BaseResponse2<GetAbout>> GetAbout(@Body BaseRequestBody body);

    @POST("About/GetAboutDetail")
    Call<BaseResponse<GetAboutDetail>> GetAboutDetail(@Body GetAboutDetailBody body);

    @POST("Crf/GetCertification")
    Call<BaseResponse2<GetCertification>> GetCertification(@Body BaseRequestBody body);

    @POST("Market/GetCustomers")
    Call<BaseResponse2<GetCustomers>> GetCustomers(@Body BaseRequestBody body);

    @POST("ContactUs/GetContactUs")
    Call<BaseResponse<GetContactUs>> GetContactUs(@Body EmptyBody body);

    @POST("Product/GetCategories")
    Call<BaseResponse2<GetCategories>> GetCategories(@Body BaseRequestBody body);

    @POST("Product/GetSubCategories")
    Call<BaseResponse2<GetSubCategories>> GetSubCategories(@Body GetSubCategoriesBody body);

    @POST("Product/GetProducts")
    Call<BaseResponse2<GetProducts>> GetProducts(@Body GetProductsBody body);
}
