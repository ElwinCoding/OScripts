package Deprecated.BehaviourTreeNodes;

import lombok.Builder;

@Builder
public class Retry implements Behaviour {

    private int retry_count;
    private Behaviour child;

    @Override
    public boolean execute() {
        for(int i = 0; i < retry_count; i++){
            if(child.execute()){
                return true;
            }
        }
        return false;
    }
}
