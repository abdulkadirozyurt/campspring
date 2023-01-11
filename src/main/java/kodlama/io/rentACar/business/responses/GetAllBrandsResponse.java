package kodlama.io.rentACar.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBrandsResponse {  // tüm brandler lislemek istendiğindeki yanıtımız.
	
	
	// son kullanıcıya, apiyi kullanan uygulamaya vermek istediğimiz bilgiler, alanlar
	
	private int id;
	private String name;

}
