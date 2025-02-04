package it.polito.oop.books;

import java.util.List;
import java.util.TreeMap;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Topic {


	private String keyWord;
	private Integer popularity;
	private TreeMap<String, Topic> subTopics = new TreeMap<>();
	private HashSet<Question> questions = new HashSet<>();

	public Topic(String keyword){
		this.keyWord=keyword;
		this.popularity=0;
	}

	public String getKeyword() {
        return keyWord;
	}
	
	@Override
	public String toString() {
	    return keyWord + ":" + popularity;
	}

	public boolean addSubTopic(Topic topic) {
		if(subTopics.get(topic.getKeyword())==null){
			subTopics.put(topic.getKeyword(), topic);
			return true;
		}
        return false;
	}

	/*
	 * Returns a sorted list of subtopics. Topics in the list *MAY* be modified without
	 * affecting any of the Book topic.
	 */
	public List<Topic> getSubTopics() {
        return subTopics.values().stream().collect(Collectors.toList());
	}

	public void addQuestion(Question q){
		questions.add(q);
	}

	public Integer getPopularity(){
		return popularity;
	}

	public void incrementPopularity(){
		popularity++;
	}
}
