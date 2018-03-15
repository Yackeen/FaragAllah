// Generated code from Butter Knife. Do not modify!
package yackeen.com.faragallah.Home;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.CardView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import yackeen.com.faragallah.R;

public class HomeFragment_ViewBinding implements Unbinder {
  private HomeFragment target;

  private View view2131230726;

  private View view2131230882;

  private View view2131230884;

  private View view2131230777;

  private View view2131230770;

  private View view2131230785;

  @UiThread
  public HomeFragment_ViewBinding(final HomeFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.about, "field 'about' and method 'onAboutClicked'");
    target.about = Utils.castView(view, R.id.about, "field 'about'", CardView.class);
    view2131230726 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onAboutClicked();
      }
    });
    view = Utils.findRequiredView(source, R.id.partners, "field 'partners' and method 'onPartnersClicked'");
    target.partners = Utils.castView(view, R.id.partners, "field 'partners'", CardView.class);
    view2131230882 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onPartnersClicked();
      }
    });
    view = Utils.findRequiredView(source, R.id.presence, "field 'presence' and method 'onPresenceClicked'");
    target.presence = Utils.castView(view, R.id.presence, "field 'presence'", CardView.class);
    view2131230884 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onPresenceClicked();
      }
    });
    view = Utils.findRequiredView(source, R.id.certificates, "field 'certificates' and method 'onCertificatesClicked'");
    target.certificates = Utils.castView(view, R.id.certificates, "field 'certificates'", CardView.class);
    view2131230777 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onCertificatesClicked();
      }
    });
    view = Utils.findRequiredView(source, R.id.categories, "field 'categories' and method 'onProductsClicked'");
    target.categories = Utils.castView(view, R.id.categories, "field 'categories'", CardView.class);
    view2131230770 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onProductsClicked();
      }
    });
    view = Utils.findRequiredView(source, R.id.contactUs, "field 'contactUs' and method 'onContactUsClicked'");
    target.contactUs = Utils.castView(view, R.id.contactUs, "field 'contactUs'", CardView.class);
    view2131230785 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onContactUsClicked();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    HomeFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.about = null;
    target.partners = null;
    target.presence = null;
    target.certificates = null;
    target.categories = null;
    target.contactUs = null;

    view2131230726.setOnClickListener(null);
    view2131230726 = null;
    view2131230882.setOnClickListener(null);
    view2131230882 = null;
    view2131230884.setOnClickListener(null);
    view2131230884 = null;
    view2131230777.setOnClickListener(null);
    view2131230777 = null;
    view2131230770.setOnClickListener(null);
    view2131230770 = null;
    view2131230785.setOnClickListener(null);
    view2131230785 = null;
  }
}
