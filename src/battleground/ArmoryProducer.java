package battleground;

import weapon.Weapon;
import weapon.WeaponFactory;
import weapon.WeaponTypes;

import java.util.ArrayList;
import java.util.List;

/**
 * A place from where a player will select one weapon randomly.
 * */
public class ArmoryProducer implements Armory {

  private final List<Weapon> armory = new ArrayList<>();
  WeaponFactory wf = new WeaponFactory();
  private final int noOfKatana;
  private final int noOfBroadSword;
  private final int noOfTwoHandedSword;
  private final int noOfAxe;
  private final int noOfFlail;

  /**
   * Makes the armory with no of each type of weapon defined when creating class.
   * @param noOfKatana the number of katanas
   * @param noOfBroadSword the number of broad swords
   * @param noOfTwoHandedSword the number of two handed sword
   * @param noOfAxe the number of axes
   * @param noOfFlail the number of flails
   */
  public ArmoryProducer(
      int noOfKatana, int noOfBroadSword, int noOfTwoHandedSword, int noOfAxe, int noOfFlail) {
    if (noOfAxe < 1 || noOfBroadSword < 1 || noOfFlail < 1 || noOfKatana < 1
            || noOfTwoHandedSword < 1) {
      throw new IllegalArgumentException("There should be at least one weapon of each type.");
    }
    this.noOfKatana = noOfKatana;
    this.noOfBroadSword = noOfBroadSword;
    this.noOfTwoHandedSword = noOfTwoHandedSword;
    this.noOfAxe = noOfAxe;
    this.noOfFlail = noOfFlail;
  }

  @Override
  public List<Weapon> generateArmory() {

    for (int i = 0; i < 3; i++) {
      armory.add(wf.createWeapon(WeaponTypes.BARE_HANDS));
    }

    for (int i = 0; i < noOfKatana; i++) {
      armory.add(wf.createWeapon(WeaponTypes.KATANA));
    }

    for (int i = 0; i < noOfBroadSword; i++) {
      armory.add(wf.createWeapon(WeaponTypes.BROADSWORD));
    }

    for (int i = 0; i < noOfTwoHandedSword; i++) {
      armory.add(wf.createWeapon(WeaponTypes.TWO_HANDED_SWORD));
    }

    for (int i = 0; i < noOfAxe; i++) {
      armory.add(wf.createWeapon(WeaponTypes.AXE));
    }

    for (int i = 0; i < noOfFlail; i++) {
      armory.add(wf.createWeapon(WeaponTypes.FLAIL));
    }
    return armory;
  }

  @Override
  public String toString() {
    return "Armory created successfully";
  }
}
