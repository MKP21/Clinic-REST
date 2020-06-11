package clinic.controllers;
import clinic.mappers.ProviderDTO;
import clinic.services.ProviderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
public class ProviderController {
    private final ProviderService providerService;

    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @GetMapping({"","/"})
    public ResponseEntity<Set<ProviderDTO>> getAllProviders(){
        return new ResponseEntity<>(providerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProviderDTO> getPatientById(@PathVariable Long id){
        return new ResponseEntity<>(providerService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProviderDTO> newProvider(@RequestBody ProviderDTO providerDTO){
        return new ResponseEntity<>(providerService.save(providerDTO),
                HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProviderDTO> editPatient(@RequestBody ProviderDTO providerDTO,@PathVariable Long id){
        ProviderDTO old = providerService.findById(id);
        if(old == null){
            providerDTO.setId(id);
            return new ResponseEntity<>(providerService.save(providerDTO),
                    HttpStatus.CREATED);
        }else{
            old.setFirstName(providerDTO.getFirstName());
            old.setLastName(providerDTO.getLastName());
            old.setTreatments(providerDTO.getTreatments());
            old.setSpeciality(providerDTO.getSpeciality());
            return new ResponseEntity<>(providerService.findById(id), HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Long id){
        providerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
