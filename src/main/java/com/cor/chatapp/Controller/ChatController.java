package com.cor.chatapp.Controller;

import com.cor.chatapp.Chat;
import com.cor.chatapp.Repo.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.LocalDateTime;


@RequiredArgsConstructor //생성자
@RestController // 해당 class를 RestAPI를 처리하는 Controller로 등록
public class ChatController {
    private final ChatRepository chatRepository;

    // 생성자 호출되기 전에 chatRepository 초기화

    // 귓속말용
    // 데이터 계속 return하는 Flux
    @CrossOrigin
    @GetMapping(value = "/sender/{sender}/receiver/{receiver}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Chat> getMsg(@PathVariable String sender, @PathVariable String receiver) {
        return chatRepository.mFindBySender(sender, receiver)
                .subscribeOn(Schedulers.boundedElastic());
    }
    @CrossOrigin
    @GetMapping(value = "/chat/roomNum/{roomNum}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Chat> FindByRoomNum(@PathVariable Integer roomNum){
        return chatRepository.mFindByRoomNum(roomNum)
                .subscribeOn(Schedulers.boundedElastic());
    }
    // 데이터 한 번 return 하는 Mono
    @CrossOrigin
    @PostMapping("/chat")
    public Mono<Chat> setMsg(@RequestBody Chat chat){
        chat.setCreatedAt(LocalDateTime.now());
        return chatRepository.save(chat); //object를 리턴하면 자동으로 JSON 변환(message convertor)
    }
}
