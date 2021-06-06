package com.example.mednotes4.DAL;

import com.example.mednotes4.Model.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ConversationRepository extends JpaRepository<Conversation , Integer> {
    @Query("select c from Conversation c where c.doctorEntity.doctorPersonalNumber=?1 and c.patientEntity.personalNumber=?2")
    List<Conversation> findConvByUsers(int doc, int pat);

    @Query("select c from Conversation c where c.doctorEntity.doctorPersonalNumber=?1")
    List<Conversation> findConvByDoc(int doc);

    @Query("select c from Conversation c where   c.patientEntity.personalNumber=?1")
    List<Conversation> findConvByPat(int pat);




}
