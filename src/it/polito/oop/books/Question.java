package it.polito.oop.books;

import java.util.Set;
import java.util.TreeMap;
import java.util.LinkedList;


public class Question {

	private String question;
	private Topic topic;
	private TreeMap<Boolean, LinkedList<String>> answers = new TreeMap<>();
	
	public String getQuestion() {
		return question;
	}
	
	public Topic getMainTopic() {
		return topic;
	}

	public void addAnswer(String answer, boolean correct) {
		
	}
	
    @Override
    public String toString() {
        return question + "(" + topic.getKeyword() + ")";
    }

	public long numAnswers() {
	    return -1;
	}

	public Set<String> getCorrectAnswers() {
		return null;
	}

	public Set<String> getIncorrectAnswers() {
        return null;
	}
}
