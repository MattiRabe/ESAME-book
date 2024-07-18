package it.polito.oop.books;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.Comparator;


public class TheoryChapter {

    private String title;
    private Integer numPages;
    private String text;
    TreeMap<String, Topic> topics = new TreeMap<>();

    public TheoryChapter(String title, Integer numPages, String text){
        this.title=title;
        this.numPages=numPages;
        this.text=text;
    }

    public String getText() {
		return text;
	}

    public void setText(String newText) {
        this.text=newText;
    }


	public List<Topic> getTopics() {
        return topics.values().stream().sorted(Comparator.comparing(Topic :: getKeyword)).collect(Collectors.toList());
	}

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
    
    public void addTopic(Topic topic) {
        topics.put(topic.getKeyword(), topic);
        topic.incrementPopularity();
        if(topic.getSubTopics().size()==0) return;
        for(Topic t : topic.getSubTopics()){
            addTopic(t);
        }
    }

    public TreeMap<String, Topic> getTopicMap(){
        return topics;
    }
}
