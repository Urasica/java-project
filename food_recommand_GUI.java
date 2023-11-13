import javax.swing.*;
import java.awt.*;

public class food_recommand_GUI extends JFrame {
    static CardLayout cardLayout;
    static Container c;
    food_recommand_GUI() {
        super("음식메뉴추천");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c = getContentPane();

        cardLayout = new CardLayout();
        c.setLayout(cardLayout);
        JPanel start = new startPanel();
        JPanel selectKind = new selectKindPanel();

        c.add(start);
        c.add(selectKind);

        setSize(400, 600);
        setVisible(true);
    }


    public static void main(String[] args){
            new food_recommand_GUI();
    }
}