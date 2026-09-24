package playground.delegate;

import java.awt.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class Camera {

    private Function<Color, Color> filter;

    public Camera() {
        setFilter();
    }

    public Color capture(final Color inputColor){

        Color processedColor = filter.apply(inputColor);

        return processedColor;
    }

    @SafeVarargs
    public final void setFilter(final Function<Color, Color>... colors){
        filter =
                Stream.of(colors)
                        .reduce((filter, next) -> filter.andThen(next))
                        .orElse(color -> color);
    }

    static void main() {
        Camera camera = new Camera();

        Consumer<String> printCaptured = filterInfo ->
                System.out.printf("with %s: %s%n",
                        filterInfo,
                        camera.capture(new Color(107, 100, 200, 101))
                );

        printCaptured.accept("no filter");

        camera.setFilter(Color::brighter, Color::darker);
        printCaptured.accept("brighter filter");
    }
}
