package yackeen.com.faragallah.About;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import butterknife.BindView;
import yackeen.com.faragallah.Base.BaseFragment;
import yackeen.com.faragallah.Helpers.Animator;
import yackeen.com.faragallah.R;


public class AboutFragment extends BaseFragment {
    private View view;
    @BindView(R.id.companies)
    ConstraintLayout companies;
    @BindView(R.id.employees)
    ConstraintLayout employees;
    @BindView(R.id.presence)
    ConstraintLayout presence;
    @BindView(R.id.certificates)
    ConstraintLayout certificates;
    @BindView(R.id.sku)
    ConstraintLayout sku;
    @BindView(R.id.factories)
    ConstraintLayout factories;
    private int animationDelay = 250, animationDuaraiton = 500;

    public AboutFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();startViewsAnimation();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_about, container, false);
        setView(view);
        return view;

    }

    private void startViewsAnimation() {
        Animator.scaleY(companies, animationDuaraiton, animationDelay , "show");
        Animator.scaleY(factories, animationDuaraiton, animationDelay * 2, "show");
        Animator.scaleY(employees, animationDuaraiton, animationDelay * 3, "show");
        Animator.scaleY(sku, animationDuaraiton, animationDelay * 4, "show");
        Animator.scaleY(certificates, animationDuaraiton, animationDelay * 5, "show");
        Animator.scaleY(presence, animationDuaraiton, animationDelay * 6, "show");
    }



}
