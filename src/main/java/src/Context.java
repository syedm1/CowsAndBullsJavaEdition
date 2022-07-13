package src;

import src.interfaces.AIGuesserInterface;
import src.interfaces.ScoreCalculatorInterface;
import src.models.AIGuessDetails;

public class Context {
    private AIGuesserInterface _aIGuesserInterfaceStrategy;

    public void setAIGuesserInterfaceStrategy(AIGuesserInterface AIGuesserInterfaceStrategy){
        _aIGuesserInterfaceStrategy = AIGuesserInterfaceStrategy;
    }

    public AIGuessDetails executeAIGuessStrategy(String secret, ScoreCalculatorInterface scoreCalculatorInterface){
        AIGuessDetails details = _aIGuesserInterfaceStrategy.guess(secret, scoreCalculatorInterface);
        return details;
    }
}
