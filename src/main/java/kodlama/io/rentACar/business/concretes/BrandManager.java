package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;
import kodlama.io.rentACar.business.rules.BrandBusinessRules;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;

// IoC
// sürekli newlememek için
// bu sınıf bir business nesnesidir.
// Service

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;
	private BrandBusinessRules brandBusinessRules;

	@Override
	public List<GetAllBrandsResponse> getAll() {

		List<Brand> brands = this.brandRepository.findAll();      // jpa, brand bildiği için önce brandlari aldık
		List<GetAllBrandsResponse> brandsResponse =               // brands i tek tek dolaşmamız lazım, stream() metodu ile bunu yaparız. StreamApi dan gelen  map() metodu da (buradaki ilk map) stream() ile erişilen her bir nesneye özel işlemler yapabilmemizi sağlar.
				brands.stream().map(brand->this.modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());
		
		return brandsResponse;
	}

	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
		Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		
		this.brandRepository.save(brand);
	}

	@Override
	public GetByIdBrandResponse getById(int id) {
		Brand brand = this.brandRepository.findById(id).orElseThrow();           // findById(), optional döner. Bu yüzden bulamazsan hata fırlat dedik.
		GetByIdBrandResponse response = this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
		
		return response;
	}

	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		
		this.brandRepository.save(brand);			
	}

	@Override
	public void delete(int id) {
		this.brandRepository.deleteById(id);	
	}

}

