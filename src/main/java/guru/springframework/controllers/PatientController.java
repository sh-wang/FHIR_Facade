package guru.springframework.controllers;


import guru.springframework.domain.Patient;
import org.springframework.stereotype.Controller;
import guru.springframework.conversion.PatientConversion;
import org.springframework.ui.Model;
import guru.springframework.conversion.PatientConversion;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import guru.springframework.conversion.RetrieveData;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PatientController {
    private PatientConversion patientConversion;
    private RetrieveData temp = new RetrieveData();
    private String defaultUrl="http://localhost:8080/api/patients?";
    private String queryUrl = "";
    public void setPatientConversion(PatientConversion patientConversion) {
        this.patientConversion = patientConversion;
    }


    @RequestMapping("/patient")
    public String newProduct(Model model, String birthdate, String email, String family, String gender, String given, Long identifier, String name){
        model.addAttribute("patient", new Patient());

        if(birthdate!=null){
            queryUrl = queryUrl + "id="+birthdate;
        }
//        temp.setUrl("http://localhost:8080/api/patients/"+);
        model.addAttribute("patientresource",temp.convertPatient());
        
        return "patientform";
    }


}
