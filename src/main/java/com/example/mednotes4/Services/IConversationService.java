package com.example.mednotes4.Services;

import com.example.mednotes4.Model.Conversation;
import com.example.mednotes4.Model.DoctorEntity;
import com.example.mednotes4.Model.PatientEntity;

import java.util.List;

public interface IConversationService {
    String getPatients();
    PatientEntity pacientiE(int nrPersonal);
    DoctorEntity doctorE(int doctorPersonalNumber);
    void addNewConverationP(Conversation c);
    List<Conversation> listaBisedes(int doc , int pat);
}
