package catangame;

enum BuildingType {
	ROAD("Road", 0), VILLAGE("Village", 1), TOWN("Town", 2);

	private final int value;
	public final String label;

	BuildingType(final String newLabel, final int newValue) {
		label = newLabel;
		this.value = newValue;
	}

	public int getValue() {
		return value;
	}
}