package com.talent.domain;

public enum Level {
  H("High"),
  M("Midium"),
  L("Low");

  private final String label;

  Level(String label) {
    this.label = label;
  }

  public String label() {
    return label;
  }
}
