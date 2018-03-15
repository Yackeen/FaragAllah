package yackeen.com.faragallah.Home;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.OnClick;
import yackeen.com.faragallah.Base.BaseFragment;
import yackeen.com.faragallah.Helpers.Animator;
import yackeen.com.faragallah.R;


public class HomeFragment extends BaseFragment {

    private View view;
    @BindView(R.id.about)
    CardView about;
    @BindView(R.id.partners)
    CardView partners;
    @BindView(R.id.presence)
    CardView presence;
    @BindView(R.id.certificates)
    CardView certificates;
    @BindView(R.id.categories)
    CardView categories;
    @BindView(R.id.contactUs)
    CardView contactUs;
    private final int animationDuariton = 500, animationDelay = 250;
    private OnDisplayingHomeListener homeListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        homeListener = (OnDisplayingHomeListener) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        setView(view);
        return view;

    }


    @OnClick(R.id.about)
    void onAboutClicked() {
        onFragmentInteractionListener.onFragmentInteraction(R.id.about);
    }

    @OnClick(R.id.partners)
    void onPartnersClicked() {
        onFragmentInteractionListener.onFragmentInteraction(R.id.partners);
    }

    @OnClick(R.id.presence)
    void onPresenceClicked() {
        onFragmentInteractionListener.onFragmentInteraction(R.id.presence);
    }

    @OnClick(R.id.categories)
    void onProductsClicked() {
        onFragmentInteractionListener.onFragmentInteraction(R.id.categories);
    }

    @OnClick(R.id.certificates)
    void onCertificatesClicked() {
        onFragmentInteractionListener.onFragmentInteraction(R.id.certificates);
    }

    @OnClick(R.id.contactUs)
    void onContactUsClicked() {
        onFragmentInteractionListener.onFragmentInteraction(R.id.contactUs);
    }

    @Override
    public void onStart() {
        super.onStart();
        startViewsAnimation();
        homeListener.onStartHomeFragment();
    }

    private void startViewsAnimation() {
        Animator.TranslationAnimation(about, 0.F, 0.0F, 2.0F, 0.0F,
                animationDelay + animationDuariton, "show");
        Animator.TranslationAnimation(presence, 0.F, 0.0F, 2.0F, 0.0F,
                animationDelay * 2 + animationDuariton, "show");

        Animator.TranslationAnimation(categories, 0.F, 0.0F, -2.0F, 0.0F,
                animationDelay * 3 + animationDuariton, "show");
        Animator.TranslationAnimation(contactUs, 0.F, 0.0F, -2.0F, 0.0F,
                animationDelay * 4 + animationDuariton, "show");

        Animator.scaleX(partners, animationDuariton, animationDelay * 5, "");
        Animator.scaleX(certificates, animationDuariton, animationDelay * 5, "");
    }

    @Override
    public void onStop() {
        super.onStop();
        homeListener.onStopHomeFragment();
    }
}
