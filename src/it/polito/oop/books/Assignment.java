package it.polito.oop.books;

import java.util.HashMap;
import java.util.List;


public class Assignment {

    private String id;
    private ExerciseChapter chapter;
    private HashMap<Question, Double> answers = new HashMap<>();

    public Assignment(String id, ExerciseChapter e){
        this.id=id;
        this.chapter=e;
    }

    public String getID() {
        return id;
    }

    public ExerciseChapter getChapter() {
        return chapter;
    }

    public double addResponse(Question q,List<String> answers) {
        
        return -1.0;
    }
    
    public double totalScore() {
        return -1.0;
    }

}
