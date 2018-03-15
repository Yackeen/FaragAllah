// Generated code from Butter Knife. Do not modify!
package yackeen.com.faragallah.certificates;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import org.mightyfrog.widget.CenteringRecyclerView;
import yackeen.com.faragallah.R;

public class CertificatesFragment_ViewBinding implements Unbinder {
  private CertificatesFragment target;

  @UiThread
  public CertificatesFragment_ViewBinding(CertificatesFragment target, View source) {
    this.target = target;

    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.recyclerH, "field 'recyclerView'", CenteringRecyclerView.class);
    target.desc = Utils.findRequiredViewAsType(source, R.id.desc, "field 'desc'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CertificatesFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recyclerView = null;
    target.desc = null;
  }
}
