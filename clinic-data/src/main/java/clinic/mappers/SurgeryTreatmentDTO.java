package clinic.mappers;

import clinic.model.Patient;
import clinic.model.Provider;
import clinic.model.TreatmentType;

import java.time.LocalDate;

public class SurgeryTreatmentDTO extends TreatmentDTO{
    private LocalDate date;

    public SurgeryTreatmentDTO(Long id,PatientDTO patient, ProviderDTO provider, String diagnosis, LocalDate date) {
        super( id,patient, provider, diagnosis, TreatmentType.SURGERYTREATMENT);
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
