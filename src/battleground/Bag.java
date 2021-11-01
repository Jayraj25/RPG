package battleground;

import gear.Gear;

import java.util.List;

/**
 * This is used to create a bag of equipments in which one fourth of gears decrease
 * at least one ability and player will pick equipments from it.
 */
public interface Bag {

  /**
   * Get the number of head gears to be created.
   * @return the number
   */
  int getNoOfHeadGears();

  /**
   * Get the number of footwear to be created.
   * @return the number
   */
  int getNoOfFootwear();

  /**
   * Get the number of belts to be created.
   * @return the number
   */
  int getNoOfBelts();

  /**
   * Get the number of potions to be created.
   * @return the number
   */
  int getNoOfPotions();

  /**
   * Creates bag of equipments with the given number of individual gears.
   */
  void generateEquipmentSet();

  /**
   * Get the bag of equipments in which 25% of gears decreases at least one ability of player.
   * @return list of gears.
   * */
  List<Gear> getEquipments();

  @Override
  String toString();
}
