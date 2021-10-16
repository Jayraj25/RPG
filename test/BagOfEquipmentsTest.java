import org.junit.Test;

import battleground.BagOfEquipments;

import static org.junit.Assert.assertEquals;

public class BagOfEquipmentsTest {

  BagOfEquipments bag;

  @Test (expected = IllegalArgumentException.class)
  public void testMinHeadGearLessThan5() {
    new BagOfEquipments(2,5,5,5);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testMinFootwearLessThan5() {
    new BagOfEquipments(7,3,5,5);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testMinBeltsLessThan15() {
    new BagOfEquipments(6,8,5,5);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testMinPotionsLessThan15() {
    new BagOfEquipments(6,8,25,5);
  }

  @Test
  public void getEquipments() {
  }

  @Test
  public void testToString() {
  }
}