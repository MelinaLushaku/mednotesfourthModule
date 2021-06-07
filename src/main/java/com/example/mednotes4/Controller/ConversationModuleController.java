package com.example.mednotes4.Controller;

import com.example.mednotes4.Helper.ConversationResponse;
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

    @PostMapping("/addNewConversation/{personalNumber}/{doctorPersonalNumber}/{fjaliaBisedes}/{roli}")
    public ResponseEntity addNewConversationPatient(@PathVariable int personalNumber, @PathVariable int doctorPersonalNumber , @PathVariable String fjaliaBisedes , @PathVariable int roli){
        PatientEntity pE =this.iConversationService.pacientiE(personalNumber);
        DoctorEntity dE = this.iConversationService.doctorE(doctorPersonalNumber);

        Conversation c = new Conversation(fjaliaBisedes , pE , dE, roli);
        this.iConversationService.addNewConverationP(c);
        return ResponseEntity.ok("ConversationAdded");

    }

    @GetMapping("/allConversation/{docNumber}/{patNumber}")
    public ConversationResponse getConversationsByUser(@PathVariable int docNumber , @PathVariable int patNumber){
        List<Conversation> list = this.iConversationService.listaBisedes(docNumber , patNumber);
        if(list.size() !=0){
            return new ConversationResponse.ConversationResponseBuilder<>(201).setMesazhin("List e sukseshme").setData(list).build();
        }
        return new ConversationResponse.ConversationResponseBuilder<>(401).setErrorin("There is no conversation!").build();

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
    public ConversationResponse patList(@PathVariable int patNumber){
        List<DoctorEntity> lista = this.iConversationService.listaEBisedavePatient(patNumber);
        if(lista != null){
            return new ConversationResponse.ConversationResponseBuilder<>(201).setMesazhin("List e suksseshme").setData(lista).build();
        }else {
            return new ConversationResponse.ConversationResponseBuilder<>(401).setErrorin("There is no conversation!").build();
        }
    }


}
