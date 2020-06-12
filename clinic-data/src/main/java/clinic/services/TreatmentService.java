package clinic.services;

import clinic.mappers.Mapper;
import clinic.mappers.TreatmentDTO;
import clinic.model.Treatment;
import clinic.repositories.TreatmentRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TreatmentService implements CrudService<TreatmentDTO,Long> {
    private final TreatmentRepository treatmentRepository;
    private final Mapper mappper;

    public TreatmentService(TreatmentRepository treatmentRepository, Mapper mappper) {
        this.treatmentRepository = treatmentRepository;
        this.mappper = mappper;
    }


    @Override
    public Set<TreatmentDTO> findAll() {
        List<Treatment> tls =treatmentRepository.findAll();
        Set<TreatmentDTO> treatments = new HashSet<>();
        for(Treatment t:tls){
            treatments.add(mappper.tretToDto(t));
        }
        return treatments;
    }

    @Override
    public TreatmentDTO findById(Long aLong) {
        Treatment t = treatmentRepository.findById(aLong).orElse(null);
        if(t!=null){
            return mappper.tretToDto(t);
        }
        return null;
    }

    @Override
    public TreatmentDTO save(TreatmentDTO object) {
        Treatment t = mappper.dtoToTret(object);
        Treatment saved = treatmentRepository.save(t);
        return mappper.tretToDto(saved);
    }

    @Override
    public void delete(TreatmentDTO object) {
        treatmentRepository.delete(mappper.dtoToTret(object));
    }

    @Override
    public void deleteById(Long aLong) {
        treatmentRepository.deleteById(aLong);
    }
}
