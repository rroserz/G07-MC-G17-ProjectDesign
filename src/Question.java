/**
 * Question Class
 * Represents a single quiz question (Multiple Choice or True/False)
 */
public class Question {
    private String questionText;
    private String[] options;
    private int correctAnswerIndex;
    private String questionType; // "MC" for Multiple Choice, "TF" for True/False
    
    /**
     * Constructor for creating a question
     * @param questionText The question prompt
     * @param options Array of answer options
     * @param correctAnswerIndex Index of the correct answer (0-based)
     * @param questionType Type of question ("MC" or "TF")
     */
    public Question(String questionText, String[] options, int correctAnswerIndex, String questionType) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
        this.questionType = questionType;
    }
    
    // Getters
    public String getQuestionText() {
        return questionText;
    }
    
    public String[] getOptions() {
        return options;
    }
    
    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }
    
    public String getQuestionType() {
        return questionType;
    }
    
    /**
     * Validates if the provided answer is correct
     * @param userAnswerIndex The index of user's selected answer
     * @return true if correct, false otherwise
     */
    public boolean isAnswerCorrect(int userAnswerIndex) {
        return userAnswerIndex == correctAnswerIndex;
    }
    
    @Override
    public String toString() {
        return "Question{" +
                "questionText='" + questionText + '\'' +
                ", questionType='" + questionType + '\'' +
                '}';
    }
}
