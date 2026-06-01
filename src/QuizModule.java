/**
 *Member 2
 *Name: Mohamad Syahmi bin Soria
 *Matric ID: 84553
 */

import java.util.ArrayList;
import java.util.List;

/**
 * QuizModule Class
 * Implements the Evaluatable interface
 * Manages 20 quiz questions and calculates final score
 */
public class QuizModule implements Evaluatable {
    private List<Question> questions;
    private List<Integer> userAnswers; // Store user's answers for each question
    private int currentQuestionIndex;
    private int finalScore;
    private final int TOTAL_QUESTIONS = 20;
    
    /**
     * Constructor - Initializes the quiz module
     */
    public QuizModule() {
        this.questions = new ArrayList<>();
        this.userAnswers = new ArrayList<>();
        this.currentQuestionIndex = 0;
        this.finalScore = 0;
        initializeQuestions();
    }
    
    /**
     * Initialize 20 sample questions (mix of Multiple Choice and True/False)
     * This can be replaced with questions loaded from a file
     */
    private void initializeQuestions() {
        // Multiple Choice Questions
        questions.add(new Question("What is the capital of France?", 
            new String[]{"London", "Paris", "Berlin", "Madrid"}, 1, "MC"));
        
        questions.add(new Question("Which planet is closest to the Sun?", 
            new String[]{"Venus", "Mercury", "Earth", "Mars"}, 1, "MC"));
        
        questions.add(new Question("Who wrote 'Romeo and Juliet'?", 
            new String[]{"Charles Dickens", "Mark Twain", "William Shakespeare", "Jane Austen"}, 2, "MC"));
        
        questions.add(new Question("What is the largest ocean on Earth?", 
            new String[]{"Atlantic", "Indian", "Arctic", "Pacific"}, 3, "MC"));
        
        questions.add(new Question("In what year did World War II end?", 
            new String[]{"1943", "1944", "1945", "1946"}, 2, "MC"));
        
        // True/False Questions
        questions.add(new Question("The Great Wall of China is visible from space.", 
            new String[]{"True", "False"}, 1, "TF"));
        
        questions.add(new Question("Java was named after a coffee bean.", 
            new String[]{"True", "False"}, 0, "TF"));
        
        questions.add(new Question("The Eiffel Tower was originally intended to be permanent.", 
            new String[]{"True", "False"}, 1, "TF"));
        
        questions.add(new Question("Honey never spoils and can last forever.", 
            new String[]{"True", "False"}, 0, "TF"));
        
        questions.add(new Question("Antarctica is the hottest continent.", 
            new String[]{"True", "False"}, 1, "TF"));
        
        // More Multiple Choice Questions
        questions.add(new Question("What is the smallest prime number?", 
            new String[]{"0", "1", "2", "3"}, 2, "MC"));
        
        questions.add(new Question("Which element has the atomic number 1?", 
            new String[]{"Helium", "Hydrogen", "Lithium", "Beryllium"}, 1, "MC"));
        
        questions.add(new Question("How many continents are there?", 
            new String[]{"5", "6", "7", "8"}, 2, "MC"));
        
        questions.add(new Question("What is the boiling point of water at sea level?", 
            new String[]{"90°C", "100°C", "110°C", "120°C"}, 1, "MC"));
        
        questions.add(new Question("Which country is home to the Statue of Liberty?", 
            new String[]{"France", "Canada", "United States", "Mexico"}, 2, "MC"));
        
        // More True/False Questions
        questions.add(new Question("A decade equals 10 years.", 
            new String[]{"True", "False"}, 0, "TF"));
        
        questions.add(new Question("The human brain weighs approximately 2 kg.", 
            new String[]{"True", "False"}, 0, "TF"));
        
        questions.add(new Question("Dolphins are fish.", 
            new String[]{"True", "False"}, 1, "TF"));
        
        questions.add(new Question("All squares are rectangles.", 
            new String[]{"True", "False"}, 0, "TF"));
        
        questions.add(new Question("The speed of light is faster than the speed of sound.", 
            new String[]{"True", "False"}, 0, "TF"));
    }
    
    /**
     * Get the current question
     * @return The current Question object
     */
    public Question getCurrentQuestion() {
        if (currentQuestionIndex < questions.size()) {
            return questions.get(currentQuestionIndex);
        }
        return null;
    }
    
    /**
     * Submit an answer for the current question
     * @param answerIndex The index of the selected answer
     * @return true if the answer was submitted successfully
     */
    public boolean submitAnswer(int answerIndex) {
        if (currentQuestionIndex < questions.size()) {
            userAnswers.add(answerIndex);
            currentQuestionIndex++;
            return true;
        }
        return false;
    }
    
    /**
     * Implements the checkAnswer method from Evaluatable interface
     * Evaluates all answers and calculates the final score
     */
    @Override
    public void checkAnswer() {
        calculateScore();
    }
    
    /**
     * Calculate the final score based on correct answers
     */
    public void calculateScore() {
        int correctCount = 0;
        
        for (int i = 0; i < questions.size() && i < userAnswers.size(); i++) {
            if (questions.get(i).isAnswerCorrect(userAnswers.get(i))) {
                correctCount++;
            }
        }
        
        // Calculate score as a percentage
        this.finalScore = (correctCount * 100) / questions.size();
    }
    
    /**
     * Get the final score
     * @return The score as a percentage (0-100)
     */
    public int getFinalScore() {
        return finalScore;
    }
    
    /**
     * Get the number of correct answers
     * @return Number of correct answers
     */
    public int getCorrectAnswerCount() {
        int correctCount = 0;
        for (int i = 0; i < questions.size() && i < userAnswers.size(); i++) {
            if (questions.get(i).isAnswerCorrect(userAnswers.get(i))) {
                correctCount++;
            }
        }
        return correctCount;
    }
    
    /**
     * Get total number of questions
     * @return Total questions in the quiz
     */
    public int getTotalQuestions() {
        return TOTAL_QUESTIONS;
    }
    
    /**
     * Get current question number (1-based)
     * @return Current question number
     */
    public int getCurrentQuestionNumber() {
        return currentQuestionIndex + 1;
    }
    
    /**
     * Check if quiz is complete
     * @return true if all questions have been answered
     */
    public boolean isQuizComplete() {
        return currentQuestionIndex >= questions.size();
    }
    
    /**
     * Reset the quiz for a new attempt
     */
    public void resetQuiz() {
        this.userAnswers.clear();
        this.currentQuestionIndex = 0;
        this.finalScore = 0;
    }
    
    /**
     * Get a specific question by index
     * @param index The question index
     * @return The Question at the specified index
     */
    public Question getQuestion(int index) {
        if (index >= 0 && index < questions.size()) {
            return questions.get(index);
        }
        return null;
    }
}
