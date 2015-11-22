/* Joshua Klein
 * 11/8/15
 * ENG EC504
 * Professor Moreshet
 * 
 * Project Back-End - RecipeAppHandler
 * 
 * This class provides all the necessary functionality for the back end
 * of the recipe web app.  
 * 
 * It uses a priority queue-backed min heap to hold all of the recipes
 * and a table to hold all the ingredients, which in turn hold ranks
 * as well as references to recipes.  The table is implemented as a standard
 * hash table using java's built in hashtable with chaining, except to
 * optimize performance, each chain only ever contains the top 5 recipes
 * with that ingredient.  If a chain has 5 recipes, a recipe will be be 
 * deleted if a new recipe is being inserted only if that new recipe has a 
 * greater rank than one of the recipes in the chain list.
 * 
 */

import java.util.*;
import java.io.*;

public class RecipeAppHandler {

	//Hash tab;e of ingredient nodes where search is conducted via string
	public Hashtable<String, IngredientNode> ingredientsTable;
	public PriorityQueue<RecipeNode> masterRecipeList;

	//Constructor loads table with initial data set
	public RecipeAppHandler() {
		ingredientsTable = new Hashtable<String, IngredientNode>(4096);
		masterRecipeList = new PriorityQueue<RecipeNode>();
		try {
			//Retrieves file to read
			BufferedReader f = new BufferedReader(new FileReader("10RecipeList.txt"));

			//Reads file into new recipe nodes
			String line;
			int state = 0;
			RecipeNode r;
			while (line = f.readLine() != null) {
				switch(state) {
					case 0: if (line.length > 2) {
						r = new RecipeNode(line);
						state++;}
						break;
					case 1: if (line.contains("Ingredients")) {
						state++;}
						break;
					case 2: if (!line.contains("Directions")) {
						r.insertIngredient(line);
						} else state++;
						break;
					case 3: if (!line.contains("***************")) {
						r.addDirections(line+"\n");
						} else state++;
						break;
					default:
						masterRecipeList.add(r);
						r = null;
						state = 0;
						break;
				}
			}

		} catch(FileNotFoundException e) {
			System.out.println("Didn't find file.");
		}
	}

	//Inserts new recipes from file in local dir, deletes
	//least popular recipes currently in table
	public void insert(RecipeNode r) {

	}

	//Returns list of file names in local dir for the recipes of interest
	public ArrayList<RecipeNode> search5(IngredientNode in) {
		return null;
	}
}