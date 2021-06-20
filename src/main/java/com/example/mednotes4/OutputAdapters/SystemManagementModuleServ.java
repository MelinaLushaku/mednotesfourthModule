package com.example.mednotes4.OutputAdapters;

import com.example.mednotes4.Helper.UserHelper;
import com.example.mednotes4.Helper.UserHelper2;
import com.example.mednotes4.Model.DoctorEntity;
import com.example.mednotes4.Model.PatientEntity;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class SystemManagementModuleServ {

    public String getAllPatients(){
        RestTemplate restTemplate = new RestTemplate();
        String userServiceUrl="http://localhost:8090/api/systemManagement/admin/getAllPatient";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<String>(headers);
       return restTemplate.exchange(userServiceUrl, HttpMethod.GET, entity, String.class).getBody();

    }

    public PatientEntity pacientiE(int nrPersonal){
        RestTemplate restTemplate = new RestTemplate();
        String userServiceUrl="http://localhost:8090/api/systemManagement/admin/PatientByPersonal/"+nrPersonal;
        ResponseEntity<UserHelper> responseEntity = restTemplate.getForEntity(userServiceUrl , UserHelper.class );
        String emri = responseEntity.getBody().getName();
        String mbiemri = responseEntity.getBody().getSurname();
        int nrpersonal2 = nrPersonal;

        return new PatientEntity(emri,mbiemri,nrpersonal2);
    }

    public DoctorEntity doctoriE(int doctorPersonalNumber){
        RestTemplate restTemplate = new RestTemplate();
        String userServiceUrl="http://localhost:8090/api/systemManagement/admin/DoctortByPersonal/"+doctorPersonalNumber;
        ResponseEntity<UserHelper2> responseEntity = restTemplate.getForEntity(userServiceUrl , UserHelper2.class );
        String emri = responseEntity.getBody().getDoctorName();
        String mbiemri = responseEntity.getBody().getDoctorSurname();
        int nrpersonal3 = doctorPersonalNumber;

        return new DoctorEntity(emri,mbiemri,nrpersonal3);
    }




}
