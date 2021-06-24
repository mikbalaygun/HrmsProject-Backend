package kodlamaio.hrms.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;


import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	/*
	List<JobAdvertisement> getByIsActivated(boolean isActivated);
	JobAdvertisement getByIsActivatedAndEmployer_EmployerId(boolean isActivated, int employerId);
	//JobAdvertisement  getByIsActiveOrderByCreatedDateDesc(boolean isActivated);
	@Query("From JobAdvertisement where isActivated=:isActivated and employer.employerName=:employerName")
	JobAdvertisement getByIsActivatedAndEmployerName(boolean isActivated, String employerName);
	*/
}
