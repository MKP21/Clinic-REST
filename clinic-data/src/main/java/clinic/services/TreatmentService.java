package clinic.services;

import clinic.model.Treatment;
import clinic.repositories.TreatmentRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class TreatmentService implements CrudService<Treatment,Long> {
    private final TreatmentRepository treatmentRepository;

    public TreatmentService(TreatmentRepository treatmentRepository) {
        this.treatmentRepository = treatmentRepository;
    }


    @Override
    public Set<Treatment> findAll() {
        Set<Treatment> treatments = new HashSet<>();
        treatmentRepository.findAll().forEach(treatments::add);
        return null;
    }

    @Override
    public Treatment findById(Long aLong) {
        return treatmentRepository.findById(aLong).orElse(null);
    }

    @Override
    public Treatment save(Treatment object) {
        return treatmentRepository.save(object);
    }

    @Override
    public void delete(Treatment object) {
        treatmentRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        treatmentRepository.deleteById(aLong);
    }
}
