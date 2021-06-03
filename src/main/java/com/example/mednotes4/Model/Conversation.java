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

    @Embedded
    private PatientEntity patientEntity;

    @Embedded
    private DoctorEntity doctorEntity;




    public Conversation(){}

    public Conversation( String conversationDes, PatientEntity patientEntity, DoctorEntity doctorEntity) {

        this.conversationDes = conversationDes;
        this.patientEntity = patientEntity;
        this.doctorEntity = doctorEntity;

    }

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

    public PatientEntity getPatientEntity() {
        return patientEntity;
    }

    public void setPatientEntity(PatientEntity patientEntity) {
        this.patientEntity = patientEntity;
    }

    public DoctorEntity getDoctorEntity() {
        return doctorEntity;
    }

    public void setDoctorEntity(DoctorEntity doctorEntity) {
        this.doctorEntity = doctorEntity;
    }
}
