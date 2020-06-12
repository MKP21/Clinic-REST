package clinic.bootstrap;

import clinic.mappers.*;
import clinic.model.*;
import clinic.services.PatientService;
import clinic.services.ProviderService;
import clinic.services.TreatmentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Component
public class DataLoader implements CommandLineRunner {
    private final PatientService patientService;
    private final ProviderService providerService;
    private final TreatmentService treatmentService;

    public DataLoader(PatientService patientService, ProviderService providerService, TreatmentService treatmentService, Mapper mapper) {
        this.patientService = patientService;
        this.providerService = providerService;
        this.treatmentService = treatmentService;
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

        PatientDTO steve = new PatientDTO();
        steve.setLastName("Rogers");
        steve.setFirstName("Steve");
        PatientDTO savedsteve = patientService.save(steve);

        System.out.println("Creating providers");
        ProviderDTO banner = new ProviderDTO(null, "Bruce", "Banner", Speciality.RADIOLOGIST, new HashSet<Long>());
        ProviderDTO savedbanner = providerService.save(banner);

        ProviderDTO strange = new ProviderDTO(null, "Doctor", "Strange", Speciality.SURGEON, new HashSet<Long>());
        ProviderDTO savedstrange = providerService.save(strange);

        System.out.println("Creating Treatments");
        DrugTreatmentDTO t1 = new DrugTreatmentDTO(null,savedtony,savedbanner,"Cancer","CXQc","1 mm");
        TreatmentDTO savedt1 = treatmentService.save(t1);

        List<Date> dates = new ArrayList<Date>();
        dates.add(new Date());
        RadiologyTreatmentDTO t2 = new RadiologyTreatmentDTO(null,savedsteve,savedbanner,"Covid-19",dates);
        TreatmentDTO savedt2 = treatmentService.save(t2);

        System.out.println("Persisted...");
    }
}
