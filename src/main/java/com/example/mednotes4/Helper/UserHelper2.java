package com.example.mednotes4.Helper;

import java.io.Serializable;

public class UserHelper2  implements Serializable {

    private String doctorName;
    private String doctorSurname;

    public  UserHelper2(){}
    public UserHelper2(String doctorName, String doctorSurname) {
        this.doctorName = doctorName;
        this.doctorSurname = doctorSurname;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorSurname() {
        return doctorSurname;
    }

    public void setDoctorSurname(String doctorSurname) {
        this.doctorSurname = doctorSurname;
    }
}
