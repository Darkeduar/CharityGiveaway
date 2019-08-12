package pl.coderslab.charity.donation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.category.Category;
import pl.coderslab.charity.category.CategoryRepository;
import pl.coderslab.charity.institution.Institution;
import pl.coderslab.charity.institution.InstitutionRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class DonationService {

    private DonationRepository donationRepository;
    private CategoryRepository categoryRepository;
    private InstitutionRepository institutionRepository;

    @Autowired
    public DonationService(DonationRepository donationRepository, CategoryRepository categoryRepository, InstitutionRepository institutionRepository) {
        this.donationRepository = donationRepository;
        this.categoryRepository = categoryRepository;
        this.institutionRepository = institutionRepository;
    }

    public int getTotalDonationQuantity(){
        return donationRepository.sumQuantityOfDonations();
    }

    public List<Donation> getAllDonations(){
        return donationRepository.findAll();
    }

    public void createDonation(DonationDto donationDto){
        Institution institution = institutionRepository.getOne(donationDto.getInstitution());
        Set<Category> categories = new HashSet<>();
        long[] categoryIdList = donationDto.getCategories();

        for (long id : categoryIdList) {
            categories.add(categoryRepository.getOne(id));
        }


        LocalDate pickUpDate = LocalDate.parse(donationDto.getPickUpDate());

        LocalTime pickUpTime = LocalTime.parse(donationDto.getPickUpTime());

        Donation donation = new Donation();

        donation.setCategories(categories);
        donation.setInstitution(institution);
        donation.setCity(donationDto.getCity());
        donation.setQuantity(donationDto.getQuantity());
        donation.setStreet(donationDto.getStreet());
        donation.setZipCode(donationDto.getZipCode());
        donation.setPickUpDate(pickUpDate);
        donation.setPickUpTime(pickUpTime);
        donation.setPickUpComment(donationDto.getPickUpComment());

        donationRepository.save(donation);
    }
}
