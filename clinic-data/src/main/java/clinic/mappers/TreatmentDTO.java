package clinic.mappers;

import clinic.model.Patient;
import clinic.model.Provider;
import clinic.model.TreatmentType;

import javax.persistence.*;
import java.time.LocalDate;

public class TreatmentDTO {
    private Patient patient;
    private Provider provider;
    private String diagnosis;
    private TreatmentType treatmentType;

    public TreatmentDTO(Patient patient, Provider provider, String diagnosis, TreatmentType treatmentType) {

        this.patient = patient;
        this.provider = provider;
        this.diagnosis = diagnosis;
        this.treatmentType = treatmentType;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public TreatmentType getTreatmentType() {
        return treatmentType;
    }

    public void setTreatmentType(TreatmentType treatmentType) {
        this.treatmentType = treatmentType;
    }
}
