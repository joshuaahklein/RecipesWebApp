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
		//IngredientsTable t = new IngredientsTable("10RecipeList.txt");
		IngredientsTable t = new IngredientsTable();
		ArrayList<IngredientNode> a = new ArrayList<IngredientNode>();

		IngredientNode i1 = new IngredientNode("a");
		IngredientNode i2 = new IngredientNode("b");
		IngredientNode i3 = new IngredientNode("c");
		IngredientNode i4 = new IngredientNode("d");
		IngredientNode i5 = new IngredientNode("e");
		IngredientNode i6 = new IngredientNode("f");
		IngredientNode i7 = new IngredientNode("g");
		IngredientNode i8 = new IngredientNode("h");
		IngredientNode i9 = new IngredientNode("i");

		RecipeNode r1 = new RecipeNode("R1", 1, "Contains a b c");
		RecipeNode r2 = new RecipeNode("R2", 7, "Contains g f c");
		RecipeNode r3 = new RecipeNode("R3", 4, "Contains a d h c");
		RecipeNode r4 = new RecipeNode("R4", 2, "Contains i b e");
		RecipeNode r5 = new RecipeNode("R5", 6, "Contains d f i");

		//a
		i1.insertRecipe(r1);
		i1.insertRecipe(r3);
		//b
		i2.insertRecipe(r1);
		i2.insertRecipe(r4);
		//c
		i3.insertRecipe(r1);
		i3.insertRecipe(r2);
		i3.insertRecipe(r5);
		//d
		i4.insertRecipe(r3);
		i4.insertRecipe(r5);
		//e
		i5.insertRecipe(r4);
		//f
		i6.insertRecipe(r2);
		i6.insertRecipe(r5);
		//g
		i7.insertRecipe(r2);
		//h
		i8.insertRecipe(r3);
		//i
		i9.insertRecipe(r4);
		i9.insertRecipe(r5);

		//Table insert
		a.add(i1); a.add(i2); a.add(i3);
		t.insertRecipe(r1, a);

		a = new ArrayList<IngredientNode>();
		a.add(i7); a.add(i6); a.add(i3);
		t.insertRecipe(r2, a);

		a = new ArrayList<IngredientNode>();
		a.add(i1); a.add(i4); a.add(i8);
		t.insertRecipe(r3, a);

		a = new ArrayList<IngredientNode>();
		a.add(i9); a.add(i2); a.add(i5);
		t.insertRecipe(r4, a);

		a = new ArrayList<IngredientNode>();
		a.add(i4); a.add(i6); a.add(i9);
		t.insertRecipe(r5, a);

		//Checks getRecipes
		System.out.print("\nIngredient 1: ");
		for (int i = 0; i < t.getRecipes(i1.getName()).size(); i++) {
			System.out.print(t.getRecipes(i1.getName()).get(i).getName() + " ");
		}
		System.out.print("\nIngredient 2: ");
		for (int i = 0; i < t.getRecipes(i2.getName()).size(); i++) {
			System.out.print(t.getRecipes(i2.getName()).get(i).getName() + " ");
		}
		System.out.print("\nIngredient 3: ");
		for (int i = 0; i < t.getRecipes(i3.getName()).size(); i++) {
			System.out.print(t.getRecipes(i3.getName()).get(i).getName() + " ");
		}
		System.out.print("\nIngredient 4: ");
		for (int i = 0; i < t.getRecipes(i4.getName()).size(); i++) {
			System.out.print(t.getRecipes(i4.getName()).get(i).getName() + " ");
		}
		System.out.print("\nIngredient 5: ");
		for (int i = 0; i < t.getRecipes(i5.getName()).size(); i++) {
			System.out.print(t.getRecipes(i5.getName()).get(i).getName() + " ");
		}
		System.out.print("\nIngredient 6: ");
		for (int i = 0; i < t.getRecipes(i6.getName()).size(); i++) {
			System.out.print(t.getRecipes(i6.getName()).get(i).getName() + " ");
		}
		System.out.print("\nIngredient 7: ");
		for (int i = 0; i < t.getRecipes(i7.getName()).size(); i++) {
			System.out.print(t.getRecipes(i7.getName()).get(i).getName() + " ");
		}
		System.out.print("\nIngredient 8: ");
		for (int i = 0; i < t.getRecipes(i8.getName()).size(); i++) {
			System.out.print(t.getRecipes(i8.getName()).get(i).getName() + " ");
		}
		System.out.print("\nIngredient 9: ");
		for (int i = 0; i < t.getRecipes(i9.getName()).size(); i++) {
			System.out.print(t.getRecipes(i9.getName()).get(i).getName() + " ");
		}

		System.out.println("\nNow testing delete...");


	}
}