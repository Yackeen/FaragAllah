// Generated code from Butter Knife. Do not modify!
package yackeen.com.faragallah.ContactUs;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import yackeen.com.faragallah.R;

public class ContactUsFragment_ViewBinding implements Unbinder {
  private ContactUsFragment target;

  @UiThread
  public ContactUsFragment_ViewBinding(ContactUsFragment target, View source) {
    this.target = target;

    target.factoryLayout = Utils.findRequiredViewAsType(source, R.id.factory, "field 'factoryLayout'", LinearLayout.class);
    target.headOfficeLayout = Utils.findRequiredViewAsType(source, R.id.headOffice, "field 'headOfficeLayout'", LinearLayout.class);
    target.mailsLayout = Utils.findRequiredViewAsType(source, R.id.mails, "field 'mailsLayout'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ContactUsFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.factoryLayout = null;
    target.headOfficeLayout = null;
    target.mailsLayout = null;
  }
}
