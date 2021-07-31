package com.maxwainer.ui.api.abstraction;

import com.maxwainer.ui.api.action.window.WindowActionHolder;
import com.maxwainer.ui.api.button.UIButtonHolder;
import com.maxwainer.ui.api.user.UIUser;
import com.maxwainer.ui.api.utils.Customizable;
import org.jetbrains.annotations.NotNull;

public interface UI<T extends UI> extends UIButtonHolder<T>, Customizable<T>,
    WindowActionHolder<T> {

  /**
   * This value cannot be null, because when user is closing UI, object is also destroying.
   *
   * @return UI current holder
   */
  @NotNull UIUser<?> holdingUser();

}
