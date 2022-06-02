package demo.broker.kafka.listener;

import demo.broker.kafka.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class StartupListener{

    static int i = 1;

    static  Model model;
    static List<Model> listModel = new ArrayList();
    static List<Model> listModel2 = new ArrayList();

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String msg) {
        kafkaTemplate.send("test", msg);
    }

    @KafkaListener(topics = "test", groupId = "group-id")
    public void listen(String message) throws Exception{
        System.out.println("Start Received: "+ message);
        Thread.sleep(3000);
        System.out.println("Finish Received- group-id: " + message);
    }

//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        for (int i = 0; i < 20; i++) {
//            sendMessage("Now: " + new Date());
//            Thread.sleep(2000);
//        }
//    }

    public void action1() throws  Exception{
        String actionType = "1";

        for (int i=0 ; i< 5; ++ i){
            initModel(actionType);
            Thread.sleep(3000);
        }
    }

    public void action2() throws Exception{
        String actionType = "2";

        for (int i=0 ; i< 5; ++ i){
            initModel(actionType);
            Thread.sleep(3000);
        }
    }

    private void initModel(String action){
        model = new Model("name"+i, "Thai Nguyen");
        i++;
        println(action+" -- "+model);
    }

    private void initModel2(){
        model = new Model("name"+i, "Thai Nguyen");
        i++;
        listModel2.add(model);
    }

    private void println(String message){
        try {
            System.out.println("Start Received: "+ message);
            Thread.sleep(3000);
            System.out.println("Finish Received- group-id: " + message);
        }catch (Exception e){

        }

    }


}
