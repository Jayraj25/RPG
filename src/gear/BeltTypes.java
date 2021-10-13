package gear;

/**
 * Enumeration for different types of belts.
 * {@link #SMALL}
 * {@link #MEDIUM}
 * {@link #LARGE}
 * */
public enum BeltTypes {
  SMALL(1),
  MEDIUM(2),
  LARGE(4);

  private final int value;

  BeltTypes(int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }

  @Override
  public String toString() {
    switch (this) {
      case SMALL:
        return "Small";
      case MEDIUM:
        return "Medium";
      case LARGE:
        return "Large";
      default:
        throw new IllegalArgumentException("Unexpected Argument");
    }
  }
}
