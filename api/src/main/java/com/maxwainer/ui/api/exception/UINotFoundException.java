package com.maxwainer.ui.api.exception;

import com.maxwainer.ui.api.abstraction.UI;
import com.maxwainer.ui.api.user.UIUser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class UINotFoundException extends Exception implements UIException {

  public UINotFoundException(@NotNull String message) {
    super(message);
  }

  public UINotFoundException() {
  }

  @Override
  public @Nullable UI<?> thrownUI() {
    return null;
  }

  @Override
  public @Nullable UIUser<?> thrownUser() {
    return null;
  }
}
