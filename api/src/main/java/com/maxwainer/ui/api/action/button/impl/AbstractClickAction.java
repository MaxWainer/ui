package com.maxwainer.ui.api.action.button.impl;

import com.maxwainer.ui.api.action.button.ActionType;
import com.maxwainer.ui.api.handler.WrappedInventoryPacket;
import com.maxwainer.ui.api.action.button.ClickAction;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractClickAction implements ClickAction<AbstractClickAction> {

  @Override
  public <I extends WrappedInventoryPacket> AbstractClickAction click(
      @NotNull Consumer<I> consumer) {
    return null;
  }

  @Override
  public AbstractClickAction acceptTypes(@NotNull ActionType... types) {
    return null;
  }
}
