import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
        newFrame.setSize(470, 400);
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        Container contentPane = newFrame.getContentPane(); // 컨텐트 팬 가져오기
        contentPane.setLayout(null); // 레이아웃 매니저를 null로 설정

        JLabel foodImage = new JLabel();
        foodImage.setBounds(95, 60, 250, 200);
        contentPane.add(foodImage);

        JLabel foodName = new JLabel();
        foodName.setBounds(190, 270, 300, 30);
        Font nameFont = foodName.getFont();
        foodName.setFont(nameFont.deriveFont(16f));
        contentPane.add(foodName);

        JLabel errMessage = new JLabel("목록이 비어있습니다.");
        errMessage.setBounds(130, 150, 100, 100);
        
        
        JLabel infoMessage = new JLabel("멈추려면 마우스를 클릭하세요");
        infoMessage.setBounds(130, 10, 200, 30); // 원하는 위치와 크기로 설정
        Font infoFont = infoMessage.getFont();
        infoMessage.setFont(infoFont.deriveFont(16f));
        contentPane.add(infoMessage);
        
        int delay = 10; // milliseconds
        iterator = FoodList.selectedFood.iterator(); // iterator 초기화
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (FoodList.selectedFood.isEmpty()) { //목록이 비어있을 경우
                    System.out.println("목록이 비어있습니다");
                    contentPane.add(errMessage);
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
        newFrame.addWindowListener(new java.awt.event.WindowAdapter() { //프레임 닫을시 스레드 종료
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                iterator = FoodList.selectedFood.iterator();
                timer.stop();
            }
        });

        // 마우스 클릭 이벤트 리스너 추가
        newFrame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (timer != null && timer.isRunning()) {
                    timer.stop();
                }
            }
        });

        newFrame.setVisible(true);
    }
}
