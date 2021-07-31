package com.maxwainer.ui.api.action.button;

import com.maxwainer.ui.api.action.ActionFactory;
import org.jetbrains.annotations.NotNull;

public interface ClickActionFactory<T extends ClickAction> extends ActionFactory<T> {

  @NotNull T createAction();

  @Override
  default @NotNull T createObject() {
    return createAction();
  }
}
