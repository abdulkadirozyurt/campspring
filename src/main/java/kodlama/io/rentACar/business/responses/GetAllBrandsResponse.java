package kodlama.io.rentACar.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBrandsResponse {
	private int id;
	private String name;

}

// tüm brandler lislemek istendiğindeki yanıtımız.
// son kullanıcıya, apiyi kullanan uygulamaya vermek istediğimiz bilgiler,alanlar
