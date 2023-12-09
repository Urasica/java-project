import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Roulette extends JFrame {
    private JLabel label;
    private Timer timer;
    private List<String> options;
    private int currentIndex = 0;

    public Roulette() {
        setTitle("결제 정하기 룰렛");
        setSize(400, 300);

        label = new JLabel("참여할 사람의 이름을 적어주세요");
        label.setFont(new Font("굴림", Font.BOLD, 20));
        label.setHorizontalAlignment(JLabel.CENTER);
        add(label, BorderLayout.CENTER);

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
        add(buttonPanel, BorderLayout.SOUTH);

        timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 룰렛 회전 로직
                currentIndex = (currentIndex + 1) % options.size();
                updateLabel();
            }
        });

        setLocationRelativeTo(null);
    }

    private void updateLabel() {
        if (options != null && options.size() > 0) {
            label.setText(options.get(currentIndex));
        } else {
            label.setText("참여할 사람의 이름을 적어주세요");
        }

        // 레이블 위치 조정 (위에서 아래로 이동)
        int height = label.getHeight();
        label.setLocation(label.getX(), (label.getY() + 1) % (getHeight() - height));
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
