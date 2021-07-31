package com.maxwainer.ui.api.action.button;

import com.maxwainer.ui.api.action.Action;
import com.maxwainer.ui.api.handler.WrappedInventoryPacket;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;

public interface ClickAction<T extends ClickAction> extends Action<T> {

  <P extends WrappedInventoryPacket> T click(
      final @NotNull Consumer<P> consumer);

  T acceptTypes(@NotNull ActionType... types);

}
