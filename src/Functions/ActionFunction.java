package Functions;
import java.util.function.Supplier;

public interface ActionFunction extends Supplier<Boolean>{
    @Override
    Boolean get();
}

