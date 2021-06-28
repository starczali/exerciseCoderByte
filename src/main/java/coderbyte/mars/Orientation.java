package coderbyte.mars;

public enum Orientation {
  N("north"),
  S("south"),
  E("east"),
  W("west");

  private String name;

  Orientation(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
