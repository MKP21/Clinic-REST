package clinic.mappers;

import clinic.model.Patient;
import clinic.model.Provider;
import clinic.model.TreatmentType;

public class DrugTreatmentDTO extends TreatmentDTO{
    private String drug;
    private String dosage;

    public DrugTreatmentDTO( Patient patient, Provider provider, String diagnosis, TreatmentType treatmentType, String drug, String dosage) {
        super( patient, provider, diagnosis, treatmentType);
        this.drug = drug;
        this.dosage = dosage;
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
