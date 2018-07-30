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
    public String newProduct(Model model, Integer identifier){
        model.addAttribute("qr", new QuestionnaireResponse());
        temp.setUrl("http://localhost:8080/api/Questionnaire-response/"+identifier);
        model.addAttribute("qrsource",temp.convertPatient());
        System.out.println(temp.convertPatient());
        return "qrgetit";
    }
}
