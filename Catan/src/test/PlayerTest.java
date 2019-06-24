import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

import catan.BuildingType;
import catan.Item;
import catan.ItemType;
import catan.Player;
//import catan.PlayerGameInitialization;

public class PlayerTest {

	@Test
	public void test_sufficientItems() {
		Player p1 = new Player(1);
//		PlayerGameInitialization gameInit = new PlayerGameInitialization(p1);
//		gameInit.addInitBuildings();
		
		List<Item> items = new ArrayList<>();
		items.addAll(Arrays.asList(
				new Item(ItemType.BRICK),
				new Item(ItemType.LUMBER),
				new Item(ItemType.BRICK),
				new Item(ItemType.BRICK)
				));
		
		p1.setItems(items);
		
		assertTrue(p1.sufficientItemsCheck(BuildingType.ROAD));
	}

}