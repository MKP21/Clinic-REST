package clinic.mappers;

import clinic.model.*;
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

    public DrugTreatmentDTO drugToDTO(DrugTreatment drugTreatment){
        return new DrugTreatmentDTO(drugTreatment.getId(),patientToDto(drugTreatment.getPatient()),
                providerToDto(drugTreatment.getProvider()),
                drugTreatment.getDiagnosis(),
                drugTreatment.getDrug(),
                drugTreatment.getDosage());
    }

    public DrugTreatment dtoToDrug(DrugTreatmentDTO drugTreatmentDTO){
        DrugTreatment d = new DrugTreatment();
        d.setId(drugTreatmentDTO.getId());
        d.setDosage(drugTreatmentDTO.getDosage());
        d.setDrug(drugTreatmentDTO.getDrug());
        d.setDiagnosis(drugTreatmentDTO.getDiagnosis());
        d.setPatient(dtoToPatient(drugTreatmentDTO.getPatient()));
        d.setProvider(dtoToProvider(drugTreatmentDTO.getProvider()));
        d.setTreatmentType(drugTreatmentDTO.getTreatmentType());
        return d;
    }

    public RadiologyTreatmentDTO radToDTO(RadiologyTreatment radiologyTreatment){
        return new RadiologyTreatmentDTO(radiologyTreatment.getId(),patientToDto(radiologyTreatment.getPatient()),
                providerToDto(radiologyTreatment.getProvider()),
                radiologyTreatment.getDiagnosis(),
                radiologyTreatment.getDates());
    }

    public RadiologyTreatment dtoToRad(RadiologyTreatmentDTO radiologyTreatmentDTO){
        RadiologyTreatment d = new RadiologyTreatment();
        d.setId(radiologyTreatmentDTO.getId());
        d.setDates(radiologyTreatmentDTO.getDates());
        d.setDiagnosis(radiologyTreatmentDTO.getDiagnosis());
        d.setPatient(dtoToPatient(radiologyTreatmentDTO.getPatient()));
        d.setProvider(dtoToProvider(radiologyTreatmentDTO.getProvider()));
        d.setTreatmentType(radiologyTreatmentDTO.getTreatmentType());
        return d;
    }

    public SurgeryTreatmentDTO surgToDTO(SurgeryTreatment surgeryTreatment){
        return new SurgeryTreatmentDTO(surgeryTreatment.getId(),patientToDto(surgeryTreatment.getPatient()),
                providerToDto(surgeryTreatment.getProvider()),
                surgeryTreatment.getDiagnosis(),
                surgeryTreatment.getDate());
    }

    public SurgeryTreatment dtoToSurg(SurgeryTreatmentDTO surgeryTreatmentDTO){
        SurgeryTreatment d = new SurgeryTreatment();
        d.setId(surgeryTreatmentDTO.getId());
        d.setDate(surgeryTreatmentDTO.getDate());
        d.setDiagnosis(surgeryTreatmentDTO.getDiagnosis());
        d.setPatient(dtoToPatient(surgeryTreatmentDTO.getPatient()));
        d.setProvider(dtoToProvider(surgeryTreatmentDTO.getProvider()));
        d.setTreatmentType(surgeryTreatmentDTO.getTreatmentType());
        return d;
    }

    public TreatmentDTO tretToDto(Treatment treatment){
        if(treatment.getTreatmentType() == TreatmentType.DRUGTREATMENT){
            return drugToDTO((DrugTreatment)treatment);
        }else if(treatment.getTreatmentType() == TreatmentType.RADIOLOGYTREATMENT){
            return radToDTO((RadiologyTreatment)treatment);
        }else{
            return surgToDTO((SurgeryTreatment)treatment);
        }
    }

    public Treatment dtoToTret(TreatmentDTO treatmentDTO){
        if(treatmentDTO.getTreatmentType() == TreatmentType.DRUGTREATMENT){
            return dtoToDrug((DrugTreatmentDTO) treatmentDTO);
        }else if(treatmentDTO.getTreatmentType() == TreatmentType.RADIOLOGYTREATMENT) {
            return dtoToRad((RadiologyTreatmentDTO) treatmentDTO);
        }else {
            return dtoToSurg((SurgeryTreatmentDTO)treatmentDTO);
        }
    }

}
