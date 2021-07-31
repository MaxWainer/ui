package com.maxwainer.ui.api;

import com.maxwainer.ui.api.button.impl.ImplUIButtonFactory;

public final class Buttons {

  public static final ImplUIButtonFactory DEFAULT_FACTORY = new ImplUIButtonFactory();

  private Buttons() {
    throw new UnsupportedOperationException();
  }

}
