package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;

public interface BrandService {
	
	List<GetAllBrandsResponse> getAll();    // son kullnaici bizden tüm markalari istiyor, biz ona bir şey return ettiğimiz için response(yanıt yani).
	
	void add(CreateBrandRequest createBrandRequest);

}
