package it.polito.oop.books;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Book {

	TreeMap<String, Topic> topics = new TreeMap<>();

    /**
	 * Creates a new topic, if it does not exist yet, or returns a reference to the
	 * corresponding topic.
	 * 
	 * @param keyword the unique keyword of the topic
	 * @return the {@link Topic} associated to the keyword
	 * @throws BookException
	 */
	public Topic getTopic(String keyword) throws BookException {
		if(keyword==null || keyword.isEmpty()) throw new BookException();
		if(topics.get(keyword)==null) topics.put(keyword, new Topic(keyword));
	    return topics.get(keyword);
	}

	public Question createQuestion(String question, Topic mainTopic) {
		Question q = new Question(question, mainTopic);
		topics.get(mainTopic.getKeyword()).addQuestion(q);
        return q;
	}

	public TheoryChapter createTheoryChapter(String title, int numPages, String text) {
        return null;
	}

	public ExerciseChapter createExerciseChapter(String title, int numPages) {
        return null;
	}

	public List<Topic> getAllTopics() {
        return null;
	}

	public boolean checkTopics() {
        return false;
	}

	public Assignment newAssignment(String ID, ExerciseChapter chapter) {
        return null;
	}
	
    /**
     * builds a map having as key the number of answers and 
     * as values the list of questions having that number of answers.
     * @return
     */
    public Map<Long,List<Question>> questionOptions(){
        return null;
    }
}
