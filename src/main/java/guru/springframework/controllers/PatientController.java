package guru.springframework.controllers;


import guru.springframework.domain.Patient;
import org.springframework.stereotype.Controller;
import guru.springframework.conversion.PatientConversion;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import guru.springframework.conversion.RetrieveData;

@Controller
public class PatientController {
    private PatientConversion patientConversion;
    private RetrieveData temp = new RetrieveData();

    private String defaultUrl="http://localhost:8080/api/search/patients?";
    private String getAllUrl="http://localhost:8080/api/patients";
    private String queryUrl = "";
    public void setPatientConversion(PatientConversion patientConversion) {
        this.patientConversion = patientConversion;
    }


    @RequestMapping("/patient")
    public String newProduct(Model model, String birthdate, String email, String family, String gender, String given, String identifier, String name){
        model.addAttribute("patient", new Patient());
        System.out.println(birthdate);

        String url = defaultUrl;
        if(birthdate != null && !birthdate.equals("")){
            url = url+"birthdate="+birthdate+"&";
        }
        if (email != null && !email.equals("")){
            url = url+"email="+email+"&";
        }
        if (family != null && !family.equals("")){
            url = url+"family="+family+"&";
        }
        if (gender != null && !gender.equals("")){
            url = url+"gender="+gender+"&";
        }
        if (given != null && !given.equals("")){
            url = url+"given="+given+"&";
        }
        if (identifier != null && !identifier.equals("")){
            url = url+"identifier="+identifier+"&";
        }
        if (name != null && !name.equals("")){
            url = url+"name="+name+"&";
        }

        url= url.substring(0,url.length()-1);
        System.out.println(url);


        temp.setUrl(url);
        model.addAttribute("patientresource",temp.convertPatient());
        
        return "patientform";
    }


}
