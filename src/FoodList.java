import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class FoodList extends FoodName {
	NewFood[] KoreanFood= {};
	NewFood[] JapaneseFood= {};
	NewFood[] SnackFood= {};
	NewFood[] WesternFood= {};
	NewFood[] ChineseFood= {};
	NewFood[] AsianFood= {};
	NewFood[] dessertFood= {};
    public FoodList() {
        try {
            //
        	String fileName[] = {"KoreanFood","JapaneseFood",
        						 "SnackFood","WesternFood",
        						 "ChineseFood","AsianFood",
        						 "dessertFood"}; 
        
            for(int i=0;i<fileName.length;i++) {
            	String filePath = "./FoodNameFile/"+fileName[i]+".txt";
            	String[] foodNames = readFoodNamesFromFile(filePath);
            	
            	
            	 for (int k=0;k<foodNames.length;k++) { // foodNames의 각 요소들을 foodName변수로 할당 후 진행
                     NewFood foodItem = new NewFood(foodNames[k]);
                     
                 }}

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 파일에서 음식 이름을 읽어오는 메서드
    private String[] readFoodNamesFromFile(String filePath) throws IOException {
        String[] foodNames= {};
        int count=0;
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = reader.readLine()) != null) { //각 줄을 읽어서 저장
                foodNames[count]=line;
                count++;
        }
        
        reader.close();
        return foodNames;
    }
    
    
}

class NewFood extends FoodName{
    private String name;
    private boolean sweet;
    private boolean spicy;
    private boolean oily;
    private boolean salty;
    private boolean beTasty;
    
    //파일에서 목록을 읽어 boolean 형식으로 리턴하는 함수
    public boolean setKindFromFile(String filePath)throws IOException{
    	BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        
        while ((line = reader.readLine()) != null) {
            // 각 줄에서 매치되는 부분을 찾아내어 리스트에 추가
            if (this.name.equals(line)) {
                return true;
            }
            
        }
        reader.close();
        return false;
    }
    
    private NewFood setKind() throws IOException {
    	String fileName[] = {"./FoodNameFile/sweetFood.txt","./FoodNameFile/spicyFood.txt",
				 "./FoodNameFile/oilyFood.txt","./FoodNameFile/saltyFood.txt","./FoodNameFile/beTastyFood.txt"
				 }; 
    	
    	for(int i=0;i<fileName.length;i++) {
    		boolean check= setKindFromFile(fileName[i]);
    		
    			if(check==true&&i==0) this.sweet = true;  //sweet음식에 해당 음식이 있을 경우 return true
    			
    			else if(check==true&&i==1) this.spicy= true;  //spicy음식에 해당 음식이 있을 경우 return true
 
    			else if(check==true&&i==2) this.oily = true;  //oily음식에 해당 음식이 있을 경우 return true
    				 
    			else if(check==true&&i==3)this.salty = true;   //salty음식에 해당 음식이 있을 경우 return true
    				
    			else if(check==true&&i==4) this.beTasty = true;  //beTasty음식에 해당 음식이 있을 경우 return true
    				
    	}
    	return this;
    }
    

	public NewFood(String name) throws IOException { //매개 변수를 받는 생성자
        this.name = name;
        setKind();
    }
}
