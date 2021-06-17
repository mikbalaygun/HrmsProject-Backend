package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	List<JobAdvertisement> getByIsActivated(boolean isActivated);
	List<JobAdvertisement> getByIsActivatedAndEmployer_EmployerId(boolean isActivated, int employerId);
	List<JobAdvertisement>  getByIsActiveOrderByCreatedDateDesc(boolean isActivated);
	@Query("From JobAdvertisement where isActivated=:isActivated and employer.employerName=:employerName")
	List<JobAdvertisement> getByIsActivatedAndEmployerName(boolean isActivated, String employerName);
}
