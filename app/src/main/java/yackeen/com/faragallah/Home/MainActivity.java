package yackeen.com.faragallah.Home;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wang.avi.AVLoadingIndicatorView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import yackeen.com.faragallah.About.AboutFragment;
import yackeen.com.faragallah.AppClass;
import yackeen.com.faragallah.Base.BaseActivity;
import yackeen.com.faragallah.Brands.BrandsFragment;
import yackeen.com.faragallah.ContactUs.ContactUsFragment;
import yackeen.com.faragallah.Partners.PartnersFragment;
import yackeen.com.faragallah.Presence.PresenceFragment;
import yackeen.com.faragallah.Categories.CategoriesFragment;
import yackeen.com.faragallah.Products.ProductsFragment;
import yackeen.com.faragallah.R;
import yackeen.com.faragallah.certificates.CertificatesFragment;
import yackeen.com.faragallah.certificates.CertificatesFragmentPager;

public class MainActivity extends BaseActivity implements OnFragmentInteractionListener, OnRequestingApiListener, OnDisplayingHomeListener {
    private static Activity instance;
    private HomeFragment homeFragment;
    private AboutFragment aboutFragment;
    private CategoriesFragment categoriesFragment;
    private PresenceFragment presenceFragment;
    private CertificatesFragment certificatesFragment;
    private CertificatesFragmentPager certificatesFragmentPager;
    private BrandsFragment brandsFragment;
    private ProductsFragment productsFragment;
    private PartnersFragment partnersFragment;
    private ContactUsFragment contactUsFragment;
    private int backPressed;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.lang)
    TextView languageTV;
    @BindView(R.id.backText)
    TextView backText;
    @BindView(R.id.progress)
    AVLoadingIndicatorView progress;
    @BindView(R.id.header)
    LinearLayout headerLayout;
    @BindView(R.id.back)
    LinearLayout backLayout;
    @BindView(R.id.content)
    FrameLayout frameLayout;
    private int category_id;
    private int brandId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instance = this;
        ButterKnife.bind(this);
        languageTV.setText(AppClass.isEnglish ? "عربي" : "English");
        initFragments();
