package clinic.services;

import clinic.mappers.Mapper;
import clinic.mappers.PatientDTO;
import clinic.model.Patient;
import clinic.repositories.PatientRepository;
import org.springframework.stereotype.Service;

import javax.persistence.MappedSuperclass;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PatientService implements CrudService<PatientDTO,Long> {
    private final PatientRepository patientRepository;
    private final Mapper mapper;

    public PatientService(PatientRepository patientRepository, Mapper mapper) {
        this.patientRepository = patientRepository;
        this.mapper = mapper;
    }

    @Override
    public Set<PatientDTO> findAll() {
        List<Patient> patients = patientRepository.findAll();
        Set<PatientDTO> dtos = new HashSet<>();
        for(Patient p:patients){
            dtos.add(mapper.patientToDto(p));
        }
        return dtos;
    }

    @Override
    public PatientDTO findById(Long aLong) {
        Patient p = patientRepository.findById(aLong).orElse(null);
        if(p != null){
            return mapper.patientToDto(p);
        }else{
            return null;
        }
    }

    @Override
    public PatientDTO save(PatientDTO object) {
        // convert dto to patient
        Patient d = mapper.dtoToPatient(object);
        //save patient
        Patient ret = patientRepository.save(d);
        //return new dto
        return mapper.patientToDto(ret);
    }

    @Override
    public void delete(PatientDTO object) {
        patientRepository.delete(mapper.dtoToPatient(object));
    }

    @Override
    public void deleteById(Long aLong) {
        patientRepository.deleteById(aLong);
    }
}
