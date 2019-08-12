package pl.coderslab.charity.institution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class InstitutionService {

    private InstitutionRepository institutionRepository;

    @Autowired
    public InstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    public List<Institution> getAllInstitutions(){
        return institutionRepository.findAll();
    }

    public void createInstitution(Institution institution){
        institutionRepository.save(institution);
    }

    public void editInstitution(Institution institution){
        institutionRepository.save(institution);
    }

    public Institution getInstitutionById(Long id){
        return institutionRepository.getOne(id);
    }

    public void deleteInstitution(Long id){
        institutionRepository.delete(institutionRepository.getOne(id));
    }
}
