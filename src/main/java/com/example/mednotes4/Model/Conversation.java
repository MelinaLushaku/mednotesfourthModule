package com.example.mednotes4.Model;

import javax.persistence.*;

@Entity
public class Conversation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int conversationId;


    @Column
    private String conversationDes;

    public Conversation(){}
    public Conversation(String conversationDes) {
        this.conversationDes = conversationDes;
    }

    public int getConversationId() {
        return conversationId;
    }

    public void setConversationId(int conversationId) {
        this.conversationId = conversationId;
    }

    public String getConversationDes() {
        return conversationDes;
    }

    public void setConversationDes(String conversationDes) {
        this.conversationDes = conversationDes;
    }
}
