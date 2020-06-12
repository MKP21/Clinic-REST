package clinic.mappers;

import clinic.model.Patient;
import clinic.model.Provider;
import clinic.model.TreatmentType;

import javax.persistence.*;
import java.time.LocalDate;

public class TreatmentDTO {
    private Long id;
    private PatientDTO patient;
    private ProviderDTO provider;
    private String diagnosis;
    private TreatmentType treatmentType;

    public TreatmentDTO(Long id,PatientDTO patient, ProviderDTO provider, String diagnosis, TreatmentType treatmentType) {
        this.id = id;
        this.patient = patient;
        this.provider = provider;
        this.diagnosis = diagnosis;
        this.treatmentType = treatmentType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PatientDTO getPatient() {
        return patient;
    }

    public void setPatient(PatientDTO patient) {
        this.patient = patient;
    }

    public ProviderDTO getProvider() {
        return provider;
    }

    public void setProvider(ProviderDTO provider) {
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
