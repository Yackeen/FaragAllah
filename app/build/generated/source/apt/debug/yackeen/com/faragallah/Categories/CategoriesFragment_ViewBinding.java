// Generated code from Butter Knife. Do not modify!
package yackeen.com.faragallah.Categories;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import yackeen.com.faragallah.R;

public class CategoriesFragment_ViewBinding implements Unbinder {
  private CategoriesFragment target;

  @UiThread
  public CategoriesFragment_ViewBinding(CategoriesFragment target, View source) {
    this.target = target;

    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.recycler, "field 'recyclerView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CategoriesFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recyclerView = null;
  }
}
