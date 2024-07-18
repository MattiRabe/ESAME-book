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
        Double N, FP, FN; 
        Double ris;
        N=(double) q.numAnswers();
        FP= (double)answers.stream().filter(a->q.getIncorrectAnswers().contains(a)).count();
        Integer cn= q.getCorrectAnswers().size();
        Double c= (double)answers.stream().filter(a->q.getCorrectAnswers().contains(a)).count();
        FN=cn-c;
        ris=(N - FP - FN)/N;
        this.answers.put(q, ris);
        return ris;
    }
    
    public double totalScore() {
        Double tot=0.0;
        for(Double d : answers.values()) tot+=d;
        return tot;
    }
}
