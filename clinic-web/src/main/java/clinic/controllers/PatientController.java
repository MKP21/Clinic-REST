package clinic.controllers;

import clinic.mappers.Mapper;
import clinic.mappers.PatientDTO;
import clinic.model.Patient;
import clinic.services.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;
    private final Mapper mapper;

    public PatientController(PatientService patientService, Mapper mapper) {
        this.patientService = patientService;
        this.mapper = mapper;
    }

    @GetMapping({"","/"})
    public ResponseEntity<Set<PatientDTO>> getallPatients(){
        return new ResponseEntity<>(patientService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable Long id){
        return new ResponseEntity<>(patientService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PatientDTO> newPatient(@RequestBody PatientDTO patientDTO){
        return new ResponseEntity<>(patientService.save(patientDTO),
                HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDTO> editPatient(@RequestBody PatientDTO patientDTO,@PathVariable Long id){
        PatientDTO old = patientService.findById(id);
        if(old == null){
            patientDTO.setId(id);
            return new ResponseEntity<>(patientService.saveById(id,patientDTO),
                    HttpStatus.CREATED);
        }else{
            old.setFirstName(patientDTO.getFirstName());
            old.setLastName(patientDTO.getLastName());
            old.setTreatments(patientDTO.getTreatments());
            return new ResponseEntity<>(patientService.saveById(id,old), HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Long id){
        patientService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
