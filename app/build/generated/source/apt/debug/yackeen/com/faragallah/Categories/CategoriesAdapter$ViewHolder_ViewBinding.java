// Generated code from Butter Knife. Do not modify!
package yackeen.com.faragallah.Categories;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import yackeen.com.faragallah.R;

public class CategoriesAdapter$ViewHolder_ViewBinding implements Unbinder {
  private CategoriesAdapter.ViewHolder target;

  @UiThread
  public CategoriesAdapter$ViewHolder_ViewBinding(CategoriesAdapter.ViewHolder target,
      View source) {
    this.target = target;

    target.textView = Utils.findRequiredViewAsType(source, R.id.text, "field 'textView'", TextView.class);
    target.imageView = Utils.findRequiredViewAsType(source, R.id.logo, "field 'imageView'", ImageView.class);
    target.progressBar = Utils.findRequiredViewAsType(source, R.id.progress, "field 'progressBar'", ProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CategoriesAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.textView = null;
    target.imageView = null;
    target.progressBar = null;
  }
}
