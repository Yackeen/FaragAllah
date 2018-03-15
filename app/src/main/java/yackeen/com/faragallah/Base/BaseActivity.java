package yackeen.com.faragallah.Base;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.race604.drawable.wave.WaveDrawable;
import com.wang.avi.AVLoadingIndicatorView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Locale;

import yackeen.com.faragallah.Network.Events.CompleteEvent;
import yackeen.com.faragallah.Network.Events.FailEvent;
import yackeen.com.faragallah.Network.Events.NoInternetEvent;
import yackeen.com.faragallah.R;

import static yackeen.com.faragallah.AppClass.isEnglish;

/**
 * Created by Fawzy on 7/2/2018.
 */

public class BaseActivity extends AppCompatActivity {

    public static final String TAG = "fawzyTag";

    public void setProgress(AVLoadingIndicatorView progress) {
//        waveDrawable = new WaveDrawable(ContextCompat.getDrawable(this, R.drawable.app_icon));
//        waveDrawable.setIndeterminate(true);
//        waveDrawable.setWaveLength((int) getResources().getDimension(R.dimen._10sdp));
//        waveDrawable.setWaveAmplitude((int) getResources().getDimension(R.dimen._10sdp));
//        waveDrawable.setWaveSpeed(50);
//        progress.setImageDrawable(waveDrawable);
        this.progress = progress;
    }

    AVLoadingIndicatorView progress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String languageToLoad = isEnglish ? "en" : "ar";
        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
    }


    @Override
    protected void attachBaseContext(Context newBase) {
//        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
        super.attachBaseContext(newBase);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    @Override
    protected void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    public void setShowBackIcon(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onFail(FailEvent event) {
        Log.e(TAG, event.getMessage());
        if (event.getMessage() != null) {
            Toast.makeText(this, getResources().getString(R.string.connection_problem), Toast.LENGTH_LONG).show();
        }
        if (progress != null)
            progress.setVisibility(View.GONE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onComplete(CompleteEvent event) {

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNoInternet(NoInternetEvent event) {
//        Toast.makeText(this, getResources().getString(R.string.connection_problem), Toast.LENGTH_LONG).show();
        Log.d("fawzy.BaseAct", "onNoInternet");
//        if (progress != null)
//            progress.hide();
//        else
        Log.d("fawzy.BaseAct", "onNoInternet.progress=null");
    }

    protected void clearAppData() {
        // get the user key to cache it again after clearing everything

    }

}
