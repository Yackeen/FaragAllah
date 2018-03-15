// Generated code from Butter Knife. Do not modify!
package yackeen.com.faragallah.Products;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;
import org.mightyfrog.widget.CenteringRecyclerView;
import yackeen.com.faragallah.R;

public class ProductsFragment_ViewBinding implements Unbinder {
  private ProductsFragment target;

  private View view2131230762;

  @UiThread
  public ProductsFragment_ViewBinding(final ProductsFragment target, View source) {
    this.target = target;

    View view;
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.recycler, "field 'recyclerView'", CenteringRecyclerView.class);
    target.brandNameTV = Utils.findRequiredViewAsType(source, R.id.brandName, "field 'brandNameTV'", TextView.class);
    target.brandImageView = Utils.findRequiredViewAsType(source, R.id.brandImage, "field 'brandImageView'", CircleImageView.class);
    view = Utils.findRequiredView(source, R.id.brand, "method 'onBrandClicked'");
    view2131230762 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onBrandClicked();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    ProductsFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recyclerView = null;
    target.brandNameTV = null;
    target.brandImageView = null;

    view2131230762.setOnClickListener(null);
    view2131230762 = null;
  }
}
