import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class moreFrame extends JFrame {

	public moreFrame() {
		JFrame newFrame = new JFrame("결과와 비슷한 메뉴들");
        newFrame.setSize(500, 400);
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel foodImage = new JLabel();
        foodImage.setBounds(75, 60, 250, 200);
        newFrame.add(foodImage);

        JLabel foodName = new JLabel();
        foodName.setBounds(175, 270, 300, 30);
        newFrame.add(foodName);

        int delay = 1000; //milliseconds
        Iterator<FoodList.NewFood> iterator = FoodList.selectedFood.iterator();
        ActionListener taskPerformer = new ActionListener() {
            
            public void actionPerformed(ActionEvent evt) {
                
            	Iterator<FoodList.NewFood> iter = iterator;
            
                if (iter.hasNext()) {
                    FoodList.NewFood food = iter.next(); // get the next food
                    ImageIcon foodImageSrc = new ImageIcon("image/" + food.GetName() + ".jpg");
                    Image image = foodImageSrc.getImage();
                    Image scaledImage = image.getScaledInstance(250, 200, Image.SCALE_SMOOTH);
                    ImageIcon scaledSettingIconIcon = new ImageIcon(scaledImage);
                    foodImage.setIcon(scaledSettingIconIcon);

                    foodName.setText(food.GetName());
                    newFrame.validate(); // to refresh the frame
                    newFrame.repaint();
                }
                else {
                    iter = FoodList.selectedFood.iterator(); // reset the iterator
                }
            }
        };
        Timer timer = new Timer(delay, taskPerformer);
        timer.start(); // 타이머 시작
        newFrame.setVisible(true);
    }
}
