package com.project.demo;


import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;


@Controller
public class DogImageClient {

    @EventListener (ApplicationReadyEvent.class)
    public String getDogImage() {
        RestTemplate restTemplate = new RestTemplate();
        JsonNode jsonNode = restTemplate.getForObject("https://random.dog/woof.json", JsonNode.class);
       // System.out.println(jsonNode.get("url").asText()); // aby wyświetliło w konsoli
        return jsonNode.get("url").asText();
    }
}








