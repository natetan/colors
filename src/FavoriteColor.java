
public class FavoriteColor {
	
	public static void main(String[] args) {
		ColorWheel cw = new ColorWheel();
		System.out.println("What's your favorite color? ");
		System.out.println("Available Colors are " + cw.toString());
		cw.add("orange");
		System.out.println(cw.toString());
		System.out.println(cw.reverse());
		
	}

}
