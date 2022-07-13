package src.core;

import src.interfaces.SecretGeneratorInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SecretGenerator implements SecretGeneratorInterface {
    private static final int SECRET_LENGTH = 4;
    private List<Integer> numbers;

    public SecretGenerator() {
       initialiseNumberList();
    }

    private void initialiseNumberList(){
        numbers = new ArrayList<>();
        for(int num = 0; num < 10; num++){
            numbers.add(num);
        }
    }
    @Override
    public String generateSecret() {
        Collections.shuffle(numbers);

        String result = "";
        for(int index = 0; index < SECRET_LENGTH; index++){
            result += numbers.get(index).toString();
        }
        return result;
    }
}
