import javax.swing.*;
import java.awt.*;

public class startPanel extends JPanel {
    public startPanel() {
        setLayout(new BorderLayout());
        JPanel startNorthPanel = new startNorthPanel();
        startNorthPanel.setBackground(new Color(218, 227, 244));
        add(startNorthPanel, BorderLayout.NORTH);
        JPanel startCenterPanel = new startCenterPanel();
        startCenterPanel.setBackground(new Color(218, 227, 244));
        add(startCenterPanel, BorderLayout.CENTER);
        JPanel startEastPanel = new startEastPanel();
        startEastPanel.setBackground(new Color(218, 227, 244));
        add(startEastPanel, BorderLayout.EAST);
        JPanel startWestPanel = new startWestPanel();
        startWestPanel.setBackground(new Color(218, 227, 244));
        add(startWestPanel, BorderLayout.WEST);
        JPanel startSouthPanel = new startSouthPanel();
        startSouthPanel.setBackground(new Color(218, 227, 244));
        add(startSouthPanel, BorderLayout.SOUTH);
    }
    static class startNorthPanel extends JPanel { // 시작화면 상단
        startNorthPanel() {
            setLayout(new BorderLayout());
            ImageIcon SettingIcon = new ImageIcon("src/image/setting.png");
            Image image = SettingIcon.getImage();

            // 이미지 크기를 조절
            Image scaledImage = image.getScaledInstance(30, 30, Image.SCALE_SMOOTH);

            // 크기를 조절한 이미지로 새로운 ImageIcon을 생성
            ImageIcon scaledSettingIconIcon = new ImageIcon(scaledImage);

            // JLabel에 크기를 조절한 이미지 아이콘을 추가
            JLabel SettingImage = new JLabel(scaledSettingIconIcon);
            SettingImage.setAlignmentX(Component.RIGHT_ALIGNMENT);
            add(SettingImage, BorderLayout.EAST);

        }
    }

    static class startCenterPanel extends JPanel { // 시작화면 중단
        startCenterPanel() {
            setLayout(new GridLayout(8,1));
            add(new JLabel(" "));
            JLabel title = new JLabel("음식메뉴추천");
            title.setFont(new Font("굴림", Font.BOLD, 40));
            title.setHorizontalAlignment(SwingConstants.CENTER);
            add(title);
            add(new JLabel("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ"));
            add(new JLabel(" "));
            JTextField textFieldName = new JPlaceholderTextField("닉네임을 입력하세요");
            textFieldName.setColumns(10);
            add(textFieldName);
            add(new JLabel(" "));
            add(new JButton("▶start!"));
        }
    }

    static class startEastPanel extends JPanel {
        startEastPanel() {
            add(new JLabel("                 "));
        }
    }

    static class startWestPanel extends JPanel {
        startWestPanel() {
            add(new JLabel("                 "));
        }
    }

    static class startSouthPanel extends JPanel {
        startSouthPanel() {
            setLayout(new GridLayout(10, 1));
            for(int i=0; i<10; i++){
                add(new JLabel(" "));
            }
        }
    }

}
