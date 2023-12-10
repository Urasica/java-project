
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FoodList extends FoodName {
	static NewFood[] KoreanFood= new NewFood[100];
	static NewFood[] JapaneseFood= new NewFood[100];
	static NewFood[] SnackFood= new NewFood[100];
	static NewFood[] WesternFood= new NewFood[100];
	static NewFood[] ChineseFood= new NewFood[100];
	static NewFood[] AsianFood= new NewFood[100];
	static NewFood[] dessertFood= new NewFood[100];
	static NewFood[] fastFood= new NewFood[100];
	static ArrayList<FoodList.NewFood> selectedFood = new ArrayList<NewFood>();
	
    public FoodList() { //텍스트 파일로 전부 만들기
        try {
        	FoodNameFile(); // 음식 이름을 파일에 넣기
        	String fileName[] = {"KoreanFood","JapaneseFood",
        						 "SnackFood","WesternFood",
        						 "ChineseFood","AsianFood",
        						 "dessertFood","fastFood"}; 
        
            for(int i=0;i<fileName.length;i++) { //파일경로 불러오기 및 파일에서 음식 이름 불러오기
            	String filePath = "./FoodNameFile/"+fileName[i]+".txt";
            	String[] foodNames = readFoodNamesFromFile(filePath);
            	int index=0;
            	 for(int k=0;foodNames[k]!=null;k++) { // foodNames의 각 요소들을 객체 배열에 저장
            		 
                     NewFood foodItem = new NewFood(foodNames[k]);
                     
                     if		(i==0) KoreanFood[index++] = foodItem;
                    
                     else if(i==1) JapaneseFood[index++] = foodItem;
                     
                     else if(i==2) SnackFood[index++] = foodItem;
                     
                     else if(i==3) WesternFood[index++] = foodItem;
                     
                     else if(i==4) ChineseFood[index++] = foodItem;
                     
                     else if(i==5) AsianFood[index++] = foodItem;
                     
                     else if(i==6) dessertFood[index++] = foodItem;  

                     else if(i==7) fastFood[index++] = foodItem;  
                 	}
            	 
            	 }

       	

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public static NewFood getRandomFood() {
		if (!selectedFood.isEmpty()) {
			int randomIndex = (int) (Math.random() * selectedFood.size());
			return selectedFood.get(randomIndex);
		} else {
			return null;
		}
	}

    // 파일에서 음식 이름을 읽어오는 메서드
    private String[] readFoodNamesFromFile(String filePath) throws IOException {
        String[] foodNames= new String[100];
        int count=0;
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = reader.readLine()) != null) { //각 줄을 읽어서 배열에 저장
                foodNames[count]=line;
                count++;
        }
        
        reader.close();
        return foodNames;
    }



	 class NewFood extends FoodName{
	    private String name ="비어있음";
	    private boolean sweet = false;
	    private boolean spicy = false;
	    private boolean oily = false;
	    private boolean salty = false;
	    private boolean beTasty = false;

	    //파일에서 목록을 읽어 boolean 형식으로 리턴하는 함수
	    public boolean setFavoriteFromFile(String filePath, NewFood food)throws IOException{
	    	BufferedReader reader = new BufferedReader(new FileReader(filePath));
	        String line;
	        while ((line = reader.readLine()) != null) {
	            // 각 줄에서 매치되는 부분을 찾아내어 리스트에 추가
	            if (food.name.equals(line)) {
	                return true;
	            }
	        }
	        reader.close();

	        return false;
	    }

	    private NewFood setFavorite(NewFood food) throws IOException {
	    	String fileName[] = {"./FoodNameFile/sweetFood.txt","./FoodNameFile/spicyFood.txt",
					 "./FoodNameFile/oilyFood.txt","./FoodNameFile/saltyFood.txt","./FoodNameFile/beTastyFood.txt"
					 };

	    	for(int i=0;i<fileName.length;i++) {
	    		boolean check= setFavoriteFromFile(fileName[i],food);

	    			if(check==true&&i==0) food.sweet = true;  //sweet음식에 해당 음식이 있을 경우 return true

	    			else if(check==true&&i==1) food.spicy= true;  //spicy음식에 해당 음식이 있을 경우 return true

	    			else if(check==true&&i==2) food.oily = true;  //oily음식에 해당 음식이 있을 경우 return true

	    			else if(check==true&&i==3)food.salty = true;   //salty음식에 해당 음식이 있을 경우 return true

	    			else if(check==true&&i==4) food.beTasty = true;  //beTasty음식에 해당 음식이 있을 경우 return true

	    	}
	    	return food;
	    }


		public NewFood(String name) throws IOException { //매개 변수를 받는 생성자 NewFood 객체 생성
	        this.name = name;
	        setFavorite(this);
	    }	

		public String GetName() {
			return this.name;
		}
		public boolean GetSweet() {
			return this.sweet;
		}
		public boolean GetSpicy() {
			return this.spicy;
		}
		public boolean Getoily() {
			return this.oily;
		}
		public boolean GetSalty() {
			return this.salty;
		}
		public boolean GetBeTasty() {
			return this.beTasty;
		}
	}
}