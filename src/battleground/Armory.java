package battleground;

import weapon.Weapon;
import weapon.WeaponFactory;
import weapon.WeaponTypes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A place from where a player will select one weapon randomly.
 * */
public class Armory {

  List<Weapon> armory = new ArrayList<>();
  WeaponFactory wf = new WeaponFactory();

  /**
   * Method that creates an armory which will be available to
   * players for choice of weapon before the battle starts.
   * */
  public List<Weapon> generateArmory() {

    for (int i = 0; i < 3; i++) {
      armory.add(wf.createWeapon(WeaponTypes.BARE_HANDS));
    }

    for (int i = 0; i < 5; i++) {
      armory.add(wf.createWeapon(WeaponTypes.KATANA));
    }

    for (int i = 0; i < 5; i++) {
      armory.add(wf.createWeapon(WeaponTypes.BROADSWORD));
    }

    for (int i = 0; i < 5; i++) {
      armory.add(wf.createWeapon(WeaponTypes.TWO_HANDED_SWORD));
    }

    for (int i = 0; i < 5; i++) {
      armory.add(wf.createWeapon(WeaponTypes.AXE));
    }

    for (int i = 0; i < 5; i++) {
      armory.add(wf.createWeapon(WeaponTypes.FLAIL));
    }

//    Collections.shuffle(armory);

    return armory;
  }
}
