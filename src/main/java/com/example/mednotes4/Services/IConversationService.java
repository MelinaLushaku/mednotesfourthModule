package com.example.mednotes4.Services;

import com.example.mednotes4.Model.Conversation;
import com.example.mednotes4.Model.DoctorEntity;
import com.example.mednotes4.Model.PatientEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IConversationService {
    String getPatients();
    PatientEntity pacientiE(int nrPersonal);
    DoctorEntity doctorE(int doctorPersonalNumber);
    void addNewConverationP(Conversation c);
    List<Conversation> listaBisedes(int doc , int pat);
    void deleteConvForPat(int doc , int pat);
    ResponseEntity deleteConvForDoc(int pat);
    List<PatientEntity> listaEBisedaveDoctor(int docNumber);
    List<DoctorEntity> listaEBisedavePatient(int patNumber);
}
