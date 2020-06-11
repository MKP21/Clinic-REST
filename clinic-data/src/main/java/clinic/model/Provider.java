package clinic.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Provider extends Person{

    @Enumerated(EnumType.STRING)
    public Speciality speciality;

    @OneToMany(cascade = CascadeType.REMOVE,  orphanRemoval = true,mappedBy = "provider")
    public Set<Treatment> treatments = new HashSet<>();

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public Set<Treatment> getTreatments() {
        return treatments;
    }

    public void setTreatments(Set<Treatment> treatments) {
        this.treatments = treatments;
    }
}
