package clinic.mappers;

import clinic.model.Patient;
import clinic.model.Provider;
import clinic.model.Treatment;
import clinic.repositories.PatientRepository;
import clinic.repositories.ProviderRepository;
import clinic.repositories.TreatmentRepository;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class Mapper {
    private final TreatmentRepository treatmentRepository;
    private final ProviderRepository providerRepository;
    private final PatientRepository patientRepository;

    public Mapper(TreatmentRepository treatmentRepository, ProviderRepository providerRepository, PatientRepository patientRepository) {
        this.treatmentRepository = treatmentRepository;
        this.providerRepository = providerRepository;
        this.patientRepository = patientRepository;
    }

    public Patient dtoToPatient(PatientDTO patientDTO){
        Patient p = new Patient();
        p.setId(patientDTO.getId());
        p.setFirstName(patientDTO.getFirstName());
        p.setLastName(patientDTO.getLastName());
        Set<Treatment> treatments = new HashSet<>();
        for(Long id:patientDTO.getTreatments()){
            Treatment t = treatmentRepository.findById(id).orElse(null);
            if(t != null){
                treatments.add(t);
            }
        }
        p.setTreatments(treatments);
        return p;
    }

    public PatientDTO patientToDto(Patient patient){
        Set<Long> treatmentIds = new HashSet<>();
        Set<Treatment> treatmentSet = patient.getTreatments();
        for (Treatment t:treatmentSet){
            treatmentIds.add(t.getId());
        }
        return new PatientDTO(patient.getId(),patient.getFirstName(),patient.getLastName(),treatmentIds);
    }

    public Provider dtoToProvider(ProviderDTO providerDTO){
        Provider pr = new Provider();
        pr.setId(providerDTO.getId());
        pr.setFirstName(providerDTO.getFirstName());
        pr.setLastName(providerDTO.getLastName());
        pr.setSpeciality(providerDTO.getSpeciality());
        Set<Treatment> treatments = new HashSet<>();
        for(Long t: providerDTO.getTreatments()){
            Treatment tr = treatmentRepository.findById(t).orElse(null);
            if(tr != null){
                treatments.add(tr);
            }
        }
        pr.setTreatments(treatments);
        return pr;
    }

    public ProviderDTO providerToDto(Provider provider){
        Set<Long> tids = new HashSet<>();
        for(Treatment t:provider.getTreatments()){
            tids.add(t.getId());
        }
        return new ProviderDTO(provider.getId(),provider.getFirstName(),provider.getLastName(),provider.getSpeciality(),tids);
    }
}
