package yackeen.com.faragallah.Products;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.mightyfrog.widget.CenteringRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import io.paperdb.Paper;
import yackeen.com.faragallah.AppClass;
import yackeen.com.faragallah.Base.BaseFragment;
import yackeen.com.faragallah.Cache.Cache;
import yackeen.com.faragallah.Network.Events.NoInternetEvent;
import yackeen.com.faragallah.Network.NetworkHelper;
import yackeen.com.faragallah.Network.NetworkManger;
import yackeen.com.faragallah.Network.RetrofitModels.Base.BaseResponse2;
import yackeen.com.faragallah.Network.RetrofitModels.Requests.GetProductsBody;
import yackeen.com.faragallah.Network.RetrofitModels.Responses.EmptyCacheData;
import yackeen.com.faragallah.Network.RetrofitModels.Responses.GetProducts;
import yackeen.com.faragallah.Network.RetrofitModels.Responses.GetProductsSelection;
import yackeen.com.faragallah.R;

import static yackeen.com.faragallah.Helpers.ConstantsHolder.getLang;


public class ProductsFragment extends BaseFragment implements OnProductClickListener {

    private View view;
    @BindView(R.id.recycler)
    CenteringRecyclerView recyclerView;
    @BindView(R.id.brandName)
    TextView brandNameTV;
    @BindView(R.id.brandImage)
    CircleImageView brandImageView;
    private int brand_id, categoryId;
    private final StringBuffer cacheTag = new StringBuffer("GetProductsOf");
    private ArrayList<GetProducts> dataList;
    private ProductsAdapter productsAdapter;
    private ArrayList<GetProductsSelection> migratedList;
    private LinearLayoutManager linearLayoutManager;

    public static ProductsFragment newInstance(int categoryId, int brand_id) {
        ProductsFragment fragment = new ProductsFragment();
        Bundle args = new Bundle();
        args.putInt("id", brand_id);
        args.putInt("categoryId", categoryId);
        fragment.setArguments(args);
        return fragment;
    }


    public ProductsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        brand_id = getArguments().getInt("id");
        categoryId = getArguments().getInt("categoryId");
        cacheTag.append(categoryId).append(brand_id);
        Log.d("fawzy", "products.cacheTag= " + cacheTag.toString());
    }

    @Override
    public void onStart() {
        super.onStart();
        getData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_products, container, false);
        setView(view);
        setCertificatesRecycler();
        getData();
        return view;

    }

    private void setCertificatesRecycler() {
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        productsAdapter = new ProductsAdapter(this, linearLayoutManager.findLastVisibleItemPosition());
        recyclerView.setAdapter(productsAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }


    private void getData() {
        if (NetworkHelper.getNetworkState(getActivity()))
            sendRequest();
        else readPaper();

    }

    @Override
    public void readPaper() {
        onRequestingApiListener.showProgress();
        new Thread(new Runnable() {
            @Override
            public void run() {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        onDataLoad((BaseResponse2<GetProducts>) Paper.book().read(cacheTag.toString() + getLang()));
                    }
                });

            }
        }).start();
    }

    @OnClick(R.id.brand)
    void onBrandClicked() {
        getActivity().onBackPressed();
    }

    private void sendRequest() {
        onRequestingApiListener.showProgress();
        GetProductsBody body = new GetProductsBody();
        body.setLang(AppClass.isEnglish ? "en" : "ar");
        body.setSubCategoryID(brand_id);
        NetworkManger.GetProductss(body);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onDataLoad(BaseResponse2<GetProducts> mainResponse) {
        if (mainResponse != null) {
            List<GetProducts> response = mainResponse.getResponse();
            if (response != null) {
                Log.d("fawzy", "Categories.onDataLoad->" + response.getClass());
                updateRecycler(response);
                Cache.cache(cacheTag.toString(), mainResponse);
            } else {
                onNullResponse();
            }
        } else onNullResponse();
        onRequestingApiListener.hideProgress();
    }

    private void onNullResponse() {
        Log.d("fawzy", "Categories.onNullResponse->" + "cache null calling api.. ");
        onRequestingApiListener.hideProgress();
//        sendRequest();
    }

    private void updateRecycler(List<GetProducts> response) {
        dataList = new ArrayList<>(response);
        migratedList = migrateList(dataList);
        productsAdapter.setProductsArrayList(migratedList);


    }

    private ArrayList<GetProductsSelection> migrateList(ArrayList<GetProducts> apiList) {
        ArrayList<GetProductsSelection> productsSelections = new ArrayList<>();
        for (int i = 0; i < apiList.size(); i++) {
            GetProductsSelection productItem = new GetProductsSelection(apiList.get(i));
            productsSelections.add(productItem);
        }
        return productsSelections;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEmptyCache(EmptyCacheData response) {
        Log.d("fawzy", "Categories.onEmptyCache->" + "cache empty calling api.. ");
        onRequestingApiListener.hideProgress();
        sendRequest();
    }

    @Override
    public void onStop() {
        super.onStop();
        onRequestingApiListener.hideProgress();
    }

    @Override
    public void onProductClicked(int position, int doubledIndex, ArrayList<GetProductsSelection> productsSelections) {
        Log.e("fawzy", "onProductClicked with pos= " + position + ", doubled= " + doubledIndex);
        productsSelections.get(position).setSelected(true);
        if (doubledIndex != -1) {
            productsSelections.get(doubledIndex).setSelected(false);
            productsAdapter.notifyItemChanged(doubledIndex);
        }
        productsAdapter.notifyItemChanged(position);
        productsAdapter.setDoubled(position);
        recyclerView.center(position);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNoInternet(NoInternetEvent event) {
//        Toast.makeText(this, getResources().getString(R.string.connection_problem), Toast.LENGTH_LONG).show();
        Log.d("fawzy.products", "onNoInternet");
        onRequestingApiListener.hideProgress();
        readPaper();
    }

}
