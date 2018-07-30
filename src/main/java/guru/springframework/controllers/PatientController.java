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

    public void setPatientConversion(PatientConversion patientConversion) {
        this.patientConversion = patientConversion;
    }

//<<<<<<< HEAD
//    @RequestMapping("/patient")
//    public String newPatient(Model model){
//        model.addAttribute("patient", new Patient());
//        System.out.println("我心态崩了");
//        return "patientform";
//    }

//    @RequestMapping(value = "/patient", method = RequestMethod.POST)
//    public String saveProduct(Patient patient){
//        return "";
//    }

    @RequestMapping("/patient/{id}")
    public String convertPatient(@PathVariable Long id){
        RetrieveData temp = new RetrieveData("http://localhost:8080/api/patients/"+id);
        System.out.println(temp.ConvertResponse());
//        model.addAttribute("patient", temp.ConvertResponse());
        System.out.println("我心态崩了aaaaaaa");

        return "index";
    }

    @RequestMapping("patient")
    public String newProduct(Model model, Integer id){
        model.addAttribute("patient", new Patient());
        RetrieveData temp = new RetrieveData("http://localhost:8080/api/patients/"+id);
        model.addAttribute("patientresource",temp.ConvertResponse());
        return "patientform";
    }


}
