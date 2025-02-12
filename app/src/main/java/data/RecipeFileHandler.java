package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class RecipeFileHandler {
    private String filePath;

    public RecipeFileHandler() {
        filePath = "app/src/main/resources/recipes.txt";
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //String recipeName = "Enter recipe name:";
        //String recipeName2 =reader.readLine();
        //String ingredients ="Enter main ingredients (comma separated):";
        //String ingredients2 = reader.readLine();
    }

    public RecipeFileHandler(String filePath) {
        this.filePath = filePath;
    }

    
    //設問1: 一覧表示機能
    
    
    
    //@return レシピデータ
    
    public ArrayList<String> readRecipes() {
        ArrayList<String> recipes = new ArrayList<>();//recipes.txtからレシピデータを読み込み、それをリスト形式で返します。
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {//レシピの中身を読み込む
            String line;//一行ずつ読むための変数line
            while((line = reader.readLine()) != null){//一行ずつ読む、読むものが無ければ(nullになったら)終わり
                recipes.add(line);//読んだ一行のレシピをリストに追加する
            }
        } catch (IOException e) {//もしファイルが開けなかったり、読めなかったとき
            
            System.out.println("Error reading file: 例外のメッセージ" + e.getMessage());//IOExceptionが発生したときはError reading file: 例外のメッセージとコンソールに表示します。
        }
        return recipes;//一連の情報をrecipesに返す
    }

    /**
     * 設問2: 新規登録機能
     * 新しいレシピをrecipes.txtに追加します。<br>
     * レシピ名と材料はカンマ区切りで1行としてファイルに書き込まれます。
     *
     * @param recipeName レシピ名
     * @param ingredients 材料名
     */
     // 
    public void addRecipe(String recipeName, String ingredients) {
        //新しいレシピをrecipes.txtに追加します。
        //レシピ名と材料はカンマ区切りで1行としてファイルに書き込まれます。

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true))){//ファイルへの書き込み
            writer.write(recipeName + "," + ingredients);//ライターにrecipeNameとingredientsにある文字列を書く指示とレシピ名と材料をカンマ区切りで書き込み
            writer.newLine();//書き込み後に改行する
            System.out.println("Recipe added successfully.");//書き込み後の出力
        //IOExceptionが発生したときはError reading file: 例外のメッセージとコンソールに表示します。
        } catch (IOException e) {
                System.out.println("Error reading file:");
        }
    }
}
