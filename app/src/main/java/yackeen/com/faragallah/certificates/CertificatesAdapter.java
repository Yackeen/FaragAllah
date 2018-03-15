package yackeen.com.faragallah.certificates;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.ArrayList;

import butterknife.BindView;
import yackeen.com.faragallah.Base.BaseViewHolder;
import yackeen.com.faragallah.Helpers.ImageLoader.ImageLoader;
import yackeen.com.faragallah.Network.RetrofitModels.Responses.GetCertification;
import yackeen.com.faragallah.R;


/**
 * Created by fawzy Walid on 7/2/2018.
 */

class CertificatesAdapter extends RecyclerView.Adapter<CertificatesAdapter.ViewHolder> {

    private OnCertificateClickListener clickListener;
    private int SelectedIndex;
    private ArrayList<GetCertification> dataList;

    public void setCertificatesArrayList(ArrayList<GetCertification> list) {
        this.dataList = new ArrayList<>(list);
        notifyDataSetChanged();
    }

    public CertificatesAdapter(OnCertificateClickListener clickListener) {
        this.clickListener = clickListener;
        dataList = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewtype) {
        View view = null;
//        Log.d("fawzy", "CertificatesAdapter.onCreateViewHolder.SelectedIndex= " + SelectedIndex + " ,viewType= " + view);
        if (viewtype == 0) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_certificate_selected, parent, false);
        } else
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_certificate, parent, false);
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
        @BindView(R.id.progress)
        ProgressBar progressBar;

        ViewHolder(View view) {
            super(view);
        }

        public void bind(final int position) {
            Log.d("fawzy", "certificatesAdapter.onBind->imageUrl= " + dataList.get(position).getImage());
            ImageLoader.loadImage(itemView.getContext(), progressBar, imageView, dataList.get(position).getImage());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setSelectedIndex(position);
                    Log.d("fawzy", "CertificatesAdapter.SelectedIndex= " + SelectedIndex);
                    clickListener.onCertificateClicked(position);
                }
            });
            showUpAnimation();
        }

        void setSelectedIndex(int selectedIndex) {
            Log.e("fawzy.certificates", "setSelectedIndex with old index= " + SelectedIndex + ", &new= " + selectedIndex);
            int oldSelected = SelectedIndex;
            SelectedIndex = selectedIndex;
            notifyItemChanged(oldSelected);
            notifyItemChanged(selectedIndex);
        }
    }

    @Override
    public int getItemViewType(int pos) {
        if (SelectedIndex == pos)
            return 0;
        return 1;
    }


}
