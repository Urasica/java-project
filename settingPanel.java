import javax.swing.*;

public class settingPanel extends JPanel {
    settingPanel() {

    }

    class settingSouthPanel extends JPanel { // 시작화면 하단
        JButton[] volums = new JButton[6];
        settingSouthPanel() {
            for(int i=0;i<6;i++) {
                volums[i] = new JButton();
                volums[i].setSize(5,10);
                add(volums[i]);
            }
        }
    }
}
