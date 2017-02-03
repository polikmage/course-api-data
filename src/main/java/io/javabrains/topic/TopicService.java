package io.javabrains.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mapo0104 on 31.1.2017.
 */
@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

//    private List<Topic> topics = new ArrayList<>(Arrays.asList(
//            new Topic("spring","springframework", "spr descrption"),
//            new Topic("java","core java", "corejava descrption"),
//            new Topic("jscript","jscriptomg", "javasrctiptdescrption")
//    ));


    public List<Topic> getAllTopics(){
        //return topics;
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add); // najde vsechny zaznamy v db a prida je do listu topics
        return topics;
    }

    public Topic getTopic(String id) {
        return topicRepository.findOne(id);
    }

    public void addTopic(Topic topic){
        topicRepository.save(topic);
    }

    public void updateTopic(Topic topic, String id) {
        topicRepository.findAll().forEach(topic1 -> topic.getId().equals(id));
    }

    public void deleteTopic(String id) {
        topicRepository.delete(id);
    }
}
