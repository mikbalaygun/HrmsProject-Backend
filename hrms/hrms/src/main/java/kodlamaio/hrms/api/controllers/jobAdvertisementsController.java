package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("api/jobAdvertisements")
public class jobAdvertisementsController {

	private JobAdvertisementService jobAdvertisementService;
	
	
	@Autowired
	public jobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		this.jobAdvertisementService = jobAdvertisementService;
	}
	

	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll() {
		return this.jobAdvertisementService.getAll();
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	
	@GetMapping("/getByActivated")
	public DataResult<List<JobAdvertisement>> getByActivated() {
		return this.jobAdvertisementService.getByActivated();
	}
	
	
	@GetMapping("/getByNoActivated")
	public DataResult<List<JobAdvertisement>> getByNoActivated() {
		return this.jobAdvertisementService.getByNoActivated();
	}
	
	
	@GetMapping("/getByActivatedAndEmployerId")
	public DataResult<List<JobAdvertisement>> getByActivatedAndEmployerId(@RequestParam int employerId) {
		return this.jobAdvertisementService.getByActivatedAndEmployerId(employerId);
	}
	
	
	@GetMapping("/getByActivatedAndEmployerName")
	public DataResult<List<JobAdvertisement>> getByActivatedAndEmployerName(@RequestParam String employerName) {
		return this.jobAdvertisementService.getByActivatedAndEmployerName(employerName);
	}
	
	
	@GetMapping("/getByActivatedAndSortedCreatedDateDesc")
	public DataResult<List<JobAdvertisement>> getByActivatedAndSortedCreatedDateDesc() {
		return this.jobAdvertisementService.getByActivatedAndSortedCreatedDateDesc();
	}
	
	
	
	
	
	
}
