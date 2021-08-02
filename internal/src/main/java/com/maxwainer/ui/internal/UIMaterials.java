package com.maxwainer.ui.internal;

public enum UIMaterials {
  AIR((short) 0),
  STONE((short) 1);

  private final short id;

  UIMaterials(final short id) {
    this.id = id;
  }

  public short getId() {
    return id;
  }
}
