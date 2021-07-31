package com.maxwainer.ui.api.utils;

@FunctionalInterface
public interface TriConsumer<A, B, C> {

  /**
   * Use it to accept any 3 parameters
   *
   * @param a First consumer parameter
   * @param b Second consumer parameter
   * @param c Third consumer parameter
   */
  void accept(A a, B b, C c);
}
