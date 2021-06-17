package kodlamaio.hrms.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.helpers.BusinessRules;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		this.candidateDao = candidateDao;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Adaylar listelendi.");
	}
	
	@Override
	public Result isEmailValid(String email) {
		User user = this.candidateDao.findByEmail(email);
		if(user != null) {
			return new ErrorResult("This email already exists.");
		}
		return new SuccessResult();
		
	}

	@Override
	public Result isIdentityNumberValid(String identityNumber) {
		User user = this.candidateDao.findByIdentityNumber(identityNumber);
		if(user != null) {
			return new ErrorResult("This identity Number already exists.");
		}
		return new SuccessResult();
	}

	
	@Override
	public Result isCandidateValid(Candidate candidate) {
		if(candidate.getEmail() == null || candidate.getEmail().isBlank() || candidate.getPassword() == null ||
				candidate.getPassword().isBlank() || candidate.getFirstName() == null || candidate.getFirstName().isBlank() ||
			    candidate.getLastName() == null || candidate.getLastName().isBlank() || candidate.getIdentityNumber() == null || 
			    candidate.getIdentityNumber().isBlank() || candidate.getBirthOfYear() == null){
				return new ErrorResult("Fields is empty.You cannot leave the fields blank.");
			}
			return new SuccessResult();
	}
	

	@Override
	public Result add(Candidate candidate) {
		
		Result result = BusinessRules.run(this.isCandidateValid(candidate),this.isEmailValid(candidate.getEmail()),this.isIdentityNumberValid(candidate.getIdentityNumber()));
		
		if(!result.isSuccess()) {
			return result;
		}
		
		candidateDao.save(candidate);
		return new SuccessResult("Candidate added.");
		
	}

	


}
