import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class selectKindPanel extends JPanel {
    selectKindPanel() {
        setLayout(new BorderLayout());

        JPanel kindCenter = new JPanel(new GridLayout(5, 2, 20, 20));
        kindCenter.setBackground(new Color(218, 227, 244));
        JPanel kindSouth = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 50));
        kindSouth.setBackground(new Color(140, 146, 189));

        JButton[] foodKind = new JButton[8];
        foodKind[0] = new JButton("한식");
        kindCenter.add(foodKind[0]);
        foodKind[1] = new JButton("중식");
        kindCenter.add(foodKind[1]);
        foodKind[2] = new JButton("일식");
        kindCenter.add(foodKind[2]);
        foodKind[3] = new JButton("양식");
        kindCenter.add(foodKind[3]);
        foodKind[4] = new JButton("분식");
        kindCenter.add(foodKind[4]);
        foodKind[5] = new JButton("디저트");
        kindCenter.add(foodKind[5]);
        foodKind[6] = new JButton("아시안");
        kindCenter.add(foodKind[6]);
        foodKind[7] = new JButton("디저트");
        kindCenter.add(foodKind[7]);

        for (JButton jb : foodKind) {
            jb.setBackground(Color.lightGray);
            jb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(jb.getBackground() == Color.ORANGE){
                        jb.setBackground(Color.lightGray);
                    } else {
                        String kind = jb.getText();
                        jb.setBackground(Color.ORANGE);
                    }
                }
            });
        }

        add(kindCenter, BorderLayout.CENTER);

        JPanel kindSouthHORIZONTAL = new JPanel(new BorderLayout());
        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        kindSouthHORIZONTAL.add(separator, BorderLayout.CENTER);

        JButton pre = new JButton("이전");
        pre.setBackground(Color.WHITE);
        JButton next = new JButton("다음");
        next.setBackground(Color.WHITE);

        pre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                food_recommand_GUI.cardLayout.previous(food_recommand_GUI.c);
            }
        });

        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                food_recommand_GUI.cardLayout.next(food_recommand_GUI.c);
            }
        });

        kindSouth.add(pre);
        kindSouth.add(next);
        kindSouthHORIZONTAL.add(kindSouth, BorderLayout.SOUTH);
        add(kindSouthHORIZONTAL, BorderLayout.SOUTH);

        JPanel kindEAST = new JPanel();
        kindEAST.add(new JLabel("            "));
        kindEAST.setBackground(new Color(218, 227, 244));
        add(kindEAST, BorderLayout.EAST);
        JPanel kindWEST = new JPanel();
        kindWEST.add(new JLabel("            "));
        kindWEST.setBackground(new Color(218, 227, 244));
        add(kindWEST, BorderLayout.WEST);
        JPanel kindNORTH = new JPanel(new GridLayout(3, 1));
        kindNORTH.setBackground(new Color(218, 227, 244));
        kindNORTH.add(new JLabel(" "));
        kindNORTH.add(new JLabel(" "));
        add(kindNORTH, BorderLayout.NORTH);
    }
}
