package com.maxwainer.ui.api.button.impl;

import com.maxwainer.ui.api.action.button.ClickAction;
import com.maxwainer.ui.api.button.UIButton;
import com.maxwainer.ui.api.item.WrappedItemStack;
import java.util.Queue;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractUIButton implements UIButton<AbstractUIButton> {

  @Override
  public AbstractUIButton itemStack(@NotNull WrappedItemStack stack) {
    return null;
  }

  @Override
  public @NotNull Queue<ClickAction<?>> getActionsQueue() {
    return null;
  }

  @Override
  public AbstractUIButton addAction(@NotNull ClickAction<?> action) {
    return null;
  }
}
