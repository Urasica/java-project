import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class backgroundMusic {
    private static Clip clip;
    private static FloatControl volumeControl;

    public static void playSound(String soundFilePath, double volume) {
        try {
            // 파일 로드
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                    new File(soundFilePath).getAbsoluteFile());

            // 소리 재생을 위한 Clip 생성
            clip = AudioSystem.getClip();

            // Clip에 음원 할당
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            
            volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            setVolume(volume);

            // 소리 재생
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }

	public static void setVolume(double volume) {
	    if (volumeControl == null) {
	        System.err.println("volumeControl이 아직 초기화되지 않았습니다.");
	        return;
	    }

	    float range = volumeControl.getMaximum() - volumeControl.getMinimum();
	    float gain = (float) (range * volume) + volumeControl.getMinimum();
	    volumeControl.setValue(gain);
	}
}
