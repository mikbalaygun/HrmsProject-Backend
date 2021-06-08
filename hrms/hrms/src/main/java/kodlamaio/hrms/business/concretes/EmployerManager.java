package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		this.employerDao = employerDao;
	}
	
	
	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Isverenler listelendi.");
	}
	
	@Override
	public DataResult<Employer> getByEmail(String email) {
		return new SuccessDataResult<Employer>(this.employerDao.getByEmail(email));
	}
	
	
	@Override
	public boolean employerIsValid(Employer employer) {
		if(Objects.isNull(employer.getEmail()) || Objects.isNull(employer.getPassword()) || Objects.isNull(employer.getCompanyName()) || Objects.isNull(employer.getPhoneNumber()) || 
		Objects.isNull(employer.getWebAddress()) ) {
			return false;
		}
		return true;
	}
	

	@Override
	public Result add(Employer employer) {
		if(this.getByEmail(employer.getEmail()).getData() != null) {
			return new ErrorResult("Bu e-posta adresi mevcut.");
		}
		
		if(!this.employerIsValid(employer)) {
			return new ErrorResult("Eksik bilgi, Alanları boş gecemezsin.");
		}
		
		employerDao.save(employer);
		return new SuccessResult("Isveren eklendi.");
	}


	
}
