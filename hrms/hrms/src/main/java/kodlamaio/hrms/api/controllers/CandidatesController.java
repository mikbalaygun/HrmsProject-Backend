package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.concretes.CandidateManager;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;

import java.util.List;

@RestController
@RequestMapping("api/candidates")
public class CandidatesController {
	
	private CandidateManager candidateManager;
	
	@Autowired
	public CandidatesController(CandidateManager candidateManager) {
		this.candidateManager = candidateManager;
	}


	@GetMapping("/getall")
	public DataResult<List<Candidate>> getAll(){
		return this.candidateManager.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Candidate candidate) {
		return this.candidateManager.add(candidate);
	}
	
	
	
	
		
}
