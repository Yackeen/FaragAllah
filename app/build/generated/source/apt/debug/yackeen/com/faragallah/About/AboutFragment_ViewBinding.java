// Generated code from Butter Knife. Do not modify!
package yackeen.com.faragallah.About;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import yackeen.com.faragallah.R;

public class AboutFragment_ViewBinding implements Unbinder {
  private AboutFragment target;

  @UiThread
  public AboutFragment_ViewBinding(AboutFragment target, View source) {
    this.target = target;

    target.companies = Utils.findRequiredViewAsType(source, R.id.companies, "field 'companies'", ConstraintLayout.class);
    target.employees = Utils.findRequiredViewAsType(source, R.id.employees, "field 'employees'", ConstraintLayout.class);
    target.presence = Utils.findRequiredViewAsType(source, R.id.presence, "field 'presence'", ConstraintLayout.class);
    target.certificates = Utils.findRequiredViewAsType(source, R.id.certificates, "field 'certificates'", ConstraintLayout.class);
    target.sku = Utils.findRequiredViewAsType(source, R.id.sku, "field 'sku'", ConstraintLayout.class);
    target.factories = Utils.findRequiredViewAsType(source, R.id.factories, "field 'factories'", ConstraintLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AboutFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.companies = null;
    target.employees = null;
    target.presence = null;
    target.certificates = null;
    target.sku = null;
    target.factories = null;
  }
}
