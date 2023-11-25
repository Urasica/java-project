import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 음식의 종류를 선택하는 화면을 나타낸 클래스
public class selectKindPanel extends JPanel {
    selectKindPanel() {
        setLayout(new BorderLayout());
        FoodList food = new FoodList();
        
        // selectKindPanel 패널 중앙에 배치할 패널 생성
        JPanel kindCenter = new JPanel(new GridLayout(5, 2, 20, 20));
        kindCenter.setBackground(new Color(218, 227, 244));
        // selectKindPanel 패널 하단에 배치할 패널 생성
        JPanel kindSouth = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 50));
        kindSouth.setBackground(new Color(140, 146, 189));

        // 8개의 JButton 생성
        JButton[] foodKind = new JButton[8];
        foodKind[0] = new JButton("한식");
        kindCenter.add(foodKind[0]);
        foodKind[1] = new JButton("중식");
        kindCenter.add(foodKind[1]);
        foodKind[2] = new JButton("일식");
        kindCenter.add(foodKind[2]);
        foodKind[3] = new JButton("양식");
        kindCenter.add(foodKind[3]);
        foodKind[4] = new JButton("분식");
        kindCenter.add(foodKind[4]);
        foodKind[5] = new JButton("패스트푸드");
        kindCenter.add(foodKind[5]);
        foodKind[6] = new JButton("아시안");
        kindCenter.add(foodKind[6]);
        foodKind[7] = new JButton("디저트");
        kindCenter.add(foodKind[7]);
        
        for (JButton jb : foodKind) {  // 각 버튼의 색 지정 및 클릭 시 이벤트 추가
            jb.setBackground(Color.lightGray);
            jb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    clickSound.playSound("ButtonSoundEffect.wav", food_recommand_GUI.volume);
                    // 선택 된 것을 취소하는 경우
                    if(jb.getBackground() == Color.ORANGE){
                        jb.setBackground(Color.lightGray);
                       }
                    // 선택하지 않은 것을 선택하는 경우
                    else {
                        jb.setBackground(Color.ORANGE);
                       
                    }
                }
            });
        }
        // 중앙 패널 부착
        add(kindCenter, BorderLayout.CENTER);

        // 중앙과 하단을 분리할 경계선 생성
        JPanel kindSouthHORIZONTAL = new JPanel(new BorderLayout());
        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        kindSouthHORIZONTAL.add(separator, BorderLayout.CENTER);

        // 이전 또는 다음 화면으로 가게하는 버튼 생성
        JButton pre = new JButton("이전");
        pre.setBackground(Color.WHITE);
        JButton next = new JButton("다음");
        next.setBackground(Color.WHITE);

        // 이전, 다음 버튼에 클릭 시 이동하도록 이벤트 추가
        pre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickSound.playSound("ButtonSoundEffect.wav", food_recommand_GUI.volume);
                if(FoodList.selectedFood.get(0)!=null) {//이전 버튼 눌렀을시 selectedFood에 값이 있을 경우 값 초기화
                	FoodList.selectedFood.clear();
                }
                food_recommand_GUI.cardLayout.previous(food_recommand_GUI.c);
                food_recommand_GUI.cardLayout.previous(food_recommand_GUI.c);
            }
        });
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickSound.playSound("ButtonSoundEffect.wav", food_recommand_GUI.volume);
                if(foodKind[0].getBackground() == Color.lightGray && //디저트일 경우
                        foodKind[1].getBackground() == Color.lightGray &&
                        foodKind[2].getBackground() == Color.lightGray &&
                        foodKind[3].getBackground() == Color.lightGray &&
                        foodKind[4].getBackground() == Color.lightGray &&
                        foodKind[5].getBackground() == Color.lightGray &&
                        foodKind[6].getBackground() == Color.lightGray &&
                        foodKind[7].getBackground() == Color.ORANGE){
                	 for(int i=0;i<food.dessertFood.length;i++) {
                		FoodList.selectedFood.add(food.dessertFood[i]);
                	 }
                    food_recommand_GUI.cardLayout.next(food_recommand_GUI.c);
                    food_recommand_GUI.cardLayout.next(food_recommand_GUI.c);
                }
                else {
                	String[] selectedKind=new String[10];
                	int index=0;
                	for(int i=0; i<foodKind.length;i++) { //배경색이 orange인 button의 text를 확인 후 List에 저장
                		if(foodKind[i].getBackground() ==Color.ORANGE) {
                			selectedKind[index]=foodKind[i].getText();
                			index++;
                		}
                	}
                	for(int k=0;k<selectedKind.length;k++) { //selectedFood List에 삽입
                		if(selectedKind[k]=="한식") {
                			for(int j=0;j<food.KoreanFood.length;j++) {
                				FoodList.selectedFood.add(food.KoreanFood[j]);
                			}
                		}
                		else if(selectedKind[k]=="일식") {
                			for(int j=0;j<food.JapaneseFood.length;j++) {
                				FoodList.selectedFood.add(food.JapaneseFood[j]);
                			}
                		}
                		else if(selectedKind[k]=="중식") {
                			for(int j=0;j<food.ChineseFood.length;j++) {
                				FoodList.selectedFood.add(food.ChineseFood[j]);
                			}
                		}
                		else if(selectedKind[k]=="양식") {
                			for(int j=0;j<food.WesternFood.length;j++) {
                				FoodList.selectedFood.add(food.WesternFood[j]);
                			}
                		}
                		else if(selectedKind[k]=="분식") {
                			for(int j=0;j<food.SnackFood.length;j++) {
                				FoodList.selectedFood.add(food.SnackFood[j]);
                			}
                		}
                		else if(selectedKind[k]=="패스트푸드") {
                			for(int j=0;j<food.fastFood.length;j++) {
                				FoodList.selectedFood.add(food.fastFood[j]);
                			}
                		}
                		else if(selectedKind[k]=="아시안") {
                			for(int j=0;j<food.AsianFood.length;j++) {
                				FoodList.selectedFood.add(food.AsianFood[j]);
                			}
                		}
                		else if(selectedKind[k]=="디저트") {
                			for(int j=0;j<food.dessertFood.length;j++) {
                				FoodList.selectedFood.add(food.dessertFood[j]);
                			}
                		}
                	}
                    food_recommand_GUI.cardLayout.next(food_recommand_GUI.c);
                }
            }
        });
        // 생성한 이전, 다음 버튼과 패널 부착
        kindSouth.add(pre);
        kindSouth.add(next);
        kindSouthHORIZONTAL.add(kindSouth, BorderLayout.SOUTH);
        add(kindSouthHORIZONTAL, BorderLayout.SOUTH);

        // 음식 설정 화면 동쪽에 자리 맞춤용 공백 추가, 색 입히기
        JPanel kindEAST = new JPanel();
        kindEAST.add(new JLabel("            "));
        kindEAST.setBackground(new Color(218, 227, 244));
        add(kindEAST, BorderLayout.EAST);
        
        // 음식 설정 화면 서쪽에 자리 맞춤용 공백 추가, 색 입히기
        JPanel kindWEST = new JPanel();
        kindWEST.add(new JLabel("            "));
        kindWEST.setBackground(new Color(218, 227, 244));
        add(kindWEST, BorderLayout.WEST);
        
        // 음식 설정 화면 상단에 자리 맞춤용 공백 추가, 색 입히기
        JPanel kindNORTH = new JPanel(new GridLayout(3, 1));
        kindNORTH.setBackground(new Color(218, 227, 244));
        kindNORTH.add(new JLabel(" "));
        kindNORTH.add(new JLabel(" "));
        add(kindNORTH, BorderLayout.NORTH);
    }
}
