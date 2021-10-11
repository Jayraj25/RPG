package gear;

/**
 * The types of potions that can be used by the players in before battle.
 * */
public enum PotionTypes {
  P5(5,5,-1,-1,4),
  P6(6,3,5,-1,4),
  P3(3,2,0,3,-1),
  P2(2,-3,1,4,7),
  P4(4,-1,2,7,2);

  private final int value;
  private final int affectStrength;
  private final int affectConstitution;
  private final int affectDexterity;
  private final int affectCharisma;

  PotionTypes(int value, int affectStrength, int affectConstitution,
              int affectDexterity, int affectCharisma) {
    this.value = value;
    this.affectStrength = affectStrength;
    this.affectConstitution = affectConstitution;
    this.affectDexterity = affectDexterity;
    this.affectCharisma = affectCharisma;
  }

  public int getValue() {
    return value;
  }

  public int getAffectStrength() {
    return affectStrength;
  }

  public int getAffectConstitution() {
    return affectConstitution;
  }

  public int getAffectDexterity() {
    return affectDexterity;
  }

  public int getAffectCharisma() {
    return affectCharisma;
  }

  @Override
  public String toString() {
    switch (this) {
      case P6:
        return "P6";
      case P2:
        return "P2";
      case P3:
        return "P3";
      case P4:
        return "P4";
      case P5:
        return "P5";
      default:
        throw new IllegalArgumentException("Unexpected argument");
    }
  }
}
