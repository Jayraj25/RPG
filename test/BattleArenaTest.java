import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import battleground.ArmoryProducer;
import battleground.BattleArena;
import battleground.BattleModel;
import numbergenerator.GenerateRandomNumber;
import player.Player;
import player.PlayerGenerator;
import weapon.Weapon;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for operations carried during battle.
 */
public class BattleArenaTest {

  GenerateRandomNumber g = new GenerateRandomNumber(3);
  Player p1 = new PlayerGenerator("Jon Snow",g);
  Player p2 = new PlayerGenerator("Danaerys",g);
  BattleArena arena = new BattleModel(new BattleModel(p1,p2));

  @Before
  public void setUp() {
    p1.setProperties();
    p2.setProperties();
  }

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test (expected = IllegalArgumentException.class)
  public void testIllegalBattleCreation() {
    new BattleModel(p1, null);
    thrown.expectMessage("Null values not accepted");
  }

  @Test
  public void testBattleModelCreation() {
    assertEquals("Battle model created successfully.",new BattleModel(
            new BattleModel(p1,p2)).toString());
  }

  @Test (expected = IllegalStateException.class)
  public void testGetWinnerBeforeComputingHealth() {
    arena.getWinner();
    thrown.expectMessage("Compute the health of players");
  }

  @Test (expected = IllegalStateException.class)
  public void testGetWinnerBeforeGameOver() {
    p1.computeTotalHealth();
    p2.computeTotalHealth();
    arena.getWinner();
    thrown.expectMessage("Game still going on");
  }

  @Test
  public void testGetWinner() {
    arena.equipGears(p1);
    arena.equipGears(p2);
    p1.makeChangesInAbilities();
    p2.makeChangesInAbilities();
    ArmoryProducer a = new ArmoryProducer(new ArmoryProducer
            (4,6,4, 7,5));
    List<Weapon> armory = a.generateArmory();
    p1.equipWeapon(armory);
    p2.equipWeapon(armory);
    while (p1.getPlayerHealth() > 0 && p2.getPlayerHealth() > 0) {
      arena.makeMove();
      arena.getTurn();
    }
    assertEquals("Jon Snow",arena.getWinner().getPlayerName());
  }

  @Test
  public void testGetTurn() {
    arena.equipGears(p1);
    arena.equipGears(p2);
    p1.makeChangesInAbilities();
    p2.makeChangesInAbilities();
    ArmoryProducer a = new ArmoryProducer(new ArmoryProducer
            (4,6,4, 7,5));
    List<Weapon> armory = a.generateArmory();
    p1.equipWeapon(armory);
    p2.equipWeapon(armory);
    arena.makeMove();
    List<String> actual = arena.getTurn();
    List<String> expected = new ArrayList<>() {
      {
        add("Danaerys");add("Jon Snow");
      }
    };
    assertEquals(expected,actual);
  }

  @Test
  public void testIsGameOverBeforeAndDuringBattle() {
    arena.equipGears(p1);
    arena.equipGears(p2);
    p1.makeChangesInAbilities();
    p2.makeChangesInAbilities();
    ArmoryProducer a = new ArmoryProducer(new ArmoryProducer
            (4,6,4, 7,5));
    List<Weapon> armory = a.generateArmory();
    p1.equipWeapon(armory);
    p2.equipWeapon(armory);
    assertFalse(arena.isGameOver());
    arena.makeMove();
    arena.getTurn();
    assertFalse(arena.isGameOver());
  }

  @Test
  public void testIsGameOver() {
    arena.equipGears(p1);
    arena.equipGears(p2);
    p1.makeChangesInAbilities();
    p2.makeChangesInAbilities();
    ArmoryProducer a = new ArmoryProducer(new ArmoryProducer
            (4,6,4, 7,5));
    List<Weapon> armory = a.generateArmory();
    p1.equipWeapon(armory);
    p2.equipWeapon(armory);
    while (p1.getPlayerHealth() > 0 && p2.getPlayerHealth() > 0) {
      arena.makeMove();
      arena.getTurn();
    }
    assertTrue(arena.isGameOver());
  }

  @Test
  public void testMakeMove() {
    arena.equipGears(p1);
    arena.equipGears(p2);
    p1.makeChangesInAbilities();
    p2.makeChangesInAbilities();
    ArmoryProducer a = new ArmoryProducer(new ArmoryProducer
            (4,6,4, 7,5));
    List<Weapon> armory = a.generateArmory();
    p1.equipWeapon(armory);
    p2.equipWeapon(armory);
    List<String> actual = arena.makeMove();
    List<String> expected = new ArrayList<>() {
      {
        add("Jon Snow");add("Danaerys");add("78");
        add("25");add("Jon Snow");add("32");
      }
    };
    assertEquals(expected,actual);
  }

  @Test
  public void testGetTrackRounds() {
    arena.equipGears(p1);
    arena.equipGears(p2);
    p1.makeChangesInAbilities();
    p2.makeChangesInAbilities();
    ArmoryProducer a = new ArmoryProducer(new ArmoryProducer
            (4,6,4, 7,5));
    List<Weapon> armory = a.generateArmory();
    p1.equipWeapon(armory);
    p2.equipWeapon(armory);
    arena.makeMove();
    assertEquals(1,arena.getTrackRounds());
    arena.makeMove();
    assertEquals(2,arena.getTrackRounds());
  }
}