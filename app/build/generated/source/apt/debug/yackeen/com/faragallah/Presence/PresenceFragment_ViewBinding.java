// Generated code from Butter Knife. Do not modify!
package yackeen.com.faragallah.Presence;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import yackeen.com.faragallah.R;

public class PresenceFragment_ViewBinding implements Unbinder {
  private PresenceFragment target;

  @UiThread
  public PresenceFragment_ViewBinding(PresenceFragment target, View source) {
    this.target = target;

    target.asiaLayout = Utils.findRequiredViewAsType(source, R.id.asia, "field 'asiaLayout'", RelativeLayout.class);
    target.africaLayout = Utils.findRequiredViewAsType(source, R.id.africa, "field 'africaLayout'", RelativeLayout.class);
    target.europeLayout = Utils.findRequiredViewAsType(source, R.id.europe, "field 'europeLayout'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PresenceFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.asiaLayout = null;
    target.africaLayout = null;
    target.europeLayout = null;
  }
}
