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
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	/*
	 * public Brand() {
	 * 
	 * }
	 * 
	 * public Brand(int id, String brand) {
	 * 
	 * this.id = id; this.brand = brand; }
	 * 
	 * public int getId() { return id; }
	 * 
	 * public void setId(int id) { this.id = id; }
	 * 
	 * public String getBrand() { return this.brand; }
	 * 
	 * public void setBrand(String brand) { this.brand = brand; }
	 */

}
