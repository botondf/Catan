package catan;

import java.util.EnumMap;
import java.util.Map;

public class PlayerGameInitialization {
	private Map<BuildingType, Counter> buildingMap = new EnumMap<>(BuildingType.class);
	
	public PlayerGameInitialization() {
		
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
