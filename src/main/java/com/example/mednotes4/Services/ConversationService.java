package com.example.mednotes4.Services;

import com.example.mednotes4.DAL.ConversationRepository;
import com.example.mednotes4.Model.Conversation;
import com.example.mednotes4.Model.DoctorEntity;
import com.example.mednotes4.Model.PatientEntity;
import com.example.mednotes4.OutputAdapters.SystemManagementModuleServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Override
    public void deleteConvForPat(int doc , int pat){
        List<Conversation> lista = this.conversationRepository.deleteConvBy(doc, pat);

        if(lista.size() != 0){
        /*for(int i = 0 ; i<lista.size() ; i++) {
            this.conversationRepository.delete(lista.get(i));

        }*/
            this.conversationRepository.deleteInBatch(lista);
        }


    }
    @Override
    public ResponseEntity deleteConvForDoc(int pat){
        List<Conversation> lista = this.conversationRepository.findConvByPat(pat);
        if(lista.size() != 0){
        for(int i = 0 ; i<lista.size() ; i++) {
            this.conversationRepository.delete(lista.get(i));
            return ResponseEntity.ok("Conversation Deleted");
        }
        }
            return ResponseEntity.ok("This conversation doesn't exists!");

    }

    @Override
    public List<PatientEntity> listaEBisedaveDoctor(int docNumber){
        List <Conversation> lista = this.conversationRepository.findConvByDoc(docNumber);
        if(lista.size() != 0){
            List <PatientEntity>pacientat = new ArrayList<PatientEntity>();
            for (int i = 0 ; i < lista.size() ; i++){
                PatientEntity pe = lista.get(i).getPatientEntity();
                if (pacientat.size() !=0) {
                    for (int j = 0; j < pacientat.size(); j++) {
                        if (pe.getPersonalNumber() != pacientat.get(j).getPersonalNumber()) {
                            pacientat.add(pe);
                        }
                    }
                }
                else{
                        pacientat.add(pe);
                    }
            }
            return pacientat;
        }
          return null;
    }
     @Override
     public List<DoctorEntity> listaEBisedavePatient(int patNumber){
         List <Conversation> lista = this.conversationRepository.findConvByPat(patNumber);
         if(lista.size() != 0){
             List <DoctorEntity>mjeket = new ArrayList<DoctorEntity>();
             for (int i = 0 ; i < lista.size() ; i++){
                 DoctorEntity pe = lista.get(i).getDoctorEntity();
                 if (mjeket.size() !=0) {
                     for (int j = 0; j < mjeket.size(); j++) {

                         if (pe.getDoctorPersonalNumber() != mjeket.get(j).getDoctorPersonalNumber()) {
                             mjeket.add(pe);
                         }
                     }
                 }
                 else{
                     mjeket.add(pe);
                 }
             }
             return mjeket;
         }
         return null;
     }
}
