package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import data.RecipeFileHandler;

public class RecipeUI {
    private BufferedReader reader;
    private RecipeFileHandler fileHandler;

    public RecipeUI(){
        reader = new BufferedReader(new InputStreamReader(System.in));
        fileHandler = new RecipeFileHandler();
    }

    public RecipeUI(BufferedReader reader, RecipeFileHandler fileHandler) {
        this.reader = reader;
        this.fileHandler = fileHandler;
    }

    public void displayMenu() {
        while (true) {
            try {
                System.out.println();
                System.out.println("Main Menu:");
                System.out.println("1: Display Recipes");
                System.out.println("2: Add New Recipe");
                System.out.println("3: Search Recipe");
                System.out.println("4: Exit Application");
                System.out.print("Please choose an option: ");

                String choice = reader.readLine();

                switch (choice) {
                    case "1":
                        // 設問1: 一覧表示機能
                        displayRecipes();
                        break;
                    case "2":
                        // 設問2: 新規登録機能
                        addNewRecipe();
                        break;
                    case "3":
                        // 設問3: 検索機能
                        break;
                    case "4":
                        System.out.println("Exit the application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select again.");
                        break;
                        
                }
                
            } catch (IOException e) {
                System.out.println("Error reading input from user: " + e.getMessage());
            }

        }
    }

    /**
     * 設問1: 一覧表示機能
     * RecipeFileHandlerから読み込んだレシピデータを整形してコンソールに表示します。
     */
    private void displayRecipes() {
        ArrayList<String>recipes = fileHandler.readRecipes();//レシピのデータを読み込む

        if(recipes.isEmpty()){//もしrecipesの中身が空っぽだったら
            System.out.println("No recipes available.");//この出力
        }else{//そうじゃなかったら
            System.out.println("\nRecipes");
            System.out.println("------------------------");
            for(String recipe : recipes){//レシピのリストから一つずつ取り出して、recipeという名前で扱う
                String[] parts = recipe.split("," , 2);//取り出したレシピの文章をカンマで区切る
                if(parts.length == 2){//もし取り出しリストが2つに分かれてたら
                    System.out.println("Recipe Name:" + parts[0]);
                    System.out.println("Main Ingredients:" + parts[1]);
                    System.out.println("--------------------------");
                }
            }
        }
    }
        
        
        

    /**
     * 設問2: 新規登録機能
     * ユーザーからレシピ名と主な材料を入力させ、RecipeFileHandlerを使用してrecipes.txtに新しいレシピを追加します。
     *
     * @throws java.io.IOException 入出力が受け付けられない
     */
    private void addNewRecipe() throws IOException {
        //	ユーザーからレシピ名と主な材料を入力させ
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));//文字入力の受付
        System.out.print("Enter recipe name:");//文字列の出力
        String recipeName = reader.readLine();//レシピ名の入力
        System.out.print("Enter main ingredients (comma separated):");//文字列の出力
        String ingredients = reader.readLine();//材料の入力

        //RecipeFileHandlerを使用して
        fileHandler.addRecipe(recipeName,ingredients);//addRecipeメソッドの呼び出し
        //recipes.txtに新しいレシピを追加します。
    }

    /**
     * 設問3: 検索機能
     * ユーザーから検索クエリを入力させ、そのクエリに基づいてレシピを検索し、一致するレシピをコンソールに表示します。
     *
     * @throws java.io.IOException 入出力が受け付けられない
     */
    private void searchRecipe() throws IOException {

    }

}

