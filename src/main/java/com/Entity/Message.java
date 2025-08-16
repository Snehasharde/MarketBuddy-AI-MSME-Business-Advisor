package com.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String advisorType;

    @Column(length = 2000)
    private String userMessage;

    @Column(length = 4000)
    private String advisorReply;

    private LocalDateTime timestamp;

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getAdvisorType() { return advisorType; }
    public void setAdvisorType(String advisorType) { this.advisorType = advisorType; }
    public String getUserMessage() { return userMessage; }
    public void setUserMessage(String userMessage) { this.userMessage = userMessage; }
    public String getAdvisorReply() { return advisorReply; }
    public void setAdvisorReply(String advisorReply) { this.advisorReply = advisorReply; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
