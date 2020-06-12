package clinic.mappers;

import clinic.model.Patient;
import clinic.model.Treatment;

import java.util.HashSet;
import java.util.Set;

public class PatientDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private Set<Long> treatments = new HashSet<>();

    // Constructor 1
    public PatientDTO(Long id, String firstName, String lastName, Set<Long> treatments) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.treatments = treatments;
    }

    // Constructor 2
    public PatientDTO(){

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

    public Set<Long> getTreatments() {
        return treatments;
    }

    public void setTreatments(Set<Long> treatments) {
        this.treatments = treatments;
    }
}
