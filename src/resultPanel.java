import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.Timer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class resultPanel extends JPanel {
    static JLabel titleLabel;
    //기호선택으로 넘어갈시 리스트를 초기화 하는 copiedList 생성
    static ArrayList<FoodList.NewFood> copiedList = new ArrayList<FoodList.NewFood>();


	resultPanel() {
        setLayout(null);
        setBackground(new Color(218, 227, 244));
        
        
        selectFavoritePanel.randomFood = FoodList.getRandomFood();
        if (selectFavoritePanel.randomFood == null) {
            FoodList.selectedFood.add(FoodList.KoreanFood[17]);
            selectFavoritePanel.randomFood = FoodList.selectedFood.get(0);
        }

        titleLabel = new JLabel("오늘의 추천 메뉴는...");

        revalidate();
        repaint();
        titleLabel.setBounds(145, 20, 300, 30);
        add(titleLabel);

        // Check if selectFavoritePanel.randomFood is not null before accessing its properties
        if (selectFavoritePanel.randomFood != null) {
            ImageIcon foodImageSrc = new ImageIcon("image/" + selectFavoritePanel.randomFood.GetName() + ".jpg");
            Image image = foodImageSrc.getImage();
            Image scaledImage = image.getScaledInstance(250, 200, Image.SCALE_SMOOTH);
            ImageIcon scaledSettingIconIcon = new ImageIcon(scaledImage);
            JLabel foodImage = new JLabel(scaledSettingIconIcon);
            foodImage.setBounds(75, 60, 250, 200);
            add(foodImage);

            JLabel foodName = new JLabel(selectFavoritePanel.randomFood.GetName());
            foodName.setBounds(175, 270, 300, 30);
            add(foodName);
        } else {
            // Handle the case when randomFood is null (e.g., display an error message)
            JLabel errorMessage = new JLabel("Error: No random food available.");
            errorMessage.setBounds(75, 60, 300, 30);
            add(errorMessage);
        }

        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setBounds(75, 310, 250, 2);
        add(separator);

        JButton retry = new JButton("처음으로");
        retry.setBounds(210, 430, 120, 30);
        retry.setBackground(Color.WHITE);
        retry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickSound.playSound("ButtonSoundEffect.wav", food_recommand_GUI.volume);
                food_recommand_GUI.cardLayout.next(food_recommand_GUI.c);
            }
        });
        add(retry);

        JButton pre = new JButton("기호선택으로");
        pre.setBounds(65, 430, 120, 30);
        pre.setBackground(Color.WHITE);
        pre.addActionListener(new ActionListener() {
            @SuppressWarnings("unchecked")
			@Override
            public void actionPerformed(ActionEvent e) {
                clickSound.playSound("ButtonSoundEffect.wav", food_recommand_GUI.volume);
                FoodList.selectedFood = (ArrayList<FoodList.NewFood>)resultPanel.copiedList.clone();
                food_recommand_GUI.cardLayout.previous(food_recommand_GUI.c);
                
            }
        });
        if(selectKindPanel.foodKind[7].getBackground()==Color.lightGray)//디저트가 선택됐을 경우 삽입금지
        	add(pre);

        JButton more = new JButton("더보기");
        more.setBounds(210, 330, 120, 30);
        more.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickSound.playSound("ButtonSoundEffect.wav", food_recommand_GUI.volume);
                moreFrame mf = new moreFrame();
            }
        });
        add(more);


}}