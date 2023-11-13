import javax.swing.*;
import java.awt.*;

public class food_recommand_GUI extends JFrame {
    food_recommand_GUI() {
        super("음식메뉴추천");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();

        CardLayout cardLayout = new CardLayout();
        c.setLayout(cardLayout);
        JPanel start = new startPanel();
        start.setLayout(new BorderLayout());
        start.add(new startPanel.startNorthPanel(), BorderLayout.NORTH);
        start.add(new startPanel.startCenterPanel(), BorderLayout.CENTER);
        start.add(new startPanel.startEastPanel(), BorderLayout.EAST);
        start.add(new startPanel.startWestPanel(), BorderLayout.WEST);
        start.add(new startPanel.startSouthPanel(), BorderLayout.SOUTH);
        c.setBackground(Color.BLUE);
        c.add(start);

        setSize(400, 600);
        setVisible(true);
    }


    public static void main(String[] args){
            new food_recommand_GUI();
    }
}