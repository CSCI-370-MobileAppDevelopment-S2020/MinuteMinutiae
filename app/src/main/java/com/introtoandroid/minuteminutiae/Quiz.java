package com.introtoandroid.minuteminutiae;
import java.util.ArrayList;

/**
 * @author Miller Johnson
 * @version 1.0
 * @since 1.0
 */
public class Quiz{
    private ArrayList<String> questionList;
    private ArrayList<String> answerList;
    private String name;

    /**
     * Default constructor
     */
    public Quiz(){
        questionList = new ArrayList<>();
        answerList = new ArrayList<>();
        name = null;
    }


    /**
     * Constructor
     * @param questionList A list of strings that act as the questions for a quiz.
     *                    Order of questions should match order of answers.
     * @param answerList A list of strings that act as the answers for the questions.
     *                    Order of answers should match order of questions.
     */
    public Quiz(ArrayList<String> questionList, ArrayList<String> answerList){
        this.questionList = questionList;
        this.answerList = answerList;
    }

    /**
     * Sets the name of the quiz
     * @param name Name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Returns the name of the quiz
     * @return Name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Returns the entire question list as an ArrayList
     * @return Question list if present, null if no question list defined.
     */
    public ArrayList<String> getQuestionList(){
        if(questionList != null) {
            return questionList;
        }
        else{
            System.out.println("No question list defined.");
            return null;
        }
    }

    /**
     * Assign a list of questions to a quiz.
     * <p>
     *     Assign a list of questions to a quiz. Replaces any previous question list.
     *     Length and order should match answer list.
     * </p>
     * @param questionList List of questions
     */
    public void setQuestionList(ArrayList<String> questionList){
        this.questionList = questionList;
    }

    /**
     * Prints each question in the question list
     */
    public void printQuestionList(){
        if(questionList.isEmpty()) {
            System.out.println("Question list is empty.");
        }
        else{
            for (int i = 1; i < questionList.size()+1; i++) {
                System.out.println(i + ") " + questionList.get(i - 1));
            }
        }

    }

    /**
     * Returns the question at the given index. (Zero indexed.)
     * @param index Index
     * @return Question at the given index.
     */
    public String getQuestion(int index){
        return questionList.get(index);
    }

    /**
     * Set or replace the question at the given index
     * @param index Index
     * @param question New question.
     */
    public void setQuestion(int index, String question){
        if (question == null || question.equals("")) {
            System.out.println("Question cannot be empty.");
        }
        else {
            questionList.set(index, question);
        }
    }

    /**
     * Returns the entire answer list as an ArrayList.
     * @return Answer list
     */
    public ArrayList<String> getAnswerList(){
        if(answerList != null) {
            return answerList;
        }
        else{
            System.out.println("Answer list is undefined.");
            return null;
        }
    }

    /**
     * Assign a list of answers to a quiz.
     * <p>
     *     Assign a list of answers to a quiz. Replaces any previous answers.
     *     Length and order should match the question list.
     * </p>
     * @param answerList List of answers
     */
    public void setAnswerList(ArrayList<String> answerList){
        this.answerList = answerList;
    }

    /**
     * Print each answer in the answer list
     */
    public void printAnswerList(){
        if(answerList.isEmpty()){
            System.out.println("Answer list is empty.");
        }
        else {
            for (int i = 1; i < answerList.size() + 1; i++) {
                System.out.println(i + ") " + answerList.get(i - 1));
            }
        }
    }

    /**
     * Set or replace the answer at the given index.
     * @param index Index
     * @param answer Answer
     */
    public void setAnswer(int index, String answer){
        answerList.set(index, answer);
    }

    /**
     * Returns the answer at a given index.
     * @param index Index
     * @return Answer
     */
    public String getAnswer(int index){
        return answerList.get(index);
    }

    /**
     * Add question and answer pair to the quiz.
     * <p>
     *     Add question and answer pair to the quiz. Should be used when creating a new quiz
     *     to ensure that the question and answer lists stay the same length. Appends to the
     *     end of the respective lists.
     * </p>
     * @param question Question
     * @param answer Answer
     */
    public void addQuestionAndAnswer(String question, String answer){
        this.questionList.add(question);
        this.answerList.add(answer);
    }






}
