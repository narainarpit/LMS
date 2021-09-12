package com.example.lms.dataloader;

import com.example.lms.domain.Brand;
import com.example.lms.domain.BrandVariant;
import com.example.lms.domain.Contact;
import com.example.lms.domain.Leads;
import com.example.lms.repository.BrandRepo;
import com.example.lms.repository.BrandVariantRepo;
import com.example.lms.repository.ContactRepo;
import com.example.lms.repository.LeadsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class Dataloader implements ApplicationRunner {

	@Autowired
	private BrandRepo brandRepo;
	@Autowired
	private BrandVariantRepo brandVariantRepo;
	@Autowired
	private ContactRepo contactRepo;
	@Autowired
	private LeadsRepo leadsRepo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Started data loading ....");
		//delete all objects
		brandVariantRepo.deleteAll();
		brandRepo.deleteAll();
		contactRepo.deleteAll();
		leadsRepo.deleteAll();
		// Add brands
		List<String> brandNames =
					new ArrayList<>(Arrays.asList("Volkswagen","Kia","Cadillac","BMW"));
		List<Brand> brands = new ArrayList<>();
		brandNames.forEach(element -> brands.add(new Brand(element)));
		brandRepo.saveAll(brands);

		Brand brandVolkswagen = brandRepo.findByName("Volkswagen");
		Brand brandKia = brandRepo.findByName("Kia");
		Brand brandCadillac = brandRepo.findByName("Cadillac");
		Brand brandBmw = brandRepo.findByName("BMW");

		//Add brand variant

		List<List<String>> brandVariantsData = new ArrayList<>();
		brandVariantsData.add(Arrays.asList("1-Series", "BMW", "1975-01-01","Subcompact car", "Germany"));
		brandVariantsData.add(Arrays.asList("2-Series", "BMW", "1985-01-01","Compact car", "Germany"));
		brandVariantsData.add(Arrays.asList("3-Series, M3", "BMW", "1990-01-01","Subcompact car", "Germany"));
		brandVariantsData.add(Arrays.asList("Series 61", "Cadillac", "2013-01-01","Mid-size car", "US"));
		brandVariantsData.add(Arrays.asList("Seville", "Cadillac", "1976-01-01","Subcompact car", "US"));
		brandVariantsData.add(Arrays.asList("Golf", "Volkswagen", "1994-01-01","Subcompact car", "Germany"));
		brandVariantsData.add(Arrays.asList("Parati", "Volkswagen", "1994-01-01","Subcompact car", "Germany"));
		brandVariantsData.add(Arrays.asList("Pointer", "Volkswagen", "1994-01-01","Subcompact car", "Germany"));

		List<BrandVariant> brandVariants = new ArrayList<>();
		brandVariantsData.forEach(element -> {
			BrandVariant brandVariant = new BrandVariant();
			if (element.get(1).equals("BMW")){
				brandVariant.setBrand(brandBmw);
			}else if(element.get(1).equals("Cadillac")){
				brandVariant.setBrand(brandCadillac);
			}else{
				brandVariant.setBrand(brandVolkswagen);
			}
			brandVariant.setName(element.get(0));
			brandVariant.setCountryOfOrigin(element.get(4));
			brandVariant.setProductionYear(Date.valueOf(element.get(2)));
			brandVariant.setClassification(element.get(3));
			brandVariants.add(brandVariant);
		});
		brandVariantRepo.saveAll(brandVariants);

		//Contacts
		List<List<String>> contactsData = new ArrayList<>();
		contactsData.add(Arrays.asList("John", "Smith", "johnsmith@test.com","0458595959", "9 James Street, US"));
		contactsData.add(Arrays.asList("Adria", "Gosh", "agosh@test.com", "0458595959", "9 Queen Street, India"));
		contactsData.add(Arrays.asList("Arya", "odak", "aryaodak@test.com", "0458595959", "9 King Street, US"));
		contactsData.add(Arrays.asList("Samuel", "Zuckerman", "samuelzuckerman@test.com", "0458595959", "9 John Street, US"));

		List<Contact> contacts = new ArrayList<>();
		contactsData.forEach(element -> {
			contacts.add(new Contact(element.get(0),element.get(1),element.get(4),element.get(2), element.get(4)));
		});
		contactRepo.saveAll(contacts);

		//leads
		List<Leads> leads = new ArrayList<>();
		Contact contactArya = contactRepo.findByEmail("aryaodak@test.com");
		BrandVariant brandVariant2Series = brandVariantRepo.findByName("2-Series");
		Leads leadArya = new Leads(contactArya.getName(),contactArya,brandVariant2Series);
		leads.add(leadArya);

		Contact contactJohn = contactRepo.findByEmail("johnsmith@test.com");
		BrandVariant brandVariantGolf = brandVariantRepo.findByName("Golf");
		Leads leadJohn = new Leads(contactJohn.getName(),contactJohn,brandVariantGolf);
		leads.add(leadJohn);

		Contact contactAdria= contactRepo.findByEmail("aryaodak@test.com");
		BrandVariant brandVariantAdria = brandVariantRepo.findByName("Series 61");
		Leads leadAdria = new Leads(contactAdria.getName(),contactAdria,brandVariantAdria);
		leads.add(leadAdria);

		leadsRepo.saveAll(leads);
	}
}
