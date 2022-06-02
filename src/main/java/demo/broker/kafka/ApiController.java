package demo.broker.kafka;

import demo.broker.kafka.listener.StartupListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    StartupListener startupListener;

    @GetMapping("/test")
    public String test(){
        System.out.println("Test Call api!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        return "oke ban oi";
    }

    @GetMapping("/action1")
    public String action1() throws Exception {
        startupListener.action1();
        return "done action 1";
    }

    @GetMapping("/action2")
    public String action2() throws Exception {
        startupListener.action2();
        return "done action 2";
    }

}
