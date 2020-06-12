package clinic.mappers;

import clinic.model.Speciality;
import clinic.model.Treatment;

import java.util.HashSet;
import java.util.Set;

public class ProviderDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private Speciality speciality;
    private Set<Long> treatments = new HashSet<>();

    public ProviderDTO(Long id, String firstName, String lastName, Speciality speciality, Set<Long> treatments) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.speciality = speciality;
        this.treatments = treatments;
    }

    public ProviderDTO(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public Set<Long> getTreatments() {
        return treatments;
    }

    public void setTreatments(Set<Long> treatments) {
        this.treatments = treatments;
    }
}
