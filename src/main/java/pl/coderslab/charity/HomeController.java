package pl.coderslab.charity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.donation.DonationService;
import pl.coderslab.charity.institution.InstitutionService;


@Controller
public class HomeController {

    private DonationService donationService;
    private InstitutionService institutionService;

    @Autowired
    public HomeController(DonationService donationService, InstitutionService institutionService) {
        this.donationService = donationService;
        this.institutionService = institutionService;
    }

    @RequestMapping("/")
    public String homeAction(Model model){
//        model.addAttribute("donationQuantity", donationService.getTotalDonationQuantity());
        model.addAttribute( "institutionList", institutionService.getAllInstitutions());
        return "index";
    }
}
