import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// 시작화면을 나타낼 클래스
public class startPanel extends JPanel {
    public startPanel() {
        setLayout(new BorderLayout()); // BorderLayout으로 설정
        // startPanel의 상단 패널 생성, 색 설정 및 부착
        JPanel startNorthPanel = new startNorthPanel();
        startNorthPanel.setBackground(new Color(218, 227, 244));
        add(startNorthPanel, BorderLayout.NORTH);
        // startPanel의 중앙 패널 생성, 색 설정 및 부착
        JPanel startCenterPanel = new startCenterPanel();
        startCenterPanel.setBackground(new Color(218, 227, 244));
        add(startCenterPanel, BorderLayout.CENTER);
        // startPanel의 동쪽 패널 생성, 색 설정 및 부착
        JPanel startEastPanel = new startEastPanel();
        startEastPanel.setBackground(new Color(218, 227, 244));
        add(startEastPanel, BorderLayout.EAST);
        // startPanel의 상단 패널 생성, 색 설정 및 부착
        JPanel startWestPanel = new startWestPanel();
        startWestPanel.setBackground(new Color(218, 227, 244));
        add(startWestPanel, BorderLayout.WEST);
        // startPanel의 하단 패널 생성, 색 설정 및 부착
        JPanel startSouthPanel = new startSouthPanel();
        startSouthPanel.setBackground(new Color(218, 227, 244));
        add(startSouthPanel, BorderLayout.SOUTH);
    }
    static class startNorthPanel extends JPanel { // startPanel의 상단 패널
        startNorthPanel() {
            setLayout(new BorderLayout());
            ImageIcon SettingIcon = new ImageIcon("image/setting.png");
            Image image = SettingIcon.getImage();

            // 이미지 크기를 조절
            Image scaledImage = image.getScaledInstance(30, 30, Image.SCALE_SMOOTH);

            // 크기를 조절한 이미지로 새로운 ImageIcon을 생성
            ImageIcon scaledSettingIconIcon = new ImageIcon(scaledImage);

            // JLabel에 크기를 조절한 이미지 아이콘을 추가
            JLabel SettingImage = new JLabel(scaledSettingIconIcon);
            SettingImage.setAlignmentX(Component.RIGHT_ALIGNMENT);
            add(SettingImage, BorderLayout.EAST);

            // 이미지 누르면 설정 화면 나오게
            SettingImage.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    clickSound.playSound("ButtonSoundEffect.wav", food_recommand_GUI.volume);
                    food_recommand_GUI.cardLayout.next(food_recommand_GUI.c);
                }
            });
        }
    }

    static class startCenterPanel extends JPanel { // startPanel의 중앙 패널
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
            // JTextField에 텍스트 입력하여 엔터 누르면 유저명 입력 및 파일 입출력
            //
            //

            add(textFieldName);
            add(new JLabel(" "));
            JButton startButton = new JButton("▶start!");
            startButton.addActionListener(new ActionListener() { // 시작 버튼 누르면 다음 화면으로 이동
                @Override
                public void actionPerformed(ActionEvent e) {
                    clickSound.playSound("ButtonSoundEffect.wav", food_recommand_GUI.volume);
                    food_recommand_GUI.cardLayout.next(food_recommand_GUI.c);
                    food_recommand_GUI.cardLayout.next(food_recommand_GUI.c);
                }
            });
            add(startButton);
        }
    }

    static class startEastPanel extends JPanel { // startPanel의 동쪽 패널
        // 자리 맞춤용 공백
        startEastPanel() {
            add(new JLabel("                 "));
        }
    }

    static class startWestPanel extends JPanel { // startPanel의 서쪽 패널
        // 자리 맞춤용 공백
        startWestPanel() {
            add(new JLabel("                 "));
        }
    }

    static class startSouthPanel extends JPanel { // startPanel의 하단 패널
        startSouthPanel() {
            // 자리 맞춤용 공백
            setLayout(new GridLayout(10, 1));
            for(int i=0; i<10; i++){
                add(new JLabel(" "));
            }
        }
    }

}
