package kodlama.io.rentACar.entities.concretes;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "brands")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Brand {
	
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment yapmak için  
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	
}
