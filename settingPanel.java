import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class settingPanel extends JPanel {
    settingPanel() {
        setLayout(null);
        setBackground(new Color(218, 227, 244));

        JLabel title = new JLabel("설정");
        title.setSize(100, 100);
        title.setLocation(165, 10);
        title.setFont(new Font("굴림", Font.BOLD, 25));
        add(title);

        JLabel sound = new JLabel("소리");
        sound.setSize(100, 100);
        sound.setLocation(175, 60);
        sound.setFont(new Font("굴림", Font.BOLD, 15));
        add(sound);

        JLabel exit = new JLabel("x");
        exit.setSize(40, 40);
        exit.setLocation(360, 0);
        exit.setFont(new Font("Serif", Font.BOLD, 40));
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickSound.playSound("ButtonSoundEffect.wav", food_recommand_GUI.volume);
                food_recommand_GUI.cardLayout.previous(food_recommand_GUI.c);
            }
        });
        add(exit);

        double increse = 0.1;
        int i;
        JButton[] volumesButton = new JButton[7];
        for (i = 0; i < 7; i++) {
            int seq = i;
            volumesButton[i] = new JButton();
            double volume = 0.01 + increse * i;
            volumesButton[i].setSize(10,10*i);
            volumesButton[i].setLocation(135+15*i,250-10*i);
            volumesButton[i].setBackground(Color.BLACK);
            volumesButton[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    clickSound.playSound("ButtonSoundEffect.wav", volume);
                    food_recommand_GUI.volume = volume;
                    for(int j=0; j<=seq; j++){
                        volumesButton[j].setBackground(Color.BLACK);
                    }
                    for(int j=seq+1; j<7; j++){
                        volumesButton[j].setBackground(Color.WHITE);
                    }
                }
            });
            add(volumesButton[i]);
        }
    }
}
