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
													"카이센동","미소라멘","돈코츠라멘","아부라소바","나가사키짬뽕",
													 };
	
	private String[] SnackFoodName = new String[] {"떡볶이","김밥","순대","떡꼬치","어묵","라면","쫄면","라볶이"};
	
	
	
	private String[] WesternFoodName = new String[]{"토마토파스타","크림파스타","오일파스타","로제파스타",
													"뇨끼","샌드위치","칼초네","오믈렛","바베큐폭찹",
													"쉬림프카나페","크림리조또","로제리조또","바게트","스테이크",
													"비프스튜"};
	
	private String[] ChineseFoodName = new String[]{"동파육","샤오롱바오","탕수육","깐풍기","마파두부",
													"양장피","짜장면","새우볶음밥","마라롱샤","유산슬",
													"마라탕","마라샹궈","꿔바로우","양꼬치","훠궈"};
	
	private String[] AsianFoodName = new String[]{"카레","탄두리치킨","나시고렝","미고렝",
												  "쌀국수","월남쌈","분짜","짜조","반미",
												  "쏨땀","팟타이","똠얌꿍","카야토스트"};
	
	private String[] dessertFoodName = new String[]{"탕후루","팥빙수","젤라또","수플레팬케이크","에그타르트",
													"푸딩","까눌레","카스테라","마카롱","요거트",
													"쿠키","휘낭시에","누룽지","마들렌","스콘"};
	
	private String[] fastFoodName = new String[] {"핫도그","컵밥","햄버거","브리또","피자","치킨"};
	
	
	
	static public String[] sweetFoodName = new String[] {"양념갈비","찜닭","고등어조림","제육볶음","고등어조림",
												   "돼지불고기","규동","떡볶이","김밥","떡꼬치",
												   "라볶이","토마토파스타","뇨끼","샌드위치","오믈렛",
												   "바베큐폭찹","탕수육","짜장면","꿔바로우","카레",
												   "나시고렝","분짜","반미","카야토스트","탕후루",
												   "팥빙수","젤라또","수플레팬케이크","에그타르트","푸딩",
												   "까눌레","카스테라","마카롱","요거트","쿠키",
												   "휘낭시에","마들렌","스콘","컵밥","치킨"};

	static public String[] spicyFoodName = new String[] {"김치찌개","닭갈비","비빔밥","고등어조림","제육볶음",
												   "육개장","비빔냉면","나가사키짬뽕","떡볶이","라면",
												   "쫄면","라볶이","깐풍기","마파두부","양장피",
												   "마라롱샤","마라탕","마라샹궈","훠궈","쏨땀",
												   "팟타이","똠얌꿍"};

	static public String[] oilyFoodName = new String[] {"삼겹살","생선구이","덴푸라","돈카츠","야키토리",
												  "모츠나베","텐동","돈코츠라멘","순대","크림파스타",
												  "오일파스타","칼초네","크림리조또","탕수육","짜장면",
												  "유산슬","양꼬치","미고렝","짜조","카야토스트","치킨","피자"};

	static public String[] saltyFoodName = new String[] {"양념갈비","찜닭","김치찌개","돼지국밥","육개장",
												   "칼국수","생선구이","돼지불고기","갈비탕","규동",
												   "오니기리","오코노미야키","부타동","텐동","돈코츠라멘",
												   "나가사키짬뽕","어묵","라면","로제파스타","뇨끼",
												   "오믈렛","로제리조또","비프스튜","동파육","깐풍기",
												   "마파두부","양장피","새우볶음밥","마라롱샤","유산슬",
												   "마라탕","마라샹궈","훠궈","카레","나시고렝",
												   "미고렝","쌀국수","팟타이","수플레팬케이크","에그타르트",
												   "쿠키","핫도그","컵밥","햄버거","브리또","치킨","피자"};
	
	static public String[] beTastyFoodName = new String[] { "돼지국밥","육개장","칼국수","물냉면","비빔냉면",
													  "갈비탕","야키토리","규동","야키니쿠","부타동",
													  "카이센동","미소라멘","아부라소바","나가사키짬뽕","김밥",
													  "쫄면","바베큐폭찹","스테이크","동파육","샤오롱바오",
													  "새우볶음밥","꿔바로우","양꼬치","탄두리치킨","쌀국수",
													  "월남쌈","분짜","쏨땀","똠얌꿍","컵밥","햄버거"};
	
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

    public void FoodNameFile(){ //음식이름을 txt파일에 넣기
        FoodName foodName = new FoodName();

        foodName.writeToFile(foodName.KoreanFoodName, "KoreanFood.txt");
        foodName.writeToFile(foodName.JapaneseFoodName, "JapaneseFood.txt");
        foodName.writeToFile(foodName.SnackFoodName, "SnackFood.txt");
        foodName.writeToFile(foodName.WesternFoodName, "WesternFood.txt");
        foodName.writeToFile(foodName.ChineseFoodName, "ChineseFood.txt");
        foodName.writeToFile(foodName.AsianFoodName, "AsianFood.txt");
        foodName.writeToFile(foodName.dessertFoodName, "dessertFood.txt");
        foodName.writeToFile(foodName.fastFoodName, "fastFood.txt");
        
        
        
        foodName.writeToFile(sweetFoodName, "sweetFood.txt");
        foodName.writeToFile(spicyFoodName, "spicyFood.txt");
        foodName.writeToFile(beTastyFoodName, "beTastyFood.txt");
        foodName.writeToFile(oilyFoodName, "oilyFood.txt");
        foodName.writeToFile(saltyFoodName, "saltyFood.txt");
        
    }
    
}
