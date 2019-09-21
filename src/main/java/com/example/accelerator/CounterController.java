package com.example.accelerator;

import com.example.accelerator.config.CountConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class CounterController {
    @GetMapping("/counter")
    public String greeting(Map<String, Object> model)
    {
        model.put("count", " ");
        return "counter";
    }

    @PostMapping("/counter")
    public String analis(@RequestParam String text, Map<String, Object> model) {
        CountConfig countconfig = new CountConfig();
        String count = countconfig.newConfig(text);
        model.put("count", count);
        return "counter";
    }
}
