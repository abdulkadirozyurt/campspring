package kodlama.io.rentACar.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBrandRequest {
	// marka oluşturmak istendiğinde apiye gönderilen istek
	
	
	private String name;

}





// son kullanıcıdan apiye bir şey varsa bu request
// apiden son kullanıcıya response