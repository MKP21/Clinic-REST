package clinic.mappers;

import clinic.model.Patient;
import clinic.model.Provider;
import clinic.model.TreatmentType;

import java.time.LocalDate;

public class SurgeryTreatmentDTO extends TreatmentDTO{
    private LocalDate date;

    public SurgeryTreatmentDTO(Patient patient, Provider provider, String diagnosis, TreatmentType treatmentType, LocalDate date) {
        super( patient, provider, diagnosis, treatmentType);
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
