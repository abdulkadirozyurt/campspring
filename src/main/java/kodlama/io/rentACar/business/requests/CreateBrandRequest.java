package kodlama.io.rentACar.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBrandRequest {	
	private String name;

}




// marka oluşturmak istendiğinde apiye gönderilen istek
// son kullanıcıdan apiye bir şey varsa bu request
// apiden son kullanıcıya response