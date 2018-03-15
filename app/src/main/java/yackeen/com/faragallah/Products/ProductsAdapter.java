package yackeen.com.faragallah.Products;

import android.support.v7.widget.LinearLayoutManager;
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
import butterknife.OnClick;
import yackeen.com.faragallah.Base.BaseViewHolder;
import yackeen.com.faragallah.Helpers.ImageLoader.ImageLoader;
import yackeen.com.faragallah.Helpers.QRGeneratorHelper;
import yackeen.com.faragallah.Network.RetrofitModels.Responses.GetProductsSelection;
import yackeen.com.faragallah.R;


/**
 * Created by Abdelrhman Walid on 4/20/2017.
 */

class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {

    public void setClickListener(OnProductClickListener clickListener) {
        this.clickListener = clickListener;
    }

    private int SelectedIndex = -1;
    private OnProductClickListener clickListener;
    private ArrayList<GetProductsSelection> dataList;

    public void setProductsArrayList(ArrayList<GetProductsSelection> list) {
        this.dataList = new ArrayList<>(list);
        notifyDataSetChanged();
    }

    private ArrayList<GetProductsSelection> migrateList(ArrayList<GetProductsSelection> apiList) {
        ArrayList<GetProductsSelection> productsSelections = new ArrayList<>();
        for (int i = 0; i < apiList.size(); i++) {
            GetProductsSelection productItem = new GetProductsSelection(apiList.get(i));
            productsSelections.add(productItem);
        }
        return productsSelections;
    }

    public ProductsAdapter(OnProductClickListener clickListener, int rowItemsRange) {
        this.clickListener = clickListener;
        dataList = new ArrayList<>();

    }

    @Override
    public ProductsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewtype) {
        View view = null;
//        Log.e("fawzy", "onCreateViewHolder with pos " + viewtype + ", selected= " + dataList.get(viewtype).isSelected());
        if (viewtype==0) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_product_selected, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_product_unselected, parent, false);
        }
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductsAdapter.ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class ViewHolder extends BaseViewHolder {
        @BindView(R.id.productName)
        TextView productName;
        @BindView(R.id.recycler)
        RecyclerView recyclerView;
        @BindView(R.id.logo)
        ImageView imageView;
        @BindView(R.id.qr)
        ImageView qrImageView;
        @BindView(R.id.progress)
        ProgressBar progressBar;

        ViewHolder(View view) {
            super(view);
            setRowItemsRange(rowItemsRange);
        }

        public void bind(final int position) {
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (position != SelectedIndex) {
                        Log.d("fawzy", "ProductsAdapter.position= " + position);
//                        setSelectedIndex(position);
                        clickListener.onProductClicked(position, SelectedIndex, dataList);
                    }
                }
            });
            Log.e("fawzy", "productsAdapter.onBind->imageUrl= " + dataList.get(position).getImage());
            ImageLoader.loadImage(itemView.getContext(), progressBar, imageView, dataList.get(position).getImage());
            productName.setText(dataList.get(position).getName());
            setRecycler(position);
            setQr(qrImageView, position);
            showUpAnimation();
        }

        private void doublateItemView(View itemView) {
            ViewGroup.LayoutParams params = itemView.getLayoutParams();
            params.height += params.height / 4;
            params.width += params.width / 4;
            itemView.setLayoutParams(params);
        }

        private void deDoublateItemView(View itemView) {
            ViewGroup.LayoutParams params = itemView.getLayoutParams();
            params.height -= params.height / 5;
            params.width -= params.width / 5;
            itemView.setLayoutParams(params);
        }

        @OnClick(R.id.card)
        void OnItemViewClicked() {

        }


        public void setRecycler(int pos) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.VERTICAL, false);
            recyclerView.setLayoutManager(linearLayoutManager);
            ProductsDetailsAdapter detailsAdapter = new ProductsDetailsAdapter(linearLayoutManager.findLastVisibleItemPosition());
            recyclerView.setAdapter(detailsAdapter);
            detailsAdapter.setProductsArrayList(dataList.get(pos).getProductSpesList());
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (dataList.get(position).isSelected())
            return 0;
        return 1;
    }

    private void setQr(ImageView qrImageView, int position) {
        try {
            Log.e("fawzy", "productAdapter.setQr with qr value= " + dataList.get(position).getQRURL());
            qrImageView.setImageBitmap(QRGeneratorHelper.TextToImageEncode(dataList.get(position).getQRURL(), qrImageView.getWidth()));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setSelectedIndex(int position) {
//        if (SelectedIndex != -1)
//            dataList.get(SelectedIndex).setSelected(false);
        dataList.get(position).setSelected(true);
//        int oldSelected = SelectedIndex;
//        SelectedIndex = position;
////        notifyDataSetChanged();
//        if (SelectedIndex != -1)
//            notifyItemChanged(oldSelected);
        notifyItemChanged(position);
    }

    public void setDoubled(int SelectedIndex) {
        this.SelectedIndex = SelectedIndex;
    }
}
