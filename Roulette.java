import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Roulette extends JFrame {
    private JLabel label1, label2, label3;
    private Timer timer;
    private List<String> options;
    private int currentIndex = 0;

    public Roulette() {
        setTitle("결제 정하기 룰렛");
        setSize(400, 300);

        JPanel roulettePanel = new JPanel(new GridLayout(5,1, 5, 5));
        roulettePanel.setOpaque(true);
        roulettePanel.setBackground(new Color(255,255,204));
        roulettePanel.add(new JLabel(""));
        label1 = new JLabel("");
        label1.setFont(new Font("굴림", Font.BOLD, 20));
        label1.setHorizontalAlignment(JLabel.CENTER);
        roulettePanel.add(label1);
        label2 = new JLabel("참여할 사람의 이름을 적어주세요");
        label2.setFont(new Font("굴림", Font.BOLD, 20));
        label2.setHorizontalAlignment(JLabel.CENTER);
        roulettePanel.add(label2);
        label3 = new JLabel("");
        label3.setFont(new Font("굴림", Font.BOLD, 20));
        label3.setHorizontalAlignment(JLabel.CENTER);
        roulettePanel.add(label3);
        add(roulettePanel, BorderLayout.CENTER);
        roulettePanel.add(new JLabel(""));

        JButton startButton = new JButton("시작");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 숫자 입력 다이얼로그 표시
                String input = JOptionPane.showInputDialog("사람의 수를 입력하고 엔터를 누르세요");
                try {
                    int numberOfOptions = Integer.parseInt(input);

                    // 문자열 입력 다이얼로그 표시
                    options = new ArrayList<>();
                    for (int i = 0; i < numberOfOptions; i++) {
                        String option = JOptionPane.showInputDialog((i + 1) + "번 쨰 인원의 이름" + ":");
                        options.add(option);
                    }
                    options.add("더치페이");

                    // 룰렛 초기화
                    currentIndex = 0;
                    updateLabel();

                    // 타이머 시작
                    timer.start();
                    
                    // 라벨에 색 입히기
                    label2.setOpaque(true);
                    label2.setBackground(new Color(255,189,90));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "잘못된 입력입니다. 숫자를 입력하세요");
                }
            }
        });

        JButton stopButton = new JButton("정지");
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 타이머 정지
                timer.stop();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        buttonPanel.setBackground(new Color(255,255,204));
        add(buttonPanel, BorderLayout.SOUTH);

        timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 룰렛 회전
                currentIndex = (currentIndex + 1) % options.size();
                updateLabel();
            }
        });

        setLocationRelativeTo(null);
    }

    private void updateLabel() {
        if (options != null && options.size() > 0) {
            label1.setText(options.get((currentIndex-1 + options.size()) % options.size()));
            label2.setText(options.get(currentIndex));
            label3.setText(options.get((currentIndex+1) % options.size()));
        } else {
            label2.setText("참여할 사람의 이름을 적어주세요");
        }

        // 레이블 위치 조정 (위에서 아래로 이동)
        int height = label2.getHeight();
        label2.setLocation(label2.getX(), (label2.getY() + 1) % (getHeight() - height));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Roulette().setVisible(true);
            }
        });
    }
}