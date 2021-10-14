package gear;

import numbergenerator.GenerateRandomNumber;
import player.Player;
import player.PlayerAbilities;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Creates the Potions and Helps in getting how much it affects a player's ability.
 */
public class Potions extends AbstractGear {

//  Map<PotionTypes,Integer> potionTrack = new TreeMap<>();
  GenerateRandomNumber g = new GenerateRandomNumber(2);
  private final int potionUnit;
//  boolean flag = false;

  /**
   * Constructs potions with a map that keeps a track of
   * which and how many potions taken by a player.
   * */
  public Potions(String gearName) {
    super(gearName);
    int temp = g.getRandomNumber(2, 6);
    potionUnit = temp;
    gearCategory = GearCategory.POTION;
  }

  private void generatePotions() {
    GenerateRandomNumber g = new GenerateRandomNumber();
    int sum = 0;
    while (sum < 100) {
      int temp = g.getRandomNumber(2, 6);
      sum += temp;
    }
  }


  @Override
  public void mountGear(Player p) {
    generatePotions();
//    System.out.println(potionTrack);
//    for (Map.Entry<PotionTypes,Integer> b: potionTrack.entrySet()) {
//      p.setStrength(p.getStrength() + (b.getKey().getAffectStrength()));
//      p.setConstitution(p.getConstitution() + (b.getKey().getAffectConstitution()));
//      p.setCharisma(p.getCharisma() + (b.getKey().getAffectCharisma()));
//      p.setDexterity(p.getDexterity() + (b.getKey().getAffectDexterity()));
//    }
  }

  @Override
  public Map<PlayerAbilities, Integer> getAffectOnPlayerAbility() {
    temp.put(PlayerAbilities.CONSTITUTION, g.getRandomNumber(0,5));
    temp.put(PlayerAbilities.DEXTERITY, g.getRandomNumber(0,4));
    temp.put(PlayerAbilities.CHARISMA, g.getRandomNumber(2,6));
    temp.put(PlayerAbilities.STRENGTH, g.getRandomNumber(0,8));
    setFlag(true);
    return temp;
  }

  @Override
  public Map<PlayerAbilities, Integer> getAbilityMap() {
    if (getFlag()) {
      return temp;
    }
    else {
      Map<PlayerAbilities, Integer> x= new HashMap<>();
      x.put(PlayerAbilities.CONSTITUTION, g.getRandomNumber(0,5));
      x.put(PlayerAbilities.DEXTERITY, g.getRandomNumber(0,4));
      x.put(PlayerAbilities.CHARISMA, g.getRandomNumber(2,6));
      x.put(PlayerAbilities.STRENGTH, g.getRandomNumber(0,8));
      return x;
    }
  }

  @Override
  public GearCategory getGearCategory() {
    return gearCategory;
  }

  @Override
  public int getGearUnit() {
    return potionUnit;
  }

}
