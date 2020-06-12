package clinic.mappers;

import clinic.model.Patient;
import clinic.model.Provider;
import clinic.model.RadiologyTreatment;
import clinic.model.TreatmentType;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class RadiologyTreatmentDTO extends TreatmentDTO {
    private List<Date> dates;

    public RadiologyTreatmentDTO(Long id, PatientDTO patient, ProviderDTO provider, String diagnosis, List<Date> dates) {
        super(id,patient, provider, diagnosis, TreatmentType.RADIOLOGYTREATMENT);
        this.dates = dates;
    }

    public RadiologyTreatmentDTO(){
        super();
    }
    public List<Date> getDates() {
        return dates;
    }

    public void setDates(List<Date> dates) {
        this.dates = dates;
    }
}
