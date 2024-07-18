package it.polito.oop.books;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;


public class ExerciseChapter {

    private String title;
    private Integer numPages;
    TreeMap<String, Topic> topics = new TreeMap<>();
    private HashSet<Question> questions = new HashSet<>();

    public ExerciseChapter(String title, Integer numPages){
        this.title=title;
        this.numPages=numPages;
    }

    public List<Topic> getTopics() {
        return topics.values().stream().sorted(Comparator.comparing(Topic :: getKeyword)).collect(Collectors.toList());
	};
	

    public String getTitle() {
        return title;
    }

    public void setTitle(String newTitle) {
        this.title=newTitle;
    }

    public int getNumPages() {
        return numPages;
    }
    
    public void setNumPages(int newPages) {
        this.numPages=newPages;
    }
    

	public void addQuestion(Question question) {
        questions.add(question);
        topics.put(question.getMainTopic().getKeyword(),question.getMainTopic());
	}
}
