## Cows and Bulls - Java Edition

A code-breaking game (which is what Mastermind was based on) with the following rules.

- The creator hides a secret 4 digit number
- The guesser attempts to guess the secret number
- The creator responds according to the following rules:
- For each digit that matches and is in the correct position = Bull
- For each digit that matches and is in the incorrect position = Cow

**For example:**  

Secret = 1234  
Guess = 9213

Response: 1 Bull, 2 Cows (bulls = [2], cows = [1, 3])

The guesser wins when they correctly identify the secret number.

The puzzle is to build a computer assisted version of the game. The computer will play the creator, and the player the guesser.

**The requirements are:**

- Generate a secret
- Obtain a guess from the user
- Provide a response to the guess
- Inform the user if they have successfully guessed the answer

**Extended requirements:**
- Computer takes guess

**Assumption(s):**
- Number is not repeated