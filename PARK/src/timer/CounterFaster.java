package timer;

public class CounterFaster {
	private int value;

	public CounterFaster(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void increment() {
		value=value+10;
	}

	public void decrement() {
		value--;
	}

	protected void setValue(int value) {
		this.value = value;
	}
}
