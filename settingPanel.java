import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.FloatControl;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class settingPanel extends JPanel {
    settingPanel() {
        setLayout(null);
        setBackground(new Color(218, 227, 244));

        JLabel title = new JLabel("설정");
        title.setSize(100, 100);
        title.setLocation(155, 10);
        title.setFont(new Font("굴림", Font.BOLD, 25));
        add(title);

        JLabel sound = new JLabel("효과음");
        sound.setSize(100, 100);
        sound.setLocation(75, 60);
        sound.setFont(new Font("굴림", Font.BOLD, 15));
        add(sound);

        JLabel bgSound = new JLabel("배경음악");
        bgSound.setSize(100, 100);
        bgSound.setLocation(235, 60);
        bgSound.setFont(new Font("굴림", Font.BOLD, 15));
        add(bgSound);
        
        
        
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

        JButton[] bgvolumesButton = new JButton[7];
        for (i = 0; i < 7; i++) {
            int seq = i;
            volumesButton[i] = new JButton();
            bgvolumesButton[i]= new JButton();
            double volume = 0.01 + increse * i;
            double bgvolume = 0.01 + increse * i*1.6;
            volumesButton[i].setSize(10,10*i);
            volumesButton[i].setLocation(65+15*i,250-10*i);
            volumesButton[i].setBackground(Color.BLACK);
            bgvolumesButton[i].setSize(10,10*i);
            bgvolumesButton[i].setLocation(205+15*i,250-10*i);
            bgvolumesButton[i].setBackground(Color.BLACK);
            
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
            
            bgvolumesButton[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                
                    backgroundMusic.setVolume(bgvolume);
                    for(int j=0; j<=seq; j++){
                        bgvolumesButton[j].setBackground(Color.BLACK);
                    }
                    for(int j=seq+1; j<7; j++){
                        bgvolumesButton[j].setBackground(Color.WHITE);
                    }
                }
            });
            add(bgvolumesButton[i]);
            add(volumesButton[i]);
        }
    }
}
