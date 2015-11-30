/* Joshua Klein
 * 11/8/15
 * ENG EC504
 * Professor Moreshet
 * 
 * Project Back-End
 * 
 * This class provides the main function to test and run the back
 * end for the recipes web app.
 * 
 * 
 * 
 */

import java.util.*;

public class Driver {

	public static void main(String []args) {

		//For time testing
		double a, b;

		//Tests ingredients table

		a = System.nanoTime();
		IngredientsTable t = new IngredientsTable("MasterRecipeList.txt");
		b = System.nanoTime();

		System.out.println("Loading time: "+(b-a));
		//IngredientsTable t = new IngredientsTable();

		ArrayList<RecipeNode> r = new ArrayList<RecipeNode>();

		String str = "garlic";



		// System.out.println("\nWith initial set:");
		a = System.nanoTime();
		r = t.getRecipes(str);
		b = System.nanoTime();
		System.out.println("Getting time: "+(b-a));
		// System.out.println("\nRecipes with "+str+":");
		// for (RecipeNode rn : r) System.out.println(rn.getName());


		a = System.nanoTime();
		t.insertRecipesFromFile("AltRecipeList.txt");
		b = System.nanoTime();
		System.out.println("Inserting time: "+(b-a));


		// System.out.println("\nWith secondary set:");
		a = System.nanoTime();
		r = t.getRecipes(str);
		b = System.nanoTime();
		System.out.println("Getting time: "+(b-a));
		// System.out.println("\nRecipes with "+str+":");
		// for (RecipeNode rn : r) System.out.println(rn.getName());


	}
}