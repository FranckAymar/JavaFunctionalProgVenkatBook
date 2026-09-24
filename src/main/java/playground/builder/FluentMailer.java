package playground.builder;

import java.util.function.Consumer;

public class FluentMailer {

    private FluentMailer() {
    }

    public FluentMailer from(String from) {
        return this;
    }

    public FluentMailer to(String to) {
        return this;
    }

    public FluentMailer message(String message) {
        return this;
    }

    public FluentMailer subject(String subject) {
        return this;
    }

    public static void send(Consumer<FluentMailer> block) {
        FluentMailer fluentMailer = new FluentMailer();
        block.accept(fluentMailer);
        System.out.println("Sending mail");
    }

    static void main() {
        FluentMailer.send(mailer -> {
            mailer
                    .from("")
                    .to("")
                    .subject("")
                    .to("");
        });
    }
}
