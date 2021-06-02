package com.example.mednotes4.DAL;

import com.example.mednotes4.Model.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversationRepository extends JpaRepository<Conversation , Integer> {
}
