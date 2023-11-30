import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class resultPanel extends JPanel {
    static JLabel titleLabel;
    resultPanel() {
        setLayout(null);
        setBackground(new Color(218, 227, 244));

        titleLabel = new JLabel("오늘의 추천 메뉴는...");
        titleLabel.setBounds(145, 20, 300, 30);
        add(titleLabel);

        ImageIcon foodImageSrc = new ImageIcon("image/test.jpg");
        Image image = foodImageSrc.getImage();
        Image scaledImage = image.getScaledInstance(250, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledSettingIconIcon = new ImageIcon(scaledImage);
        JLabel foodImage = new JLabel(scaledSettingIconIcon);
        foodImage.setBounds(75, 60, 250, 200);
        add(foodImage);

        JLabel foodName = new JLabel("음식이름");
        foodName.setBounds(175, 270, 300, 30);
        add(foodName);

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
