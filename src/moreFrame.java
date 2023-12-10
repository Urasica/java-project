import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class moreFrame extends JFrame {
    private Timer timer;
    private Iterator<FoodList.NewFood> iterator; // iterator 변수 추가

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

        JLabel errMessage = new JLabel();
        errMessage.setBounds(0, 0, 100, 100);
        newFrame.add(errMessage);
        
        int delay = 1000; // milliseconds
        iterator = FoodList.selectedFood.iterator(); // iterator 초기화
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (FoodList.selectedFood.isEmpty()) { //목록이 비어있을 경우
                    System.out.println("목록이 비어있습니다");
                    errMessage.setText("목록이 비어있습니다");
                    return;
                }
                else {
                    if(iterator.hasNext()) {
	                    FoodList.NewFood food = iterator.next(); // get the next food
	                    if (food == null) {
	                    	iterator = FoodList.selectedFood.iterator();
	                        return;
	                    }
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
                    	iterator = FoodList.selectedFood.iterator();
                    }
                }
            }
        };
        timer = new Timer(delay, taskPerformer);
        timer.start();
        newFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
            	iterator = FoodList.selectedFood.iterator();
            	timer.stop();
            }
        });
        newFrame.setVisible(true);
    }
}
