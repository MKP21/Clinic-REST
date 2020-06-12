package clinic.mappers;

import clinic.model.Patient;
import clinic.model.Provider;
import clinic.model.TreatmentType;

import java.time.LocalDate;
import java.util.Date;

public class SurgeryTreatmentDTO extends TreatmentDTO{
    private Date date;

    public SurgeryTreatmentDTO(Long id,PatientDTO patient, ProviderDTO provider, String diagnosis, Date date) {
        super( id,patient, provider, diagnosis, TreatmentType.SURGERYTREATMENT);
        this.date = date;
    }

    public SurgeryTreatmentDTO(){
        super();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
