package catan;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class PlayerGameInitialization {
	public Map<BuildingType, Counter> buildingMap = new EnumMap<>(BuildingType.class);
	Player player;
	
	public PlayerGameInitialization(Player player) {
		this.player = player;	
		this.buildingMap.put(BuildingType.VILLAGE, new Counter(2));
		this.buildingMap.put(BuildingType.ROAD, new Counter(2));
	}
	
	public void addInitBuildings() {

		// Two roads & two villages at start
		player.addBuilding( Arrays.asList(
				new Building(BuildingType.VILLAGE, player, null),
				new Building(BuildingType.VILLAGE, player, null),
				new Building(BuildingType.ROAD, player, null),
				new Building(BuildingType.ROAD, player, null)
				));
	}
	
	/**
	 * @return how many more times it can be decremented
	 */
	public int decrement(BuildingType type) {
		Counter counter = buildingMap.get(type);
		counter.decrement();
		return counter.getCount();	
	}
	
	/**
	 * @return how many more times it can be incremented
	 */
	public int increment(BuildingType type) {
		Counter counter = buildingMap.get(type);
		counter.increment();
		return counter.getMax() - counter.getCount();
	}
	
	
	/**
	 * Keeps count from a start input. Increments and decrements by one
	 */
	static class Counter {
		int count;
		final int max;
		
		Counter(int start) {
			count = start;
			max = start;
		}

		public void decrement() {
			if (count <= 0) {
				throw new IllegalStateException("Count cannot be less than 0");
			}
			
			count--;
		}
		
		public void increment() {
			if (count > max) {
				throw new IllegalStateException("Count cannot be greater than " + max);
			}
			
			count++;
		}

		public int getCount() {
			return count;
		}

		public int getMax() {
			return max;
		}
		
	}
}