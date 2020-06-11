package clinic.mappers;

import clinic.model.Patient;
import clinic.model.Provider;
import clinic.model.TreatmentType;

import java.time.LocalDate;
import java.util.List;

public class RadiologyTreatmentDTO extends TreatmentDTO {
    private List<LocalDate> dates;

    public RadiologyTreatmentDTO( Patient patient, Provider provider, String diagnosis, TreatmentType treatmentType, List<LocalDate> dates) {
        super(patient, provider, diagnosis, treatmentType);
        this.dates = dates;
    }

    public List<LocalDate> getDates() {
        return dates;
    }

    public void setDates(List<LocalDate> dates) {
        this.dates = dates;
    }
}
