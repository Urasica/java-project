import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class selectFavoritePanel extends JPanel{
    selectFavoritePanel() {
        setLayout(new BorderLayout());

        JPanel favoriteCenter = new JPanel(new GridLayout(5, 2, 20, 20));
        favoriteCenter.setBackground(new Color(218, 227, 244));
        JPanel favoriteSouth = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 50));
        favoriteSouth.setBackground(new Color(140, 146, 189));

        JButton[] favoriteType = new JButton[8];
        favoriteType[0] = new JButton("매운맛O");
        favoriteCenter.add(favoriteType[0]);
        favoriteType[1] = new JButton("매운맛X");
        favoriteCenter.add(favoriteType[1]);
        favoriteType[2] = new JButton("단맛O");
        favoriteCenter.add(favoriteType[2]);
        favoriteType[3] = new JButton("단맛X");
        favoriteCenter.add(favoriteType[3]);
        favoriteType[4] = new JButton("느끼한맛O");
        favoriteCenter.add(favoriteType[4]);
        favoriteType[5] = new JButton("느끼한맛X");
        favoriteCenter.add(favoriteType[5]);
        favoriteType[6] = new JButton("");
        favoriteCenter.add(favoriteType[6]);
        favoriteType[7] = new JButton("");
        favoriteCenter.add(favoriteType[7]);

        
        for (int i=0; i<favoriteType.length; i++) {
            JButton jb = favoriteType[i];
            jb.setBackground(Color.lightGray);
            int seqence = i;
            jb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(jb.getBackground() == Color.ORANGE){
                        jb.setBackground(Color.lightGray);
                    } else {
                        String favoType = jb.getText();
                        jb.setBackground(Color.ORANGE);
                    }
                    if (seqence % 2 == 1 && favoriteType[seqence - 1].getBackground() == Color.ORANGE) {
                        favoriteType[seqence - 1].setBackground(Color.lightGray);
                    } else if (seqence % 2 == 0 && favoriteType[seqence + 1].getBackground() == Color.ORANGE) {
                        favoriteType[seqence + 1].setBackground(Color.lightGray);
                    }
                }
            });
        }

        add(favoriteCenter, BorderLayout.CENTER);

        JPanel favoriteSouthHORIZONTAL = new JPanel(new BorderLayout());
        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        favoriteSouthHORIZONTAL.add(separator, BorderLayout.CENTER);

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

        favoriteSouth.add(pre);
        favoriteSouth.add(next);
        favoriteSouthHORIZONTAL.add(favoriteSouth, BorderLayout.SOUTH);
        add(favoriteSouthHORIZONTAL, BorderLayout.SOUTH);

        JPanel FavoriteEAST = new JPanel();
        FavoriteEAST.add(new JLabel("            "));
        FavoriteEAST.setBackground(new Color(218, 227, 244));
        add(FavoriteEAST, BorderLayout.EAST);
        JPanel FavoriteWEST = new JPanel();
        FavoriteWEST.add(new JLabel("            "));
        FavoriteWEST.setBackground(new Color(218, 227, 244));
        add(FavoriteWEST, BorderLayout.WEST);
        JPanel FavoriteNORTH = new JPanel(new GridLayout(3, 1));
        FavoriteNORTH.setBackground(new Color(218, 227, 244));
        FavoriteNORTH.add(new JLabel(" "));
        FavoriteNORTH.add(new JLabel(" "));
        add(FavoriteNORTH, BorderLayout.NORTH);
    }
}
