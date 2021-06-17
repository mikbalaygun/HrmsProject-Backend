package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;
	
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		this.jobAdvertisementDao = jobAdvertisementDao;
	}
	
	
	

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(),"Job Advertisements listed.");
	}

	
	
	@Override
	public DataResult<List<JobAdvertisement>> getByActivated() {
	
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActivated(true),"Activated Advertisements listed.");
	}
	
	
	
	@Override
	public DataResult<List<JobAdvertisement>> getByNoActivated() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActivated(false),"No Activated Advertisements listed.");
	}

	
	@Override
	public DataResult<List<JobAdvertisement>> getByActivatedAndEmployerId(int employerId) {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActivatedAndEmployer_EmployerId(true, employerId));
	}




	@Override
	public DataResult<List<JobAdvertisement>> getByActivatedAndEmployerName(String employerName) {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActivatedAndEmployerName(true, employerName));
	}
	
	
	
	@Override
	public DataResult<List<JobAdvertisement>> getByActivatedAndSortedCreatedDateDesc() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveOrderByCreatedDateDesc(true),"Activated Advertisements sorted by created date.");
	}

	
	
	@Override
	public Result add(JobAdvertisement jobAdvertisement) {

		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Job Advertisement Added.");
	}





}
