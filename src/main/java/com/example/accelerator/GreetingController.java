package com.example.accelerator;

import com.example.accelerator.config.TextConfig;
import com.example.accelerator.domain.Message;
import com.example.accelerator.domain.Text;
import com.example.accelerator.domain.User;
import com.example.accelerator.repository.MessageRepository;
import com.example.accelerator.repository.TextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


@Controller
public class GreetingController {
    @Autowired
    private MessageRepository messageRepo;
    @Autowired
    private TextRepository textRepository;


    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Message> messages = messageRepo.findAll();

        model.put("messages", messages);

        return "main";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag, Map<String, Object> model
    ) {
        Message message = new Message(text, tag, user);

        messageRepo.save(message);

        Iterable<Message> messages = messageRepo.findAll();

        model.put("messages", messages);

        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Message> messages;

        if (filter != null && !filter.isEmpty()) {
            messages = messageRepo.findByTag(filter);
        } else {
            messages = messageRepo.findAll();
        }

        model.put("messages", messages);

        return "main";
    }
    @GetMapping("/accelerator")
    public String accelerator(Map<String, Object> model) {
        Iterable<Text> texts = textRepository.findAll();
        model.put("result", texts);
        return "accelerator";
    }
    @PostMapping("/accelerator")
    public String analis( @RequestParam String text, Map<String, Object> model) {
        TextConfig config = new TextConfig();
//        String newText =config.refactoring(text);
        String newText =config.refactoringNew(text, "XE");
        Text xenon = new Text();
        xenon.setDataXe(newText);
        textRepository.save(xenon);
        Iterable<Text> result = textRepository.findAll();
        
        model.put("texts", result);
        return "accelerator";
    }

    @GetMapping("/acceleratornew")
    public String acceleratorNew(Map<String, Object> model) {
        Iterable<Text> texts = textRepository.findAll();
        model.put("result", texts);
        return "acceleratornew";
    }

    @PostMapping("/acceleratornew")
    public String analisNew( @RequestParam String text, @RequestParam String element, Map<String, Object> model) {
        TextConfig config = new TextConfig();
        String newText =config.refactoringNew(text, element);
            model.put("texts", newText );
        return "acceleratornew";
    }
}