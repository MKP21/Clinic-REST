package clinic.bootstrap;

import clinic.mappers.Mapper;
import clinic.mappers.PatientDTO;
import clinic.model.*;
import clinic.services.PatientService;
import clinic.services.ProviderService;
import clinic.services.TreatmentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;

@Component
public class DataLoader implements CommandLineRunner {
    private final PatientService patientService;
    private final ProviderService providerService;
    private final TreatmentService treatmentService;
    private final Mapper mapper;

    public DataLoader(PatientService patientService, ProviderService providerService, TreatmentService treatmentService, Mapper mapper) {
        this.patientService = patientService;
        this.providerService = providerService;
        this.treatmentService = treatmentService;
        this.mapper = mapper;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = patientService.findAll().size();

        if (count == 0 ){
            loadData();
        }
    }

    private void loadData(){
        System.out.println("Creating patients");
        PatientDTO tony = new PatientDTO();
        tony.setFirstName("Tony");
        tony.setLastName("Stark");
        PatientDTO savedtony = patientService.save(tony);

//        Patient steve = new Patient();
//        steve.setLastName("Rogers");
//        steve.setFirstName("Steve");
//        Patient savedsteve = patientService.save(steve);
//
//
//        System.out.println("Creating provider");
//        Provider banner = new Provider();
//        banner.setFirstName("Bruce");
//        banner.setLastName("Banner");
//        banner.setSpeciality(Speciality.RADIOLOGIST);
//        Provider savedbanner = providerService.save(banner);
//
//        Provider strange = new Provider();
//        strange.setFirstName("Doctor");
//        strange.setLastName("Strange");
//        strange.setSpeciality(Speciality.SURGEON);
//        Provider savedstrange = providerService.save(strange);
//
//
//        System.out.println("Creating Treatments");
//        DrugTreatment treatment1 = new DrugTreatment();
//        treatment1.setTreatmentType(TreatmentType.DRUGTREATMENT);
//        treatment1.setDiagnosis("Cancer");
//        treatment1.setProvider(savedbanner);
//        treatment1.setPatient(savedtony);
//        treatment1.setDrug("CXQc");
//        treatment1.setDosage("1 mm");
//        Treatment savedt1 = treatmentService.save(treatment1);
//
//        savedtony.getTreatments().add(savedt1);
//        savedbanner.getTreatments().add(savedt1);
//
//        patientService.save(savedtony);
//        providerService.save(savedbanner);
//        treatmentService.save(savedt1);
//
//        RadiologyTreatment treatment2 = new RadiologyTreatment();
//        treatment2.setTreatmentType(TreatmentType.RADIOLOGYTREATMENT);
//        treatment2.setProvider(savedstrange);
//        treatment2.setPatient(savedsteve);
//        treatment2.setDiagnosis("COVID-19");
//        treatment2.getDates().add(LocalDate.now());
//        treatment2.getDates().add(LocalDate.now(ZoneId.of("Europe/Paris")));
//        Treatment savedt2 = treatmentService.save(treatment2);
//
//        savedsteve.getTreatments().add(savedt2);
//        savedstrange.getTreatments().add(savedt2);
//        patientService.save(savedsteve);
//        providerService.save(savedstrange);
//
//        System.out.println("Persisted...");
    }
}
