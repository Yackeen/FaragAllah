// Generated code from Butter Knife. Do not modify!
package yackeen.com.faragallah.Products;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import yackeen.com.faragallah.R;

public class ProductsDetailsAdapter$ViewHolder_ViewBinding implements Unbinder {
  private ProductsDetailsAdapter.ViewHolder target;

  @UiThread
  public ProductsDetailsAdapter$ViewHolder_ViewBinding(ProductsDetailsAdapter.ViewHolder target,
      View source) {
    this.target = target;

    target.text = Utils.findRequiredViewAsType(source, R.id.text, "field 'text'", TextView.class);
    target.textVal = Utils.findRequiredViewAsType(source, R.id.val, "field 'textVal'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ProductsDetailsAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.text = null;
    target.textVal = null;
  }
}
