import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 음식의 기호를 선택하는 화면을 나타낸 클래스
public class selectFavoritePanel extends JPanel{
    selectFavoritePanel() {
        setLayout(new BorderLayout());

        // selectFavoritePanel 패널 중앙에 배치할 패널 생성
        JPanel favoriteCenter = new JPanel(new GridLayout(5, 2, 20, 20));
        favoriteCenter.setBackground(new Color(218, 227, 244));
        // selectFavoritePanel 패널 하단에 배치할 패널 생성
        JPanel favoriteSouth = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 50));
        favoriteSouth.setBackground(new Color(140, 146, 189));

        // 8개의 JButton 생성
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
        favoriteType[6] = new JButton("짠맛O");
        favoriteCenter.add(favoriteType[6]);
        favoriteType[7] = new JButton("짠맛X");
        favoriteCenter.add(favoriteType[7]);

        
        for (int i=0; i<favoriteType.length; i++) { // 각 버튼의 색 지정 및 클릭 시 이벤트 추가
            JButton jb = favoriteType[i];
            jb.setBackground(Color.lightGray);
            int seqence = i;
            jb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // 홀수번 째(OO맛X) 설정 버튼을 눌르면 앞의  짝수번 째(OO맛O)의 설정 취소하고 현재 설정으로 목록 갱신
                    if (seqence % 2 == 1 && favoriteType[seqence - 1].getBackground() == Color.ORANGE) {
                        favoriteType[seqence].setBackground(Color.ORANGE);
                        favoriteType[seqence - 1].setBackground(Color.lightGray);
                        //
                        //
                    }
                    // 짝수번 째(OO맛O) 설정 버튼을 눌르면 앞의 홀수번 째(OO맛X) 의 설정 취소하고 현재 설정으로 목록 갱신
                    else if (seqence % 2 == 0 && favoriteType[seqence + 1].getBackground() == Color.ORANGE) {
                        favoriteType[seqence].setBackground(Color.ORANGE);
                        favoriteType[seqence + 1].setBackground(Color.lightGray);
                        //
                        //
                    }
                }
            });
        }

        // 기본 설정을 모두 X로 설정 해두기
        for (int i=0; i<favoriteType.length; i++) {
            if(i%2==1) {
                favoriteType[i].setBackground(Color.ORANGE);
                //해당 설정의 리스트 불러오기
                //
                //
            }
        }

        // 중앙 패널 부착
        add(favoriteCenter, BorderLayout.CENTER);

        // 중앙과 하단을 분리할 경계선 생성
        JPanel favoriteSouthHORIZONTAL = new JPanel(new BorderLayout());
        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        favoriteSouthHORIZONTAL.add(separator, BorderLayout.CENTER);

        // 이전 또는 다음 화면으로 가게하는 버튼 생성
        JButton pre = new JButton("이전");
        pre.setBackground(Color.WHITE);
        JButton next = new JButton("다음");
        next.setBackground(Color.WHITE);

        // 이전, 다음 버튼에 클릭 시 이동하도록 이벤트 추가
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
        // 생성한 이전, 다음 버튼과 패널 부착
        favoriteSouth.add(pre);
        favoriteSouth.add(next);
        favoriteSouthHORIZONTAL.add(favoriteSouth, BorderLayout.SOUTH);
        add(favoriteSouthHORIZONTAL, BorderLayout.SOUTH);

        // 기호 설정 화면 동쪽에 자리 맞춤용 공백 추가, 색 입히기
        JPanel FavoriteEAST = new JPanel();
        FavoriteEAST.add(new JLabel("            "));
        FavoriteEAST.setBackground(new Color(218, 227, 244));
        add(FavoriteEAST, BorderLayout.EAST);
        // 기호 설정 화면 서쪽에 자리 맞춤용 공백 추가, 색 입히기
        JPanel FavoriteWEST = new JPanel();
        FavoriteWEST.add(new JLabel("            "));
        FavoriteWEST.setBackground(new Color(218, 227, 244));
        add(FavoriteWEST, BorderLayout.WEST);
        // 기호 설정 화면 상단에 자리 맞춤용 공백 추가, 색 입히기
        JPanel FavoriteNORTH = new JPanel(new GridLayout(3, 1));
        FavoriteNORTH.setBackground(new Color(218, 227, 244));
        FavoriteNORTH.add(new JLabel(" "));
        FavoriteNORTH.add(new JLabel(" "));
        add(FavoriteNORTH, BorderLayout.NORTH);
    }
}