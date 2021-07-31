package com.maxwainer.ui.api.action;

import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;

public interface ActionHolder<A extends Action, T extends ActionHolder> {

  @NotNull Queue<A> getActionsQueue();

  T addAction(
      final @NotNull A action);

  default @NotNull List<A> instantActions() {
    return getActionsQueue()
        .stream()
        .filter(it -> !it.isQueueable())
        .collect(Collectors.toList());
  }

}
