import java.util.ArrayList;
//used to get total price of all values in the cart
public class SumOfPrice {
	public static float get(ArrayList <Float> pr, int cou) {
	float total = 0;
	for(int i = 0; i < cou; i++)
	    total += pr.get(i);
	return total;
	}
}
