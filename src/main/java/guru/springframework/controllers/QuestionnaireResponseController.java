package guru.springframework.controllers;

import guru.springframework.conversion.QuestionnaireResponseConversion;
import guru.springframework.conversion.RetrieveData;
import guru.springframework.domain.QuestionnaireResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QuestionnaireResponseController {
    private QuestionnaireResponseConversion questionnaireResponseConversion;


    private RetrieveData temp = new RetrieveData();

    public void setQuestionnaireResponseConversion(QuestionnaireResponseConversion questionnaireResponseConversion) {
        this.questionnaireResponseConversion = questionnaireResponseConversion;
    }

    @RequestMapping("/questionnaireresponse")
    public String newProduct(Model model, Integer identifier
                            , String parent,
                             String questionnaire, String status,
                             String patient, String subject,
                             String authored, String author){

        String defaultUrl="http://localhost:8080/api/Questionnaire-response?";
        model.addAttribute("qr", new QuestionnaireResponse());
        System.out.println("parent:"+parent);
        if(status!=null && !status.equals(",") && !status.equals("")){
            defaultUrl += "status="+status+"&";
        }
        if(parent!=null && !parent.equals(",") && !parent.equals("")){
            defaultUrl += "parent="+parent+"&";
        }
        if(identifier!=null && !identifier.equals(",") && !identifier.equals("")){
            defaultUrl += "identifier="+identifier+"&";
        }
        if(questionnaire!=null && !questionnaire.equals(",") && !questionnaire.equals("")){
            defaultUrl += "questionnaire="+questionnaire+"&";
        }
        if(patient!=null && !patient.equals(",")&& !patient.equals("")){
            defaultUrl += "patient="+patient+"&";
        }
        if(subject!=null && !subject.equals(",") && !subject.equals("")){
            defaultUrl += "subject="+subject+"&";
        }
        if(authored!=null && !authored.equals(",")&& !authored.equals("")){
            defaultUrl += "authored="+authored+"&";
        }
        if(author!=null && !author.equals(",")&& !author.equals("")){
            defaultUrl += "author="+author+"&";
        }

        defaultUrl= defaultUrl.substring(0,defaultUrl.length()-1);
        System.out.println(defaultUrl);
//
        temp.setUrl(defaultUrl);
        System.out.println(temp.convertQuestionnnaireResponse());
        model.addAttribute("qrsource",temp.convertQuestionnnaireResponse());
        return "qrgetit";
    }
}
