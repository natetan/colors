import java.util.Scanner;

public class FavoriteColor {

	public static void main(String[] args) {
		ColorWheel wheel = new ColorWheel();
		Scanner console = new Scanner(System.in);
		giveIntro();
		prompt(wheel, console);
	}
	
	public static void giveIntro() {
		System.out.println("This class is all about some simple color interactions");
		System.out.println("There will be a list of colors to choose from");
		System.out.println("Users can do whatever they want");
		System.out.println();
	}
	
	public static void prompt(ColorWheel wheel, Scanner console) {
		String option1 = "1) Get the list of colors";
		String option2 = "2) Reverse the list of colors";
		String option3 = "3) Add a non-existing color to the list";
		String option4 = "4) Interact with the computer";
		System.out.println("What would you like to do?");
		System.out.printf("\n\t%s\n\t%s\n\t%s\n\t%s\n", option1, option2, option3, option4);
		int response = console.nextInt();
		if (response == 1) {
			System.out.println("Here's a lit of colors:");
			System.out.println(wheel.toString());
			System.out.println();
		} else if (response == 2) {
			wheel.reverse();
			System.out.println("List has been reversed");
			System.out.println();
		} else if (response == 3) {
			System.out.println("What color would you like to add?");
			System.out.print("Color to add: ");
			String color = console.next();
			if (wheel.exists(color)) {
				System.out.println(color + " already exists! Can't add it!");
				System.out.println();
			} else {
				wheel.add(color);
				System.out.println(color + " has been added!");
				System.out.println();
			}
		} else {
			interact(wheel, console);
		}
		prompt(wheel, console);
	}

	public static void interact(ColorWheel wheel, Scanner console) {
		System.out.println("What's your favorite color? ");
		System.out.println("Available Colors are " + wheel.toString());
		System.out.print("Favorite Color: ");
		String favColor = console.next();
		System.out.println();

		System.out.println("Searching the database for your color...");
		if (wheel.exists(favColor)) {
			System.out.println(favColor + " is a " + wheel.description(favColor) + " color!");
		} else {
			System.out.println(favColor + " does not exist.");
			System.out.print("Would you like to add " + favColor + " to the database? (y/n)? ");
			if (yes(console.next())) {
				wheel.add(favColor);
			}
		}
		System.out.print("Would you like to go again? (y/n)? ");
		if (yes(console.next())) {
			interact(wheel, console);
		}
	}

	private static boolean yes(String response) {
		response = response.toLowerCase().trim();
		return response.startsWith("y");
	}

}
