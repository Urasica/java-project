import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class clickSound {
    public static void playSound(String soundFilePath, double volume) {
        try {
            // 파일 로드
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                    new File(soundFilePath).getAbsoluteFile());

            // 소리 재생을 위한 Clip 생성
            Clip clip = AudioSystem.getClip();

            // Clip에 음원 할당
            clip.open(audioInputStream);

            // 소리 크기 조절을 위한 FloatControl 얻기
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(20f * (float) Math.log10(volume));

            // 소리 재생
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }
}