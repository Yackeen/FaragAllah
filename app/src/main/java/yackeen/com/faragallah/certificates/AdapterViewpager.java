package yackeen.com.faragallah.certificates;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import yackeen.com.faragallah.R;


/**
 * Created by fawzy on 1/2/18.
 */
public class AdapterViewpager extends PagerAdapter implements View.OnClickListener {
    Activity context;

    public void setSelectedPage(int selectedPage) {
        this.selectedPage = selectedPage;
    }

    private int selectedPage;


    public AdapterViewpager(Activity activity) {
        context = activity;
    }

    @Override
    public int getCount() {
        return 8;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = null;
        Log.d("fawzy", "viewPagerAdapter.instantiateItem,position= " + position + ", selectedPage= " + selectedPage);
        if (position == selectedPage)
            view = inflater.inflate(R.layout.item_certificate_selected, container, false);
        else view = inflater.inflate(R.layout.item_certificate, container, false);

        container.addView(view);
        return view;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }


    @Override
    public void onClick(View v) {

    }

    @Override
    public float getPageWidth(int position) {
        return (0.2f);
    }
}
