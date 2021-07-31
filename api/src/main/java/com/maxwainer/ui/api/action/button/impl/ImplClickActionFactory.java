package com.maxwainer.ui.api.action.button.impl;

import com.maxwainer.ui.api.action.button.ClickActionFactory;
import org.jetbrains.annotations.NotNull;

public class ImplClickActionFactory implements ClickActionFactory<AbstractClickAction> {

  @Override
  public @NotNull AbstractClickAction createAction() {
    return new AbstractClickAction() {
    };
  }
}
