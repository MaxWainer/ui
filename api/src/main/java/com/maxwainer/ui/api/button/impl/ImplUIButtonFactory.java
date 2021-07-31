package com.maxwainer.ui.api.button.impl;

import com.maxwainer.ui.api.button.UIButtonFactory;
import org.jetbrains.annotations.NotNull;

public class ImplUIButtonFactory implements UIButtonFactory<AbstractUIButton> {

  @Override
  public @NotNull AbstractUIButton createButton() {
    return new AbstractUIButton() {};
  }
}
