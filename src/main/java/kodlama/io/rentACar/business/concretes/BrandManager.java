package kodlama.io.rentACar.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;

@Service // IoC
// sürekli newlememek için
// bu sınıf bir business nesnesidir.
public class BrandManager implements BrandService {

	private BrandRepository brandRepository;

	@Autowired
	// git parametrelerine bak,(brandRepository ) git uygulamayı tara,
	// brandRepository'i kim implemente ediyor? (InMemoryBrandManager) onun
	// new'lenmiş halini bana ver
	public BrandManager(BrandRepository brandRepository) {

		this.brandRepository = brandRepository;
	}

	@Override
	public List<GetAllBrandsResponse> getAll() {
														// burada findAll --> list of Brand döndürüyor, ama biz List<GetAllBrandsResponse> istiyoruz. 
		List<Brand> brands = brandRepository.findAll();
		List<GetAllBrandsResponse> brandsResponse = new ArrayList<GetAllBrandsResponse>();

		for (Brand brand : brands) {
			GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
			responseItem.setId(brand.getId());
			responseItem.setName(brand.getName());
			brandsResponse.add(responseItem);
		}

		return brandsResponse;

		/*
		 * Elimizde veritabanından gelen bir sürü veri var
		 * boş bir liste oluşturuyoruz
		 * foreach ile her dolaştığımda bir eleman oluşturuyoruz
		 * veritabanından gelen veriyi boş listeye eşliyoruz. (alanlarıyla birlikte)
		 * 
		 * */
	}

	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		Brand brand = new Brand();
		brand.setName(createBrandRequest.getName());
		this.brandRepository.save(brand);  // veritabanı brand'in ne olduğunu biliyor, brandrequesti bilmiyor o yüzden bizden brand türünde bişey istiyor.
	}
		

}
