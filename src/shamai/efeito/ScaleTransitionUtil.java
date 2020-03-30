package shamai.efeito;

import javafx.animation.ScaleTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class ScaleTransitionUtil {

    private static ScaleTransition transition = null;

    public static ScaleTransition getScaleTransition(Node node) {
        if (transition == null) {
            transition = new ScaleTransition();
            transition.setDuration(Duration.millis(200));
            transition.setFromX(0.40);
            transition.setToX(1);
            transition.setFromY(0.20);
            transition.setToY(1);
        }
        transition.setNode(node);
        return transition;
    }

}
