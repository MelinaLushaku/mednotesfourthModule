package com.example.mednotes4.Controller;

import com.example.mednotes4.Model.Conversation;
import com.example.mednotes4.Model.DoctorEntity;
import com.example.mednotes4.Model.PatientEntity;
import com.example.mednotes4.Services.IConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/allConversation/{docNumber}/{patNumber}")
    public ResponseEntity getConversationsByUser(@PathVariable int docNumber , @PathVariable int patNumber){
        List<Conversation> list = this.iConversationService.listaBisedes(docNumber , patNumber);
        if(list.size() !=0){
            return ResponseEntity.ok(list);
        }
        return ResponseEntity.ok("You havent talked before");

    }
    @PostMapping("/deleteConvPat/{docNumber}")
    public ResponseEntity patientDeleteConv(@PathVariable int docNumber){
       ResponseEntity re = this.iConversationService.deleteConvForPat(docNumber);
        return  re;
    }
    @PostMapping("/deleteConvDoc/{patNumber}")
    public ResponseEntity doctorDeleteConv(@PathVariable int patNumber){
       ResponseEntity re = this.iConversationService.deleteConvForDoc(patNumber);
        return  re;
    }


    @GetMapping("conversationListDoctor/{docNumber}")
    public ResponseEntity docList(@PathVariable int docNumber){
        List<PatientEntity> lista = this.iConversationService.listaEBisedaveDoctor(docNumber);
        if(lista == null){
            return  ResponseEntity.ok("You don't have a list of conversations");
        }else {
            return ResponseEntity.ok(lista);
        }
    }

    @GetMapping("conversationListPatient/{patNumber}")
    public ResponseEntity patList(@PathVariable int patNumber){
        List<DoctorEntity> lista = this.iConversationService.listaEBisedavePatient(patNumber);
        if(lista == null){
            return  ResponseEntity.ok("You don't have a list of conversations");
        }else {
            return ResponseEntity.ok(lista);
        }
    }


}
