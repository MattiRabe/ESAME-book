package it.polito.oop.books;

import java.util.Set;
import java.util.HashMap;
import java.util.TreeSet;


public class Question {

	private String question;
	private Topic topic;
	private HashMap<Boolean, TreeSet<String>> answers = new HashMap<>();

	public Question(String question, Topic t){
		this.topic=t;
		this.question=question;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public Topic getMainTopic() {
		return topic;
	}

	public void addAnswer(String answer, boolean correct) {
		if(answers.get(correct)!=null) answers.get(correct).add(answer);
		else{
			TreeSet<String> s = new TreeSet<>();
			s.add(answer);
			answers.put(correct, s); 
		}
	}
	
    @Override
    public String toString() {
        return question + "(" + topic.getKeyword() + ")";
    }

	public long numAnswers() {
	    return answers.values().stream().flatMap(TreeSet::stream).count();
	}

	public Set<String> getCorrectAnswers() {
		return answers.get(true);
	}

	public Set<String> getIncorrectAnswers() {
        return answers.get(false);
	}
}
