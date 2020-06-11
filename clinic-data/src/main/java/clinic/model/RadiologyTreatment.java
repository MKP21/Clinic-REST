package clinic.model;

import org.springframework.data.jpa.repository.Temporal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RadiologyTreatment extends Treatment {
    @ElementCollection
    private List<LocalDate> dates = new ArrayList<LocalDate>();

    public List<LocalDate> getDates() {
        return dates;
    }

    public void setDates(List<LocalDate> dates) {
        this.dates = dates;
    }
}
