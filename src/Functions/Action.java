package Functions;
import java.util.function.Supplier;

public interface Action extends Supplier<Boolean>{
    @Override
    Boolean get();
}

