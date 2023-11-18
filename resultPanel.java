import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class resultPanel extends JPanel {
    resultPanel() {
        setLayout(new BorderLayout());

        JPanel resultCenterPanel = new JPanel();
        resultCenterPanel.setLayout(new GridLayout(3,1));
        add(resultCenterPanel, BorderLayout.CENTER);

        JLabel titleLabel = new JLabel("오늘의 추천 메뉴는...");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        resultCenterPanel.add(titleLabel);

        ImageIcon foodImageSrc = new ImageIcon("image/test.jpg");
        Image image = foodImageSrc.getImage();
        Image scaledImage = image.getScaledInstance(250, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledSettingIconIcon = new ImageIcon(scaledImage);
        JLabel foodImage = new JLabel(scaledSettingIconIcon);

        foodImage.setHorizontalAlignment(SwingConstants.CENTER);
        resultCenterPanel.add(foodImage);

        JLabel foodName = new JLabel("음식이름");
        foodName.setAlignmentX(Component.CENTER_ALIGNMENT);
        resultCenterPanel.add(foodName);

        JPanel resultSouthHORIZONTAL = new JPanel(new BorderLayout());
        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        resultSouthHORIZONTAL.add(separator, BorderLayout.CENTER);

        JButton retry = new JButton("처음으로");
        retry.setBackground(Color.WHITE);

        retry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                food_recommand_GUI.cardLayout.next(food_recommand_GUI.c);
            }
        });

        resultCenterPanel.setBackground(new Color(218, 227, 244));


        JPanel resultSouthPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 50));
        resultSouthPanel.add(retry);
        resultSouthHORIZONTAL.add(resultSouthPanel, BorderLayout.SOUTH);
        add(resultSouthHORIZONTAL, BorderLayout.SOUTH);

        resultCenterPanel.setBackground(new Color(218, 227, 244));
        resultSouthPanel.setBackground(new Color(218, 227, 244));

        JPanel resultEASTPanel = new JPanel();
        resultEASTPanel.add(new JLabel("                  "));
        resultEASTPanel.setBackground(new Color(218, 227, 244));
        add(resultEASTPanel, BorderLayout.EAST);

        JPanel resultWESTPanel = new JPanel();
        resultWESTPanel.add(new JLabel("                  "));
        resultWESTPanel.setBackground(new Color(218, 227, 244));
        add(resultWESTPanel, BorderLayout.WEST);

        JPanel resultNORTHPanel = new JPanel();
        resultNORTHPanel.setBackground(new Color(218, 227, 244));
        resultNORTHPanel.add(new JLabel(" "));
        add(resultNORTHPanel, BorderLayout.NORTH);
    }
}
