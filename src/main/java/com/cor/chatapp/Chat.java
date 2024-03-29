package com.cor.chatapp;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
// 시범
@Data
@Document(collection = "chat")
public class Chat {
    @Id
    private String id;
    private String msg;
    private String sender; //보내느 사람
    private String receiver; // 받는 사람(귓속말)
    private Integer roomNum; // 방 번호(여러 사람 들어올 수 있음)
    private LocalDateTime createdAt;


}
