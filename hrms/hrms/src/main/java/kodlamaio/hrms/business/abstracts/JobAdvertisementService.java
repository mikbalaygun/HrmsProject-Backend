package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	
	DataResult<List<JobAdvertisement>> getAll();
	DataResult<List<JobAdvertisement>> getByActivated();
	DataResult<List<JobAdvertisement>> getByNoActivated();
	DataResult<List<JobAdvertisement>> getByActivatedAndEmployerId(int employerId);
	DataResult<List<JobAdvertisement>> getByActivatedAndEmployerName(String employerName);
	DataResult<List<JobAdvertisement>> getByActivatedAndSortedCreatedDateDesc();
	Result add(JobAdvertisement jobAdvertisement);
}
