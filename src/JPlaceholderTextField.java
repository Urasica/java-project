import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JTextField;

// JTextField에 placeholder를 놓기 위한 클래스
public class JPlaceholderTextField extends JTextField {
    private String placeholder;  // placeholder로 들어갈 문자열

    // 문자열을 받아 placeholder에 집어넣기
    public JPlaceholderTextField(String placeholder) {
        this.placeholder = placeholder;
    }

    @Override // JTextField 컴포넌트의 출력을 오버라이드 하여
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 텍스트 필드가 비어있을 때만 placeholder 그리기
        if (getText().isEmpty()) {
            g.setColor(Color.GRAY);
            int textHeight = g.getFontMetrics().getHeight();
            int textWidth = g.getFontMetrics().stringWidth(placeholder);
            int x = (getWidth() - textWidth) / 2; // 좌우 중앙
            int y = (getHeight() - textHeight) / 2; // 상하 중앙
            g.drawString(placeholder, x, y + textHeight); // placeholder 배치
        }
    }
}