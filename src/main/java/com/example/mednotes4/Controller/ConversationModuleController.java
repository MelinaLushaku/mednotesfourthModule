package com.example.mednotes4.Controller;

import com.example.mednotes4.Model.Conversation;
import com.example.mednotes4.Model.DoctorEntity;
import com.example.mednotes4.Model.PatientEntity;
import com.example.mednotes4.Services.IConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/conversationManagement")
public class ConversationModuleController {

    @Autowired
    private IConversationService iConversationService;

    @GetMapping("/allPatients")
    public String getAllPatientsFromFirstModule(){
        return this.iConversationService.getPatients();

    }

    @PostMapping("/addNewConversation/{personalNumber}/{doctorPersonalNumber}/{fjaliaBisedes}")
    public ResponseEntity addNewConversationPatient(@PathVariable int personalNumber, @PathVariable int doctorPersonalNumber , @PathVariable String fjaliaBisedes){
        PatientEntity pE =this.iConversationService.pacientiE(personalNumber);
        DoctorEntity dE = this.iConversationService.doctorE(doctorPersonalNumber);

        Conversation c = new Conversation(fjaliaBisedes , pE , dE);
        this.iConversationService.addNewConverationP(c);
        return ResponseEntity.ok("ConversationAdded");

    }

}
