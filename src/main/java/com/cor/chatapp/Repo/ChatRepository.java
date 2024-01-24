package com.cor.chatapp.Repo;

import com.cor.chatapp.Chat;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import reactor.core.publisher.Flux;

public interface ChatRepository extends ReactiveMongoRepository<Chat, String> {
    @Tailable // 커서를 안 닫고 계속 유지한다.
    @Query("{sender: ?0, receiver: ?1}") // 몽고디비 문법
    Flux<Chat> mFindBySender(String sender, String receiver); // Flux (흐름) response 유지하면서 데이터를 계속 흘려보냄

    @Tailable // 커서를 안 닫고 계속 유지한다.
    @Query("{roomNum: ?0}") // 몽고디비 문법
    Flux<Chat> mFindByRoomNum(Integer roomNum); // Flux (흐름) response 유지하면서 데이터를 계속 흘려보냄

}
