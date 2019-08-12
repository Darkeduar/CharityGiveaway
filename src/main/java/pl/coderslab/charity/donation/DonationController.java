package pl.coderslab.charity.donation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.category.CategoryService;
import pl.coderslab.charity.institution.InstitutionService;

@Controller
public class DonationController {

    private DonationService donationService;
    private CategoryService categoryService;
    private InstitutionService institutionService;

    @Autowired
    public DonationController(DonationService donationService, CategoryService categoryService, InstitutionService institutionService) {
        this.donationService = donationService;
        this.categoryService = categoryService;
        this.institutionService = institutionService;
    }


    @GetMapping("/form")
    public String donationForm(Model model){
        model.addAttribute("donation", new DonationDto());
        model.addAttribute( "categories", categoryService.getAllCategories());
        model.addAttribute( "institutions", institutionService.getAllInstitutions());
        return "form";
    }

    @PostMapping("/form")
    public String donationCreation(DonationDto donationDto){
        donationService.createDonation(donationDto);
        return "form-confirmation";
    }
}
