package Functions;
import java.util.function.Supplier;

public interface ConditionFunction extends Supplier<Boolean> {
    @Override
    Boolean get();
}
