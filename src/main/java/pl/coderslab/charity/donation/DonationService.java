package pl.coderslab.charity.donation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DonationService {

    private DonationRepository donationRepository;

    @Autowired
    public DonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    public int getTotalDonationQuantity(){
        return donationRepository.sumQuantityOfDonations();
    }

    public List<Donation> getAllDonations(){
        return donationRepository.findAll();
    }
}
