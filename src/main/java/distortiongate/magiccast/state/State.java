package distortiongate.magiccast.state;

public interface State {

    void execute();
    State getNextState();
}
