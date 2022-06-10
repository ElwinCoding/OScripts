package BehaviourTreeNodes;

import lombok.Builder;

@Builder
public class Repeat implements Behaviour{

    private int repeat_count;
    private Behaviour child;

    @Override
    public boolean execute() {
        for(int i = 0; i < repeat_count; i++){
            if(!child.execute()){
                return false;
            }
        }
        return true;
    }
}
