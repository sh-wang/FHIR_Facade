package guru.springframework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import guru.springframework.conversion.PatientConvertion;

@Controller
public class PatientController {
    private PatientConvertion patientConvertion;

    public void setPatientConvertion(PatientConvertion patientConvertion) {
        this.patientConvertion = patientConvertion;
    }
}
