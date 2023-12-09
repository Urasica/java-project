import javax.swing.*;
import java.awt.*;

//음식 추천 프로그램의 UI를 관리하는 class
public class food_recommand_GUI extends JFrame {
    // 패널들을 담을 CardLayout과 Container
    static CardLayout cardLayout;
    static Container c;
    public static double volume;
    food_recommand_GUI() {
        super("음식메뉴추천");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        volume = 1.0;

        // CardLayout과 Container의 실제 객체 생성 및 지정
        c = getContentPane();
        cardLayout = new CardLayout();
        c.setLayout(cardLayout);

        // 각 화면에 해당하는 패널 생성
        JPanel start = new startPanel();
        JPanel setting = new settingPanel();
        JPanel selectKind = new selectKindPanel();
        JPanel selectFavorite = new selectFavoritePanel();

        // 생성한 패널들 부착
        c.add(start);
        c.add(setting);
        c.add(selectKind);
        c.add(selectFavorite);
        backgroundMusic.playSound("backgroundmusic.wav",volume); //배경음악 삽입

        setSize(400, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    public static void main(String[] args){
            new food_recommand_GUI();
    }
}