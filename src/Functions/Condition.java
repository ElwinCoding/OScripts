package Functions;
import java.util.function.Supplier;

public interface Condition extends Supplier<Boolean> {
    @Override
    Boolean get();
}
