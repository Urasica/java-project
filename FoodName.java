import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FoodName {

	
	
	private String[] KoreanFoodName = new String[]{"양념갈비","찜닭","김치찌개","닭갈비","삼겹살",
												   "돼지국밥","비빔밥","고등어조림","제육볶음","육개장",
												   "칼국수","생선구이","돼지불고기","물냉면","비빔냉면",
												   "갈비탕"};
	
	private String[] JapaneseFoodName = new String[]{"덴푸라","돈카츠","야키토리","규동","모츠나베",
													"오니기리","오코노미야키","야키니쿠","부타동","텐동",
													"카이센동","미소라멘","돈코츠라멘","아부라소바","사시미",
													 };
	
	private String[] SnackFoodName = new String[] {"로제떡볶이","김밥","순대","떡꼬치","어묵","라면","쫄면","라볶이"};
	
	
	
	private String[] WesternFoodName = new String[]{"토마토파스타","크림파스타","오일파스타","로제파스타","알리오올리오",
													"뇨끼","샌드위치","칼초네","오믈렛","바베큐폭찹",
													"쉬림프카나페","크림리조또","로제리조또","바게트","스테이크",
													"비프스튜"};
	
	private String[] ChineseFoodName = new String[]{"동파육","샤오롱바오","탕수육","깐풍기","마파두부",
													"양장피","짜장면","새우볶음밥","마라롱샤","유산슬",
													"마라탕","마라샹궈","꿔바로우","양꼬치","훠궈"};
	
	private String[] AsianFoodListName = new String[]{"난","카레","탄두리치킨","나시고렝","미고렝",
												  "쌀국수","월남쌈","분짜","짜조","반미",
												  "쏨땀","팟타이","똠얌꿍","카야토스트"};
	
	private String[] dessertFoodName = new String[]{"탕후루","팥빙수","젤라또","수플레팬케이크","에그타르트",
													"푸딩","까눌레","카스테라","마카롱","요거트",
													"쿠키","휘낭시에","누룽지","마들렌","스콘"};
	

	
    public void writeToFile(String[] array, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("./FoodNameFile/"+fileName))) {
            for (String item : array) {
                writer.write(item);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void FoodNameFile(){
        FoodName foodName = new FoodName();

        foodName.writeToFile(foodName.KoreanFoodName, "KoreanFood.txt");
        foodName.writeToFile(foodName.JapaneseFoodName, "JapaneseFood.txt");
        foodName.writeToFile(foodName.SnackFoodName, "SnackFood.txt");
        foodName.writeToFile(foodName.WesternFoodName, "WesternFood.txt");
        foodName.writeToFile(foodName.ChineseFoodName, "ChineseFood.txt");
        foodName.writeToFile(foodName.AsianFoodListName, "AsianFood.txt");
        foodName.writeToFile(foodName.dessertFoodName, "Dessert.txt");
    }
}
