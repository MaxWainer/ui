package com.maxwainer.ui.api.action;

import com.maxwainer.ui.api.queue.Queable;
import com.maxwainer.ui.api.utils.Removeable;

public interface Action<T extends Action> extends Queable<T>, Removeable<T> {

}
