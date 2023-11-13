import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JTextField;

public class JPlaceholderTextField extends JTextField {
    private String placeholder;

    public JPlaceholderTextField(String placeholder) {
        this.placeholder = placeholder;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 텍스트 필드가 비어있을 때만 placeholder 그리기
        if (getText().isEmpty()) {
            g.setColor(Color.GRAY);
            int textHeight = g.getFontMetrics().getHeight();
            int textWidth = g.getFontMetrics().stringWidth(placeholder);
            int x = (getWidth() - textWidth) / 2; 
            int y = (getHeight() - textHeight) / 2;
            g.drawString(placeholder, x, y + textHeight);
        }
    }
}