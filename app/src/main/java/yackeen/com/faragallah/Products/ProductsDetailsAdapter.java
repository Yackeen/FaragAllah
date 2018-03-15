package yackeen.com.faragallah.Products;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import yackeen.com.faragallah.Base.BaseViewHolder;
import yackeen.com.faragallah.Network.RetrofitModels.Responses.GetProducts;
import yackeen.com.faragallah.R;


/**
 * Created by Abdelrhman Walid on 4/20/2017.
 */

class ProductsDetailsAdapter extends RecyclerView.Adapter<ProductsDetailsAdapter.ViewHolder> {

    private int rowItemsRange;
    private ArrayList<GetProducts.ProductSpesList> dataList;

    public void setProductsArrayList(List<GetProducts.ProductSpesList> list) {
        this.dataList = new ArrayList<>(list);
        notifyDataSetChanged();
    }

    public ProductsDetailsAdapter(int rowItemsRange) {
        dataList = new ArrayList<>();
        this.rowItemsRange = rowItemsRange;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int pos) {
        View view = null;
        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product_details, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class ViewHolder extends BaseViewHolder {
        @BindView(R.id.text)
        TextView text;
        @BindView(R.id.val)
        TextView textVal;

        ViewHolder(View view) {
            super(view);
            setRowItemsRange(rowItemsRange);
        }

        public void bind(final int position) {
            text.setText(dataList.get(position).getSpecName());
            textVal.setText(dataList.get(position).getSpecValueEn());
        }


    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

}
