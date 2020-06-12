package clinic.mappers;

import clinic.model.Patient;
import clinic.model.Provider;
import clinic.model.TreatmentType;

public class DrugTreatmentDTO extends TreatmentDTO{
    private String drug;
    private String dosage;

    public DrugTreatmentDTO( Long id,PatientDTO patient, ProviderDTO provider, String diagnosis, String drug, String dosage) {
        super( id,patient, provider, diagnosis, TreatmentType.DRUGTREATMENT);
        this.drug = drug;
        this.dosage = dosage;
    }

    public DrugTreatmentDTO(){
        super();
    }

    public String getDrug() {
        return drug;
    }

    public void setDrug(String drug) {
        this.drug = drug;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }
}
