package yackeen.com.faragallah.Splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;

import com.bumptech.glide.load.resource.gif.GifDrawable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.droidsonroids.gif.GifImageView;
import yackeen.com.faragallah.Base.BaseActivity;
import yackeen.com.faragallah.Helpers.Animator;
import yackeen.com.faragallah.Helpers.Screeninfo;
import yackeen.com.faragallah.Home.MainActivity;
import yackeen.com.faragallah.R;


public class SplashActivity extends BaseActivity {
    private static final int ANIMATION_DURATION = 3000, DELAY = 500;
    @BindView(R.id.logo)
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Animator.fade(imageView, ANIMATION_DURATION);
        startHandler();
    }

    private void startHandler() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }, ANIMATION_DURATION + DELAY);
    }

    @Override
    protected void onStop() {
        super.onStop();

    }
}
