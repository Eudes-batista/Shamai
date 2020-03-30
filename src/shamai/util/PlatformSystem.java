package shamai.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class PlatformSystem {

    public static String PlatformSeparatorBar() {
        return System.getProperty("os.name").equals("Linux") ? "/" : "\\";
    }

    public static boolean isLinux() {
        return System.getProperty("os.name").toUpperCase().equals("LINUX");
    }
    
    public static boolean isSystemx64() {
        return getOperatingSystemArchitecture() != null && !"".equals(getOperatingSystemArchitecture()) 
                ? getOperatingSystemArchitecture().contains("64") : false;
    }
         
    public static Timeline addDateHourLabel(Label label) {
        KeyFrame frame = new KeyFrame(Duration.millis(1000), e -> label.setText(getDateFormatted("dd/MM/yyyy HH:mm:ss")));
        Timeline timeline = new Timeline(frame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        return timeline;
    }

    public static Timeline addHourLabel(Label label) {
        KeyFrame frame = new KeyFrame(Duration.millis(1000), e -> label.setText(getDateFormatted("HH:mm:ss")));
        Timeline timeline = new Timeline(frame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        return timeline;
    }
    
    private static String getDateFormatted(String formatter) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(formatter));
    }
    
    private static String getOperatingSystemArchitecture() {
        return System.getProperty("os.arch");
    }
}
