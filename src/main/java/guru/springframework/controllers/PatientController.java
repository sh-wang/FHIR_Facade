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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PatientController {
    private PatientConversion patientConversion;
    private RetrieveData temp = new RetrieveData();
    private String defaultUrl="http://localhost:8080/api/search/patients?";

    public void setPatientConversion(PatientConversion patientConversion) {
        this.patientConversion = patientConversion;
    }


    @RequestMapping("/patient")
    public String newProduct(Model model, String birthdate, String email, String family, String gender, String given, String identifier, String name){
        model.addAttribute("patient", new Patient());
        System.out.println(birthdate);

//        String url = defaultUrl+ "birthdate="+birthdate+"&"+"email="+email+"&"+"family="+family+"&"+"gender="+gender+"&"+"given="+given+"&"+"identifier="+identifier+"&"+"name="+name;
//        System.out.println(url);
//        Map<String, String> params = new HashMap();
//        params.put("birthdate",birthdate);
//        params.put("email",email);
//        params.put("family",family);
//        params.put("gender",gender);
//        params.put("given",given);
//        params.put("identifier",identifier);
//        params.put("name",name);

//        for(Map.Entry<String, String> entry : params.entrySet()){
//            if (entry!=null){
//                System.out.println("key: "+entry.getKey() + "   value:"+entry.getValue());
//                defaultUrl = defaultUrl + entry.getKey()+"="+entry.getValue()+"&";
//            }
//        }
        String url = defaultUrl;
        if(birthdate!=null){
            url = url+"birthdate="+birthdate+"&";
        }
        else if (email!=null){
            url = url+"email="+email+"&";
        }
        else if (family!=null){
            url = url+"family="+family+"&";
        }
        else if (gender!=null){
            url = url+"gender="+gender+"&";
        }
        else if (given!=null){
            url = url+"given="+given+"&";
        }
        else if (identifier !=null){
            url = url+"identifier="+identifier+"&";
        }
        else if (name!=null){
            url = url+"name="+name+"&";
        }

        url= url.substring(0,url.length()-1);
        System.out.println(url);


        temp.setUrl(url);
        model.addAttribute("patientresource",temp.convertPatient());
        
        return "patientform";
    }


}
