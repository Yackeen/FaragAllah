// Generated code from Butter Knife. Do not modify!
package yackeen.com.faragallah.Home;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.wang.avi.AVLoadingIndicatorView;
import java.lang.IllegalStateException;
import java.lang.Override;
import yackeen.com.faragallah.R;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  private View view2131230851;

  private View view2131230756;

  private View view2131230860;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(final MainActivity target, View source) {
    this.target = target;

    View view;
    target.title = Utils.findRequiredViewAsType(source, R.id.title, "field 'title'", TextView.class);
    view = Utils.findRequiredView(source, R.id.lang, "field 'languageTV' and method 'onLanguageClicked'");
    target.languageTV = Utils.castView(view, R.id.lang, "field 'languageTV'", TextView.class);
    view2131230851 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onLanguageClicked();
      }
    });
    target.backText = Utils.findRequiredViewAsType(source, R.id.backText, "field 'backText'", TextView.class);
    target.progress = Utils.findRequiredViewAsType(source, R.id.progress, "field 'progress'", AVLoadingIndicatorView.class);
    target.headerLayout = Utils.findRequiredViewAsType(source, R.id.header, "field 'headerLayout'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.back, "field 'backLayout' and method 'onBackClicked'");
    target.backLayout = Utils.castView(view, R.id.back, "field 'backLayout'", LinearLayout.class);
    view2131230756 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onBackClicked();
      }
    });
    target.frameLayout = Utils.findRequiredViewAsType(source, R.id.content, "field 'frameLayout'", FrameLayout.class);
    view = Utils.findRequiredView(source, R.id.logoLayout, "method 'onLogoClicked'");
    view2131230860 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onLogoClicked();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.title = null;
    target.languageTV = null;
    target.backText = null;
    target.progress = null;
    target.headerLayout = null;
    target.backLayout = null;
    target.frameLayout = null;

    view2131230851.setOnClickListener(null);
    view2131230851 = null;
    view2131230756.setOnClickListener(null);
    view2131230756 = null;
    view2131230860.setOnClickListener(null);
    view2131230860 = null;
  }
}
