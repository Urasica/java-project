import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class resultPanel extends JPanel {
    resultPanel() {
        setLayout(null);
        setBackground(new Color(218, 227, 244));

        JLabel titleLabel = new JLabel("오늘의 추천 메뉴는...");
        titleLabel.setBounds(145, 20, 300, 30); // Set bounds (x, y, width, height)
        add(titleLabel);

        ImageIcon foodImageSrc = new ImageIcon("image/test.jpg");
        Image image = foodImageSrc.getImage();
        Image scaledImage = image.getScaledInstance(250, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledSettingIconIcon = new ImageIcon(scaledImage);
        JLabel foodImage = new JLabel(scaledSettingIconIcon);
        foodImage.setBounds(75, 60, 250, 200); // Set bounds (x, y, width, height)
        add(foodImage);

        JLabel foodName = new JLabel("음식이름");
        foodName.setBounds(175, 270, 300, 30); // Set bounds (x, y, width, height
        add(foodName);

        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setBounds(75, 310, 250, 2); // Set bounds (x, y, width, height)
        add(separator);

        JButton retry = new JButton("처음으로");
        retry.setBounds(140, 430, 120, 30); // Set bounds (x, y, width, height)
        retry.setBackground(Color.WHITE);
        retry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                food_recommand_GUI.cardLayout.next(food_recommand_GUI.c);
            }
        });
        add(retry);

        JButton more = new JButton("더보기");
        more.setBounds(210, 330, 120, 30); // Set bounds (x, y, width, height)
        add(more);
    }
}
