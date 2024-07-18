package it.polito.oop.books;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Book {

	TreeMap<String, Topic> topics = new TreeMap<>();
	TreeMap<String, TheoryChapter> theoryChapters = new TreeMap<>();
	TreeMap<String, ExerciseChapter> exerciseChapters = new TreeMap<>();
	HashSet<Question> questions = new HashSet<>();
	TreeMap<String, Assignment> assignments = new TreeMap<>();

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
		questions.add(q);
        return q;
	}

	public TheoryChapter createTheoryChapter(String title, int numPages, String text) {
		TheoryChapter t= new TheoryChapter(title, numPages, text);
		theoryChapters.put(title, t);
        return t;
	}

	public ExerciseChapter createExerciseChapter(String title, int numPages) {
        ExerciseChapter t= new ExerciseChapter(title, numPages);
		exerciseChapters.put(title, t);
        return t;
	}

	public List<Topic> getAllTopics() {
        return topics.values().stream().collect(Collectors.toList());
	}

	public boolean checkTopics() {
		Boolean present;
		for(ExerciseChapter c : exerciseChapters.values()){
			for(Topic t : c.getTopics()){
				present=false;
				for(TheoryChapter tc : theoryChapters.values()){
					if(tc.getTopicMap().containsValue(t)){
						present=true;
						break;
					}
				}
				if(present==false) return false;
			}
		}
        return true;
	}

	public Assignment newAssignment(String ID, ExerciseChapter chapter) {
		Assignment a = new Assignment(ID, chapter);
		assignments.put(a.getID(), a);
        return a;
	}
	
    /**
     * builds a map having as key the number of answers and 
     * as values the list of questions having that number of answers.
     * @return
     */
    public Map<Long,List<Question>> questionOptions(){
        return questions.stream().collect(Collectors.groupingBy(Question :: numAnswers));
    }

	public List<String> topicPopularity(){
		return topics.values().stream().sorted(Comparator.comparing(Topic::getPopularity).reversed()
		.thenComparing(Topic::getKeyword)).map(Topic::toString).collect(Collectors.toList());
	}
}