//        showFirstHome();
        showHome();
        setProgress(progress);
    }

    private void showFirstHome() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showHome();
            }
        }, 250);
    }

    @Override
    protected void onStart() {
        super.onStart();
        animateHeader();
    }

    private void animateHeader() {
//        Animator.scaleY(headerLayout, 2000, 250, "show");
    }

    private void setActivityTitle(String str) {
        title.setText(str);
    }

    private void initFragments() {
        homeFragment = new HomeFragment();
        aboutFragment = new AboutFragment();
        presenceFragment = new PresenceFragment();
        categoriesFragment = new CategoriesFragment();
        certificatesFragment = new CertificatesFragment();
        brandsFragment = new BrandsFragment();
        productsFragment = new ProductsFragment();
        certificatesFragmentPager = new CertificatesFragmentPager();
        partnersFragment = new PartnersFragment();
        contactUsFragment = new ContactUsFragment();
    }

    private void showHome() {
        setActivityTitle(getResources().getString(R.string.home));
        getSupportFragmentManager().beginTransaction().replace(R.id.content, homeFragment).commit();
    }

    private void showPresence() {
        backText.setText(getResources().getString(R.string.home));
        setActivityTitle(getResources().getString(R.string.presence));
        getSupportFragmentManager().beginTransaction().replace(R.id.content, presenceFragment).commit();
    }

    private void showAbout() {
        setActivityTitle(getResources().getString(R.string.about_us));
        backText.setText(getResources().getString(R.string.home));
        getSupportFragmentManager().beginTransaction().replace(R.id.content, aboutFragment).commit();
    }

    private void showCategories() {
        setActivityTitle(getResources().getString(R.string.categories));
        backText.setText(getResources().getString(R.string.home));
        getSupportFragmentManager().beginTransaction().replace(R.id.content, categoriesFragment).commit();
    }

    private void showCertificates() {
        setActivityTitle(getResources().getString(R.string.certificates));
        backText.setText(getResources().getString(R.string.home));
        getSupportFragmentManager().beginTransaction().replace(R.id.content, certificatesFragment).commit();
//        getSupportFragmentManager().beginTransaction().replace(R.id.content, certificatesFragmentPager).commit();
    }

    private void showBrands(int id) {
        setActivityTitle(getResources().getString(R.string.brands));
        backText.setText(getResources().getString(R.string.categories));
        brandsFragment = BrandsFragment.newInstance(id);
        getSupportFragmentManager().beginTransaction().replace(R.id.content, brandsFragment).commit();
    }

    private void showProducts(int category_id, int brandId) {
        setActivityTitle(getResources().getString(R.string.products));
        productsFragment = ProductsFragment.newInstance(category_id, brandId);
        backText.setText(getResources().getString(R.string.brands));
        getSupportFragmentManager().beginTransaction().replace(R.id.content, productsFragment).commit();
    }

    private void showPartners() {
        setActivityTitle(getResources().getString(R.string.partners));
        backText.setText(getResources().getString(R.string.home));
        getSupportFragmentManager().beginTransaction().replace(R.id.content, partnersFragment).commit();
    }

    private void showContactUs() {
        setActivityTitle(getResources().getString(R.string.contactUs));
        backText.setText(getResources().getString(R.string.home));
        getSupportFragmentManager().beginTransaction().replace(R.id.content, contactUsFragment).commit();
    }

    @SuppressLint("LongLogTag")
    @Override
    public void onFragmentInteraction(int fragment_id, int... id) {
        switch (fragment_id) {
            case R.id.about:
                showAbout();
                break;
            case R.id.partners:
                showPartners();
                break;
            case R.id.presence:
                showPresence();
                break;
            case R.id.contactUs:
                showContactUs();
                break;
            case R.id.categories:
                showCategories();
                break;
            case R.id.certificates:
                showCertificates();
                break;
            case R.id.brands:
                category_id = id[0];
                showBrands(id[0]);
                break;
            case R.id.products:
                category_id = id[0];
                brandId = id[1];
                showProducts(category_id, brandId);
                break;
        }
    }

    @OnClick(R.id.back)
    void onBackClicked() {
        onBackPressed();
    }

    @OnClick(R.id.logoLayout)
    void onLogoClicked() {
        showHome();
    }

    @Override
    public void onBackPressed() {
        if (homeFragment.isActive()) {
            if (backPressed < 1) {
                Snackbar.make(title, getResources().getString(R.string.press_back_again), Snackbar.LENGTH_LONG).show();
                backPressed++;
                startHandler();
            } else
                super.onBackPressed();
        } else if (aboutFragment.isActive() || presenceFragment.isActive() || categoriesFragment.isActive()
                || certificatesFragment.isActive() || certificatesFragmentPager.isActive() || partnersFragment.isActive()
                || contactUsFragment.isActive())
            showHome();
        else if (brandsFragment.isActive())
            showCategories();
        else if (productsFragment.isActive())
            showBrands(category_id);

    }

    private void startHandler() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                backPressed = 0;
            }
        }, 3000);
    }

    public static Activity getInstance() {
        return instance;
    }

    @OnClick(R.id.lang)
    void onLanguageClicked() {
        AppClass.switchLang(this);
        startActivity(new Intent(getIntent()));
        finish();
    }

    @Override
    public void showProgress() {
        if (progress != null) {
            progress.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void hideProgress() {
        if (progress != null) {
            progress.setVisibility(View.GONE);
        }
    }

    @Override
    public void onStartHomeFragment() {
//        Animator.deScaleX(backLayout, 500, 250, "hide");
        backLayout.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onStopHomeFragment() {
        backLayout.setVisibility(View.VISIBLE);
//        Animator.scaleX(backLayout, 500, 250, "show");
    }
}