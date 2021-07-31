package com.maxwainer.ui.api;

import com.maxwainer.ui.api.action.button.impl.ImplClickActionFactory;

public final class ClickActions {

  public static final ImplClickActionFactory DEFAULT_FACTORY = new ImplClickActionFactory();

  private ClickActions() {
    throw new UnsupportedOperationException();
  }

}
