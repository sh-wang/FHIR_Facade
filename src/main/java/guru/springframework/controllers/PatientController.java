package guru.springframework.controllers;

import guru.springframework.domain.Patient;
import guru.springframework.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import guru.springframework.conversion.PatientConvertion;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PatientController {
    private PatientConvertion patientConvertion;

    public void setPatientConvertion(PatientConvertion patientConvertion) {
        this.patientConvertion = patientConvertion;
    }

    @RequestMapping("/patient/new")
    public String newPatient(Model model){
        model.addAttribute("patient", new Patient());
        System.out.println(this);
        return "patientform";
    }

    @RequestMapping(value = "/patient", method = RequestMethod.POST)
        public String saveProduct(Patient patient){

        System.out.println(patient.toString());

        return "";
    }
}
