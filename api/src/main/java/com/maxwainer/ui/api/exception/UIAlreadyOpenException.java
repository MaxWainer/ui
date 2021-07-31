package com.maxwainer.ui.api.exception;

import com.maxwainer.ui.api.abstraction.UI;
import com.maxwainer.ui.api.user.UIUser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class UIAlreadyOpenException extends RuntimeException implements UIException {

  private final UI<?> ui;
  private final UIUser<?> user;

  public UIAlreadyOpenException(@NotNull String message, @Nullable UI<?> ui,
      @Nullable UIUser<?> user) {
    super(String.format(message, ui, user));
    this.ui = ui;
    this.user = user;
  }

  public UIAlreadyOpenException(@Nullable UI<?> ui, @Nullable UIUser<?> user) {
    this("Generated an exception while opening ui for user %s, initiator %s", ui, user);
  }

  @Override
  public @Nullable UI<?> thrownUI() {
    return ui;
  }

  @Override
  public @Nullable UIUser<?> thrownUser() {
    return user;
  }
}
