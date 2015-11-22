/* Joshua Klein
 * 11/8/15
 * ENG EC504
 * Professor Moreshet
 * 
 * Project Back-End - IngredientsTable
 * 
 * This class provides the functionality for the ingredients table.
 * It handles inserts, deletes, and rank alterations. It also 
 * contains the priority queue-backed minimum heap which contains
 * all of the recipe nodes.
 * 
 */

import java.io.*;
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Comparator;
//Potential built-in maps/tables to use
// import java.util.Dictionary;
// import java.util.HashMap;
// import java.util.HashSet;
import java.util.Hashtable;
// import java.util.IdentityHashMap;
// import java.util.LinkedHashMap;
// import java.util.LinkedHashSet;
// import java.util.TreeMap;
// import java.util.WeakHashMap;

public class IngredientsTable {

	public Hashtable<String, IngredientNode> setOfIngredients;
	public PriorityQueue<RecipeNode> setOfRecipes; 

	//Constructor
	public IngredientsTable() {
		//Sets initial capacity and load factor for hash table, and initializes min heap
		setOfIngredients = new Hashtable<String, IngredientNode>(7919/*, 0.5*/);
		setOfRecipes = new PriorityQueue<RecipeNode>(1024, RecipeNode.c);
	}

	//Constructor with initial file; includes file handling
	public IngredientsTable(String fileName) {
		//Sets initial capacity and load factor for hash table, and initializes min heap
		setOfIngredients = new Hashtable<String, IngredientNode>(7919/*, 0.5*/);
		setOfRecipes = new PriorityQueue<RecipeNode>(1024, RecipeNode.c);

		//Checks for file
		try {
			Scanner input = new Scanner(System.in);
			File file = new File(fileName);
			input = new Scanner(file);

			

		} catch(FileNotFoundException e) {
			System.out.println("File not found!");
		}
	}

	//Inserts recipe into PQueue and associated ingredients into table
	//Assumes max table capacity not reached (set to 1024 for project)
	//Also assumes that recipe/ingredient nodes have been created already
	public void insertRecipe(RecipeNode r, ArrayList<IngredientNode> a) {
		//Adds recipe to PQueue
		setOfRecipes.add(r);

		//Adds recipe's ingredients to table
		for (IngredientNode i : a) {
			if (setOfIngredients.get(i.getName()) == null) setOfIngredients.put(i.getName(), i);
			else setOfIngredients.get(i.getName()).insertRecipe(r);
		}
	}

	//Once number of recipes reaches 1024, this function is used 
	public void insertDelRecipe(RecipeNode r, ArrayList<IngredientNode> a) {
		if (setOfRecipes.peek().getRank() < r.getRank()) {
			//Adds recipe to PQueue and removes head
			setOfRecipes.poll();
			setOfRecipes.add(r);

			//Adds recipe's ingredients to table
			for (IngredientNode i : a) {
				if (setOfIngredients.get(i.getName()) == null) setOfIngredients.put(i.getName(), i);
				else setOfIngredients.get(i.getName()).insertRecipe(r);
			}
		}
	}

	//Returns AL containing recipes that have specified ingredient
	public ArrayList<RecipeNode> getRecipes(String ingredientName) {
		return setOfIngredients.get(ingredientName).getRecipes();
	}
}