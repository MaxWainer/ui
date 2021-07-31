package com.maxwainer.ui.api.button;

import java.util.List;
import org.jetbrains.annotations.NotNull;

public interface UIButtonHolder<T extends UIButtonHolder> {

  @NotNull List<UIButton<?>> getHoldingButtons();

  T addButton(@NotNull UIButton<?> button);

}
