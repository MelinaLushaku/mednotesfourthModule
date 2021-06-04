package com.example.mednotes4.Services;

import com.example.mednotes4.DAL.ConversationRepository;
import com.example.mednotes4.Model.Conversation;
import com.example.mednotes4.Model.DoctorEntity;
import com.example.mednotes4.Model.PatientEntity;
import com.example.mednotes4.OutputAdapters.SystemManagementModuleServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConversationService implements IConversationService{

    @Autowired
    private SystemManagementModuleServ systemManagementModuleServ;

    @Autowired
    private ConversationRepository conversationRepository;
    @Override
    public String getPatients(){
        return this.systemManagementModuleServ.getAllPatients();
    }

    @Override
    public PatientEntity pacientiE(int nrPersonal){

        return this.systemManagementModuleServ.pacientiE(nrPersonal);
    }

    @Override
    public DoctorEntity doctorE(int doctorPersonalNumber){

        return this.systemManagementModuleServ.doctoriE(doctorPersonalNumber);
    }


    @Override
    public void addNewConverationP(Conversation c){
        this.conversationRepository.save(c);
    }

    @Override
    public List<Conversation> listaBisedes(int doc , int pat){
        List<Conversation>lista = this.conversationRepository.findConvByUsers(doc , pat);
        return lista;
    }

}
