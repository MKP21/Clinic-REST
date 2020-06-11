package clinic.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Patient extends Person {
    @OneToMany(mappedBy = "patient", cascade= CascadeType.REMOVE, orphanRemoval = true)
    private Set<Treatment> treatments = new HashSet<>();

    public Set<Treatment> getTreatments() {
        return treatments;
    }

    public void setTreatments(Set<Treatment> treatments) {
        this.treatments = treatments;
    }
}
