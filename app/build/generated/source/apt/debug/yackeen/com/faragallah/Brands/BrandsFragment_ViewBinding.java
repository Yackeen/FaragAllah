// Generated code from Butter Knife. Do not modify!
package yackeen.com.faragallah.Brands;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;
import yackeen.com.faragallah.R;

public class BrandsFragment_ViewBinding implements Unbinder {
  private BrandsFragment target;

  private View view2131230771;

  @UiThread
  public BrandsFragment_ViewBinding(final BrandsFragment target, View source) {
    this.target = target;

    View view;
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.recycler, "field 'recyclerView'", RecyclerView.class);
    target.categoryImageView = Utils.findRequiredViewAsType(source, R.id.categoryImage, "field 'categoryImageView'", CircleImageView.class);
    target.categoryNameTV = Utils.findRequiredViewAsType(source, R.id.categoryName, "field 'categoryNameTV'", TextView.class);
    view = Utils.findRequiredView(source, R.id.category, "method 'onCategoryClicked'");
    view2131230771 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onCategoryClicked();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    BrandsFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recyclerView = null;
    target.categoryImageView = null;
    target.categoryNameTV = null;

    view2131230771.setOnClickListener(null);
    view2131230771 = null;
  }
}
