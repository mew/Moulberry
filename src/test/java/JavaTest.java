import org.junit.jupiter.api.Test;
import zone.nora.moulberry.MoulberryKt;

import java.util.concurrent.atomic.AtomicReference;

public class JavaTest {
    @Test
    public void testJavaInterop() {
        AtomicReference<String> s = new AtomicReference<>("hello");
        MoulberryKt.javaSwitch(s.get(), aSwitch -> {
            aSwitch.addCase("hi", false, () -> s.set("nope"));
            aSwitch.addCase("hello", true, () -> s.set("yep"));
            aSwitch.setDefault(() -> s.set("default!"));
            return aSwitch;
        });
        System.out.println(s.get());
    }
}
