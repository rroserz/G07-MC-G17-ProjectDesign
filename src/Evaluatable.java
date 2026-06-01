/**
 * Evaluatable Interface
 * Defines the contract for evaluating quiz answers
 */
public interface Evaluatable {
    /**
     * Checks the user's answer against the correct answer
     * @return true if the answer is correct, false otherwise
     */
    void checkAnswer();
}
