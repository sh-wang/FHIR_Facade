package guru.springframework.conversion;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;
import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Procedure;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ProcedureConversion {
    public ProcedureConversion(){ }

    private FhirContext ctx = FhirContext.forDstu3();
    private IParser p =ctx.newJsonParser().setPrettyPrint(true);

    public String conversionSingle(String rawData) throws JSONException {
        JSONObject jsonObject = new JSONObject(rawData);

        Procedure procedure = procedureConversion(jsonObject);
        String encode = p.encodeResourceToString(procedure);

        return encode;
    }

    public String conversionArray(String rawData) throws JSONException {
        JSONArray jsonArray = new JSONArray(rawData);
        JSONArray FHIRarray = new JSONArray();;


        for(int i = 0; i < jsonArray.length(); i++){
            FHIRarray.put(new JSONObject(p.encodeResourceToString
                    (procedureConversion(jsonArray.getJSONObject(i)))));
        }

        return FHIRarray.toString();
    }

    public Procedure procedureConversion(JSONObject jsonObject) throws JSONException {
        Procedure procedure = new Procedure();
        //add id
        procedure.setId(jsonObject.get("id").toString());

        //currently no status data
        procedure.setStatus(Procedure.ProcedureStatus.UNKNOWN);

        CodeableConcept codeableConcept = new CodeableConcept();

        //add localcode as code and add name
        codeableConcept.addCoding().setCode(jsonObject.get("localCode").toString()).
                setDisplay(jsonObject.get("name").toString().substring(1, jsonObject.get("name").toString().length()));
        procedure.setCode(codeableConcept);

        return  procedure;
    }
}
