package kodlama.io.rentACar.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "models")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Model {
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment yapmak için
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "brand_id")    // bizim model tablomuz için, veritabanına gidip bir tane 'brand_id' alanı koyacak ve bununla Brand arasında bir fiziksel ilişki kuracak.
	private Brand brand;
	
	@OneToMany(mappedBy = "model")	
	private List<Car> cars;       // bir modelde, bir sürü araba olabilir.
	
	
	
}
