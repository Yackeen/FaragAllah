package yackeen.com.faragallah.Partners;

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
import yackeen.com.faragallah.Network.RetrofitModels.Responses.GetCustomers;
import yackeen.com.faragallah.R;
import yackeen.com.faragallah.certificates.OnCertificateClickListener;


/**
 * Created by Abdelrhman Walid on 4/20/2017.
 */

class PartnersAdapter extends RecyclerView.Adapter<PartnersAdapter.ViewHolder> {

    private int rowItemRange;
    private OnCertificateClickListener clickListener;
    private boolean animationPlayed;
    private int SelectedIndex;
    private ArrayList<GetCustomers> dataList;

    public void setCustomersArrayList(ArrayList<GetCustomers> list) {
        this.dataList = new ArrayList<>(list);
        notifyDataSetChanged();
        this.rowItemRange = rowItemRange;
    }

    public PartnersAdapter(OnCertificateClickListener clickListener, int rowItemRange) {
        this.clickListener = clickListener;
        dataList = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewtype) {
        View view = null;
//        Log.d("fawzy", "CustomersAdapter.onCreateViewHolder.SelectedIndex= " + SelectedIndex + " ,pos= " + pos);
        if (viewtype == 0) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_partner_selected, parent, false);
        } else
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_partner, parent, false);
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
        @BindView(R.id.logo)
        ImageView imageView;
        @BindView(R.id.desc)
        TextView textView;
        @BindView(R.id.progress)
        ProgressBar progressBar;


        ViewHolder(View view) {
            super(view);
            setRowItemsRange(rowItemRange);
        }

        public void bind(final int position) {
            Log.d("fawzy", "productsAdapter.onBind->imageUrl= " + dataList.get(position).getLogo());
            ImageLoader.loadBase64CircleImage(itemView.getContext(),progressBar, imageView, dataList.get(position).getLogo());
            textView.setText(dataList.get(position).getName());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setSelectedIndex(position);
                    Log.d("fawzy", "CustomersAdapter.SelectedIndex= " + SelectedIndex);
                    clickListener.onCertificateClicked(position);
                }
            });
            showUpAnimation();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (SelectedIndex == position)
            return 0;
        return 1;
    }

    public void setSelectedIndex(int selectedIndex) {
        int oldSelected = SelectedIndex;
        SelectedIndex = selectedIndex;
        notifyItemChanged(oldSelected);
        notifyItemChanged(selectedIndex);
    }

}
