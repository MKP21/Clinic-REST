package clinic.services;

import clinic.mappers.Mapper;
import clinic.mappers.ProviderDTO;
import clinic.model.Provider;
import clinic.repositories.ProviderRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProviderService implements CrudService<ProviderDTO,Long> {
    private final ProviderRepository providerRepository;
    private final Mapper mapper;

    public ProviderService(ProviderRepository providerRepository, Mapper mapper) {
        this.providerRepository = providerRepository;
        this.mapper = mapper;
    }

    @Override
    public Set<ProviderDTO> findAll() {
        List<Provider> providers = providerRepository.findAll();
        Set<ProviderDTO> dtos = new HashSet<>();
        for(Provider p:providers){
            dtos.add(mapper.providerToDto(p));
        }
        return dtos;
    }

    @Override
    public ProviderDTO findById(Long aLong) {
        Provider p = providerRepository.findById(aLong).orElse(null);
        if(p == null){
            return null;
        }else{
            return mapper.providerToDto(p);
        }
    }

    @Override
    public ProviderDTO save(ProviderDTO object) {
        Provider p = mapper.dtoToProvider(object);
        Provider ret = providerRepository.save(p);
        return mapper.providerToDto(ret);
    }

    @Override
    public void delete(ProviderDTO object) {
        providerRepository.delete(mapper.dtoToProvider(object));
    }

    @Override
    public void deleteById(Long aLong) {
        providerRepository.deleteById(aLong);
    }
}
