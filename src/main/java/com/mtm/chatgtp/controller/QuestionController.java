package com.mtm.chatgtp.controller;

import com.mtm.chatgtp.ChatgtpApplication;
import com.mtm.chatgtp.dto.ResponseDTO;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final ChatgptService chatgptService;

    @GetMapping("/send")
    public ResponseDTO<String> send(@RequestParam String message){
        log.info("message is : {}", message);
        String responseMessage = chatgptService.sendMessage(message);
        log.info("response is : {}", responseMessage);
        return ResponseDTO.success(responseMessage);
    }
}
