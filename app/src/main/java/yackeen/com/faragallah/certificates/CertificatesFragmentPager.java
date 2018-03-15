package yackeen.com.faragallah.certificates;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import yackeen.com.faragallah.Base.BaseFragment;
import yackeen.com.faragallah.Home.OnFragmentInteractionListener;
import yackeen.com.faragallah.R;


public class CertificatesFragmentPager extends BaseFragment implements OnCertificateClickListener {

    private View view;
    @BindView(R.id.pager)
    ViewPager viewPager;
    @BindView(R.id.desc)
    TextView desc;
    private AdapterViewpager adapterViewpager;

    public CertificatesFragmentPager() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_certificate_pager, container, false);
        setView(view);
        setCertificatesRecycler();
        return view;

    }

    private void setCertificatesRecycler() {
        adapterViewpager = new AdapterViewpager(getActivity());
        viewPager.setAdapter(adapterViewpager);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Toast.makeText(getContext(), ""+position, Toast.LENGTH_SHORT).show();
                adapterViewpager.setSelectedPage(position);
                adapterViewpager.notifyDataSetChanged();

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }



    @Override
    public void onCertificateClicked(int position) {

//        recyclerView.center(position);
    }
}
