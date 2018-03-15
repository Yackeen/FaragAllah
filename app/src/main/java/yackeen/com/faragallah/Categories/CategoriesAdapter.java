package yackeen.com.faragallah.Categories;

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
import yackeen.com.faragallah.Network.RetrofitModels.Responses.GetCategories;
import yackeen.com.faragallah.R;


/**
 * Created by Fawzy on 7/2/2018.
 */

class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {

    private final OnCategoriesClickListener clickListener;
    private final int rowItemRange;
    private ArrayList<GetCategories> dataList;

    public void setCategoriesArrayList(ArrayList<GetCategories> list) {
        this.dataList = new ArrayList<>(list);
        notifyDataSetChanged();
    }

    public CategoriesAdapter(OnCategoriesClickListener clickListener,int rowItemRange) {
        this.clickListener = clickListener;
        dataList = new ArrayList<>();
        this.rowItemRange=rowItemRange;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_category, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        if (dataList == null || dataList.size() == 0)
            return 0;
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
            Log.d("fawzy","productsAdapter.onBind->imageUrl= "+dataList.get(position).getImage());
            textView.setText(dataList.get(position).getName());
            ImageLoader.loadImage(itemView.getContext(),progressBar, imageView, dataList.get(position).getImage());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (dataList.get(position).getName() != null) {
                        clickListener.onCategoryClicked(position);
                    }
                }
            });
            showUpAnimation();
        }

    }
}
