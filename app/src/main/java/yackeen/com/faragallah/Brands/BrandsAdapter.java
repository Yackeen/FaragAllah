package yackeen.com.faragallah.Brands;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import yackeen.com.faragallah.Base.BaseViewHolder;
import yackeen.com.faragallah.Helpers.ImageLoader.ImageLoader;
import yackeen.com.faragallah.Home.MainActivity;
import yackeen.com.faragallah.Network.RetrofitModels.Responses.GetSubCategories;
import yackeen.com.faragallah.R;


/**
 * Created by fawzy 7/2/2018.
 */

class BrandsAdapter extends RecyclerView.Adapter<BrandsAdapter.ViewHolder> {

    private final OnBrandClickListener clickListener;
    private final int rowItemRange;
    private ArrayList<GetSubCategories> dataList;

    public BrandsAdapter(OnBrandClickListener clickListener, int rowItemRange) {
        this.clickListener = clickListener;
        dataList = new ArrayList<>();
        this.rowItemRange = rowItemRange;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        Log.d("fawzy", "BrandsAdapter.onCreateViewHolder.viewType= " + viewType);
        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_brand, parent, false);
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
        TextView textView;
        @BindView(R.id.logo)
        ImageView imageView;
        @BindView(R.id.progress)
        ProgressBar progressBar;

        ViewHolder(View view) {
            super(view);
            setRowItemsRange(rowItemRange);
        }

        public void bind(final int position) {
            Log.d("fawzy", "productsAdapter.onBind->imageUrl= " + dataList.get(position).getImage());
            textView.setText(dataList.get(position).getName());
            ImageLoader.loadImage(itemView.getContext(),progressBar, imageView, dataList.get(position).getImage());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickListener.onBrandClicked(position);
                }
            });
            showUpAnimation();
        }


    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0 || position == 1)
            return 0;
        return position;

    }

    public void setDataList(ArrayList<GetSubCategories> dataList) {
        this.dataList = new ArrayList<>(dataList);
        notifyDataSetChanged();
    }
}
