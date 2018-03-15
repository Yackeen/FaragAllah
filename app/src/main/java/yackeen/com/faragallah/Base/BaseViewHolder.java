package yackeen.com.faragallah.Base;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.List;

import butterknife.ButterKnife;
import yackeen.com.faragallah.Helpers.ImageLoader.ImageLoader;
import yackeen.com.faragallah.Helpers.RecyclerAnimator;
import yackeen.com.faragallah.Helpers.Screeninfo;

/**
 * Created by Fawzy on 7/2/2018.
 */

public class BaseViewHolder extends RecyclerView.ViewHolder {
    private boolean animationPlayed;

    public void setRowItemsRange(int rowItemsRange) {
        this.rowItemsRange = rowItemsRange;
    }

    public int rowItemsRange;

    public BaseViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }

    public void slidItemsAnimation(int position, Row row) {
        if (position < rowItemsRange && !animationPlayed)
            switch (row) {
                case ONE_ITEM:
                    singleAnimation(position);
                    break;
                case TWO_ITEM:
                    doubleAnimation(position);
                    break;
            }
        else
            animationPlayed = true;
    }

    public void showUpAnimation() {
//        if (!animationPlayed && getAdapterPosition() < 3)
//            RecyclerAnimator.runEnterAnimation(itemView, getAdapterPosition());
//        else animationPlayed = true;
    }

    public void showUpAnimation(List list, int position) {
        if (position < rowItemsRange && !animationPlayed) {
            RecyclerAnimator.runEnterAnimation(itemView, getAdapterPosition());
        }

    }

    private void singleAnimation(int position) {
        RecyclerAnimator.LeftToRightAnimation(itemView.getContext(), itemView, position, Screeninfo.getScreenWidth(itemView.getContext()) / 2);

    }

    private void doubleAnimation(int position) {
        if (position % 2 != 0) {
            RecyclerAnimator.RightToLeftAnimation(itemView.getContext(), itemView, position / 2, Screeninfo.getScreenWidth(itemView.getContext()) / 2);
        } else
            RecyclerAnimator.LeftToRightAnimation(itemView.getContext(), itemView, position / 2, Screeninfo.getScreenWidth(itemView.getContext()) / 2);

    }
    public void bind(final int position) {

    }

}
