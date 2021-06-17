package kodlamaio.hrms.business.concretes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.helpers.BusinessRules;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		this.employerDao = employerDao;
	}
	
	
	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Employers listed.");
	}
	
	@Override
	public Result isEmailValid(String email) {
		User user = this.employerDao.findByEmail(email);
		if(user != null) {
			return new ErrorResult("This email already exists.");
		}
		return new SuccessResult();
		
	}
	
	
	@Override
	public Result isDomainValid(String email, String webAddress) {
		String[] webKeywords = {"www","https//www","http//www","com","tr","net"};
		String[] emailDomain = email.split("@");
		String[] webContent = webAddress.split("\\.",2);
		ArrayList<String> webDomain = new ArrayList<String>(); 
		
		for(String key:webContent) {
			webDomain.add(key);
			if(Arrays.asList(webKeywords).contains(key)) {
				webDomain.remove(key);
			}
		}
		
		if(!webDomain.contains(emailDomain[0])) {
			return new ErrorResult("Email and web fields must be same.");
		}
		
		return new SuccessResult();
		
	}
	
	
	@Override
	public Result isEmployerValid(Employer employer) {
		if(employer.getEmail() == null || employer.getEmail().isBlank() || employer.getCompanyName() == null ||
            employer.getCompanyName().isBlank() || employer.getPhoneNumber() == null || employer.getPhoneNumber().isBlank() ||
                employer.getWebAddress() == null || employer.getWebAddress().isBlank()){
			return new ErrorResult("Fields is empty.You cannot leave the fields blank.");
		}
		return new SuccessResult();
	}
	

	@Override
	public Result add(Employer employer) {
		
		
		Result result = BusinessRules.run(this.isEmployerValid(employer),this.isEmailValid(employer.getEmail()),this.isDomainValid(employer.getEmail(), employer.getWebAddress()));
		if(!result.isSuccess()) {
			return result;
		}
		employerDao.save(employer);
		return new SuccessResult("Employer Added.");
		
		
		
		
		
	
	}




	
}
