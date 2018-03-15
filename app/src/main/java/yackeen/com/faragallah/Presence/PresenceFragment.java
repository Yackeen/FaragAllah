package yackeen.com.faragallah.Presence;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.OnClick;
import yackeen.com.faragallah.Base.BaseFragment;
import yackeen.com.faragallah.Helpers.Animator;
import yackeen.com.faragallah.R;


public class PresenceFragment extends BaseFragment {

    private View view;
    private final int AnimationDuration = 500;
    private final int DELAY = 500;
    @BindView(R.id.asia)
    RelativeLayout asiaLayout;
    @BindView(R.id.africa)
    RelativeLayout africaLayout;
    @BindView(R.id.europe)
    RelativeLayout europeLayout;

    public PresenceFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_presence, container, false);
        setView(view);
        return view;

    }

    private void animate() {
        Animator.TranslationAnimation(europeLayout, 0.0F, 0.0F, -2.0F, 0.0F, AnimationDuration, "show");
        Animator.TranslationAnimation(africaLayout, 0.0F, 0.0F, -2.0F, 0.0F, DELAY + AnimationDuration, "show");
        Animator.TranslationAnimation(asiaLayout, 0.0F, 0.0F, -2.0F, 0.0F, 2 * DELAY + AnimationDuration, "show");
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onStart() {
        super.onStart();
        animate();
    }
    @Override
    public void onStop() {
        super.onStop();
        onRequestingApiListener.hideProgress();
    }
    enum Continent {
        ACIA,
        AFRICA,
        AUSTRALIA,
        SOUTH_AMERICA,
        NORTH_AMERICA,
        EUROPE
    }
}
