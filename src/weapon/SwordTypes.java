package weapon;

/**
 * Different types of swords.
 * {@link #KATANAS}
 * {@link #BROAD_SWORDS}
 * {@link #TWO_HANDED_SWORDS}
 * */
public enum SwordTypes {
  KATANAS,
  BROAD_SWORDS,
  TWO_HANDED_SWORDS;

  @Override
  public String toString() {
    switch (this) {
      case KATANAS:
        return "Katanas";
      case BROAD_SWORDS:
        return "Broad Swords";
      case TWO_HANDED_SWORDS:
        return "Two Handed Swords";
      default:
        throw  new IllegalArgumentException("Unexpected value: " + this);
    }
  }
}
