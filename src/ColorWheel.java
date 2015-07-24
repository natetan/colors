import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ColorWheel {
	private List<String> list;
	
	public ColorWheel() {
		String[] colors = {
				"green",
				"blue",
				"red",
				"pink",
				"maroon",
				"magenta",
				"white",
				"black",
				"yellow",
				"grey",
				"aqua",
				"cyan",
				"brown",
				"burgundy",
				"mahogany"
		};
		this.list = new ArrayList<String>();
		for (String color : colors) {
			this.list.add(color);
		}
	}

	public String getColor() {
		Random r = new Random();
		return this.list.get(r.nextInt(this.list.size()));
	}

	public boolean exists(String color) {
		color = color.toLowerCase();
		for (int i = 0; i < this.list.size(); i++) {
			if (color.equals(this.list.get(i))) {
				return true;
			}
		}
		return false;
	}

	public String toString() {
		String output = "[" + this.list.get(0);
		for (int i = 1; i < this.list.size(); i++) {
			output += ", " + this.list.get(i);
		}
		return output + "]";
	}

	public void add(String color) {
		this.list.add(color);
	}
	
	public List reverse() {
		List<String> newList = new ArrayList<String>();
		for (int i = this.list.size(); i >= 0; i--) {
			newList.add(this.list.get(i));
		}
		return newList;
	}
}
