package player;

/**
 * The players abilities.
 * {@link #STRENGTH} affects how effective the player is at striking their opponent.
 * {@link #CONSTITUTION} affects how much damage a player can take when they are hit in battle.
 * {@link #DEXTERITY} affects how effective the player is at avoiding a strike from their opponent.
 * {@link #CHARISMA} affects how their opponent views them.
 * */
public enum PlayerAbilities {
  STRENGTH,
  CONSTITUTION,
  DEXTERITY,
  CHARISMA;

  @Override
  public String toString() {
    switch (this) {
      case STRENGTH:
        return "Strength";
      case CONSTITUTION:
        return "Constitution";
      case DEXTERITY:
        return "Dexterity";
      case CHARISMA:
        return "Charisma";
      default:
        throw new IllegalArgumentException("Unexpected Argument");
    }
  }
}
