package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_advertisements")
public class JobAdvertisement {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "job_position_count")
	private int jobPositionCount;
	
	@Column(name = "min_salary")
	private int minSalary;
	
	@Column(name = "max_salary")
	private int maxSalary;
	
	@JsonIgnore
	@Column(name = "created_date")
	private LocalDate createdDate = LocalDate.now();
	
	@Column(name = "application_deadline")
	private Date applicationDeadline;
	
	@Column(name = "job_description")
	private String jobDescription;
	
	@Column(name = "is_activated")
	@JsonIgnore
	private boolean isActivated = false;
	
	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne()
	@JoinColumn(name = "job_title_id")
	private JobPosition jobPosition;
	
	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;
}
