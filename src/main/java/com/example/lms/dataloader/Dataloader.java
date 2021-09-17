package com.example.lms.dataloader;

import com.example.lms.domain.*;
import com.example.lms.repository.*;
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
	private LeadRepo leadRepo;
	@Autowired
	private OpportunityRepo opportunityRepo;
	@Autowired
	private RequestTypeRepo requestTypeRepo;
	@Autowired
	private LeadStatusRepo leadStatusRepo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Started data loading ....");
		//delete all objects

		requestTypeRepo.deleteAll();
		brandVariantRepo.deleteAll();
		brandRepo.deleteAll();
		contactRepo.deleteAll();
		opportunityRepo.deleteAll();
		leadRepo.deleteAll();
		leadStatusRepo.deleteAll();

		//Add request Types
		List<List<String>> requestTypeNames =
				new ArrayList<>();
		requestTypeNames.add(Arrays.asList("Brochure_Request", "Brochure Request"));
		requestTypeNames.add(Arrays.asList("Test_Drive", "Test Drive"));
		requestTypeNames.add(Arrays.asList("Registration_of_Interest", "Registration of Interest"));
		requestTypeNames.add(Arrays.asList("Request_for_Information", "Request for Information"));
		List<RequestType> requestTypes = new ArrayList<>();
		requestTypeNames.forEach(element ->
				requestTypes.add(new RequestType(element.get(0), element.get(1))));
		requestTypeRepo.saveAll(requestTypes);

		//Add Lead Status
		List<List<String>> leadStatusNames =
				new ArrayList<>();
		leadStatusNames.add(Arrays.asList("New", "New"));
		leadStatusNames.add(Arrays.asList("Accepted", "Accepted"));
		leadStatusNames.add(Arrays.asList("In_Progress", "In Progress"));
		leadStatusNames.add(Arrays.asList("Closed", "Closed"));
		List<LeadStatus> leadStatuses = new ArrayList<>();
		leadStatusNames.forEach(element ->
				leadStatuses.add(new LeadStatus(element.get(0), element.get(1))));
		leadStatusRepo.saveAll(leadStatuses);

		// Add brands
		List<String> brandNames =
				new ArrayList<>(Arrays.asList("Volkswagen", "Kia", "Cadillac", "BMW"));
		List<Brand> brands = new ArrayList<>();
		brandNames.forEach(element -> brands.add(new Brand(element)));
		brandRepo.saveAll(brands);

		Brand brandVolkswagen = brandRepo.findByName("Volkswagen");
		Brand brandKia = brandRepo.findByName("Kia");
		Brand brandCadillac = brandRepo.findByName("Cadillac");
		Brand brandBmw = brandRepo.findByName("BMW");

		//Add brand variant

		List<List<String>> brandVariantsData = new ArrayList<>();
		brandVariantsData.add(Arrays.asList("1-Series", "BMW", "1975-01-01", "Subcompact car", "Germany"));
		brandVariantsData.add(Arrays.asList("2-Series", "BMW", "1985-01-01", "Compact car", "Germany"));
		brandVariantsData.add(Arrays.asList("3-Series, M3", "BMW", "1990-01-01", "Subcompact car", "Germany"));
		brandVariantsData.add(Arrays.asList("Series 61", "Cadillac", "2013-01-01", "Mid-size car", "US"));
		brandVariantsData.add(Arrays.asList("Seville", "Cadillac", "1976-01-01", "Subcompact car", "US"));
		brandVariantsData.add(Arrays.asList("Golf", "Volkswagen", "1994-01-01", "Subcompact car", "Germany"));
		brandVariantsData.add(Arrays.asList("Parati", "Volkswagen", "1994-01-01", "Subcompact car", "Germany"));
		brandVariantsData.add(Arrays.asList("Pointer", "Volkswagen", "1994-01-01", "Subcompact car", "Germany"));

		List<BrandVariant> brandVariants = new ArrayList<>();
		brandVariantsData.forEach(element -> {
			BrandVariant brandVariant = new BrandVariant();
			if (element.get(1).equals("BMW")) {
				brandVariant.setBrand(brandBmw);
			} else if (element.get(1).equals("Cadillac")) {
				brandVariant.setBrand(brandCadillac);
			} else {
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
		contactsData.add(Arrays.asList("John", "Smith", "johnsmith@test.com", "0458595959", "9 James Street, US"));
		contactsData.add(Arrays.asList("Adria", "Gosh", "agosh@test.com", "0458595959", "9 Queen Street, India"));
		contactsData.add(Arrays.asList("Arya", "odak", "aryaodak@test.com", "0458595959", "9 King Street, US"));
		contactsData.add(Arrays.asList("Samuel", "Zuckerman", "samuelzuckerman@test.com", "0458595959", "9 John Street, US"));

		List<Contact> contacts = new ArrayList<>();
		contactsData.forEach(element -> {
			contacts.add(new Contact(element.get(0), element.get(1), element.get(2), element.get(3), element.get(4)));
		});
		contactRepo.saveAll(contacts);

		//opportunity
		List<List<String>> opportunityData = new ArrayList<>();
		opportunityData.add(Arrays.asList("John Smith"));
		opportunityData.add(Arrays.asList("Adria Gosh"));
		opportunityData.add(Arrays.asList("Arya Odak"));
		opportunityData.add(Arrays.asList("Samuel Zuckerman"));

		List<Opportunity> opportunities = new ArrayList<>();
		opportunityData.forEach(element -> {
			opportunities.add(new Opportunity(element.get(0)));
		});
		opportunityRepo.saveAll(opportunities);

		//leads
		List<Lead> leads = new ArrayList<>();
		Contact contactArya = contactRepo.findByEmail("aryaodak@test.com");
		BrandVariant brandVariant2Series = brandVariantRepo.findByName("2-Series");
		Lead leadArya = new Lead(contactArya.getName(), contactArya, brandVariant2Series);
		leadArya.setOpportunity(opportunityRepo.findByName("Arya Odak"));
		leadArya.setRequestType(requestTypeRepo.findByValue("Brochure_Request"));
		leadArya.setLeadStatus(leadStatusRepo.findByValue("New"));
		leadArya.setSource("Website");
		leads.add(leadArya);

		Contact contactJohn = contactRepo.findByEmail("johnsmith@test.com");
		BrandVariant brandVariantGolf = brandVariantRepo.findByName("Golf");
		Lead leadJohn = new Lead(contactJohn.getName(), contactJohn, brandVariantGolf);
		leadJohn.setOpportunity(opportunityRepo.findByName("John Smith"));
		leadJohn.setRequestType(requestTypeRepo.findByValue("Test_Drive"));
		leadJohn.setLeadStatus(leadStatusRepo.findByValue("Accepted"));
		leadJohn.setSource("Facebook");
		leads.add(leadJohn);

		Contact contactAdria = contactRepo.findByEmail("agosh@test.com");
		BrandVariant brandVariantAdria = brandVariantRepo.findByName("Series 61");
		Lead leadAdria = new Lead(contactAdria.getName(), contactAdria, brandVariantAdria);
		leadAdria.setOpportunity(opportunityRepo.findByName("Adria Gosh"));
		leadAdria.setRequestType(requestTypeRepo.findByValue("Registration_of_Interest"));
		leadAdria.setLeadStatus(leadStatusRepo.findByValue("In_Progress"));
		leadAdria.setSource("Call Centre");
		leads.add(leadAdria);


		Contact contactSamuel = contactRepo.findByEmail("samuelzuckerman@test.com");
		BrandVariant brandVariantSamuel = brandVariantRepo.findByName("Seville");
		Lead leadSamuel = new Lead(contactSamuel.getName(), contactSamuel, brandVariantSamuel);
		leadSamuel.setOpportunity(opportunityRepo.findByName("Samuel Zuckerman"));
		leadSamuel.setRequestType(requestTypeRepo.findByValue("Request_for_Information"));
		leadSamuel.setLeadStatus(leadStatusRepo.findByValue("Closed"));
		leadSamuel.setSource("Newspaper");
		leads.add(leadSamuel);

		leadRepo.saveAll(leads);

		//update latest lead for opportunity
		List<Opportunity> opportunityList = opportunityRepo.findAll();
		opportunityList.forEach(e -> e.setLatestLead(leadRepo.findByName(e.getName())));
		opportunityRepo.saveAll(opportunityList);

	}
}
