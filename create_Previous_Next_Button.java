import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class create_Previous_Next_Button extends JButton {
    private CardLayout cardLayout;
    private JPanel addPanel; 

    public create_Previous_Next_Button(CardLayout cardLayout, JPanel addPanel) {
        this.cardLayout = cardLayout; //기준 카드레이아웃
        this.addPanel = addPanel; //부착할 패널

        JButton pre = new JButton("이전");
        JButton next = new JButton("다음");

        pre.addActionListener(new ClickedActionListener()); //버튼에 이벤트 장착
        next.addActionListener(new ClickedActionListener());
        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));//버튼 담을 패널 추가
        southPanel.add(pre);
        southPanel.add(next);
        addPanel.add(southPanel,BorderLayout.SOUTH);
    }

    private class ClickedActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton clicked = (JButton)e.getSource();
            if(clicked.getText().equals("이전")) {
                cardLayout.previous(addPanel);
            }
            else if(clicked.getText().equals("다음")) {
            	cardLayout.next(addPanel);
            	
            }
        }
    }
}
