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
		IngredientsTable t = new IngredientsTable("MasterRecipeList.txt");
		//IngredientsTable t = new IngredientsTable();

		ArrayList<RecipeNode> r = new ArrayList<RecipeNode>();

		String str = "garlic";

		System.out.println("With initial set:");
		r = t.getRecipes(str);
		System.out.println("\nRecipes with "+str+":");
		for (RecipeNode rn : r) System.out.println(rn.getName());

		t.insertRecipesFromFile("AltRecipeList.txt");

		System.out.println("With secondary set:");
		r = t.getRecipes(str);
		System.out.println("\nRecipes with "+str+":");
		for (RecipeNode rn : r) System.out.println(rn.getName());





	}
}