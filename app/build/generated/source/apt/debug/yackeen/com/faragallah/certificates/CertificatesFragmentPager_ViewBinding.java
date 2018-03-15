// Generated code from Butter Knife. Do not modify!
package yackeen.com.faragallah.certificates;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import yackeen.com.faragallah.R;

public class CertificatesFragmentPager_ViewBinding implements Unbinder {
  private CertificatesFragmentPager target;

  @UiThread
  public CertificatesFragmentPager_ViewBinding(CertificatesFragmentPager target, View source) {
    this.target = target;

    target.viewPager = Utils.findRequiredViewAsType(source, R.id.pager, "field 'viewPager'", ViewPager.class);
    target.desc = Utils.findRequiredViewAsType(source, R.id.desc, "field 'desc'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CertificatesFragmentPager target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.viewPager = null;
    target.desc = null;
  }
}
