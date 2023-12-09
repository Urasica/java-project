import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class resultPanel extends JPanel {
    static JLabel titleLabel;

    resultPanel() {
        setLayout(null);
        setBackground(new Color(218, 227, 244));

        selectFavoritePanel.randomFood = FoodList.getRandomFood();
        if (selectFavoritePanel.randomFood == null) {
            FoodList.selectedFood.add(FoodList.KoreanFood[17]);
            selectFavoritePanel.randomFood = FoodList.selectedFood.get(0);
        }

        if (startPanel.labelName.getText().isEmpty()) {
            String nickname = startPanel.textFieldName.getText().trim();
            if (!nickname.isEmpty()) {
                // resultPanel의 JLabel에 닉네임 출력
                resultPanel.titleLabel.setText(nickname + "님의 추천메뉴는...");
                revalidate();
                repaint();
            }
        } else {
            titleLabel = new JLabel("오늘의 추천 메뉴는...");
        }
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
            @Override
            public void actionPerformed(ActionEvent e) {
                clickSound.playSound("ButtonSoundEffect.wav", food_recommand_GUI.volume);
                food_recommand_GUI.cardLayout.previous(food_recommand_GUI.c);
            }
        });
        add(pre);

        JButton more = new JButton("더보기");
        more.setBounds(210, 330, 120, 30);
        more.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickSound.playSound("ButtonSoundEffect.wav", food_recommand_GUI.volume);
                //메뉴 띄워주기
                //
                //
            }
        });
        add(more);
    }
}
