package clinic.mappers;

import clinic.model.Patient;
import clinic.model.Provider;
import clinic.model.TreatmentType;

import java.time.LocalDate;
import java.util.List;

public class RadiologyTreatmentDTO extends TreatmentDTO {
    private List<LocalDate> dates;

    public RadiologyTreatmentDTO(Long id, PatientDTO patient, ProviderDTO provider, String diagnosis, List<LocalDate> dates) {
        super(id,patient, provider, diagnosis, TreatmentType.RADIOLOGYTREATMENT);
        this.dates = dates;
    }

    public List<LocalDate> getDates() {
        return dates;
    }

    public void setDates(List<LocalDate> dates) {
        this.dates = dates;
    }
}
