package kodlama.io.rentACar.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;
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

	@Override
	public List<GetAllBrandsResponse> getAll() {

		List<Brand> brands = brandRepository.findAll();
		/*
		 * List<GetAllBrandsResponse> brandsResponse = new
		 * ArrayList<GetAllBrandsResponse>();
		 * 
		 * for (Brand brand : brands) { GetAllBrandsResponse responseItem = new
		 * GetAllBrandsResponse(); responseItem.setId(brand.getId());
		 * responseItem.setName(brand.getName());
		 * 
		 * brandsResponse.add(responseItem); }
		 */

		
		
		// stream metodu, elimizde bir collection,
		// yani buradaki şekliyle List varsa,
		// onu tek tek dolaşmamızı sağlıyor. foreach gibi

		List<GetAllBrandsResponse> brandsResponse = brands.stream()
				.map(brand->this.modelMapperService.forResponse()             // brand-> her bir brand için dolaş demek.
				.map(brand, GetAllBrandsResponse.class))
				.collect(Collectors.toList());

		return brandsResponse;

		// burada findAll --> list of Brand döndürüyor, ama biz
		// List<GetAllBrandsResponse> istiyoruz.
		// veritabanı nesnesini (brand'i) son kullanıcıya direkt olarak vermiyoruz,
		// bunun yerine başka bir liste oluşturup veritabanından gelen markaları o
		// listeye ekliyoruz

		/*
		 * Elimizde veritabanından gelen bir sürü veri var boş bir liste oluşturuyoruz
		 * foreach ile her dolaştığımda bir eleman oluşturuyoruz veritabanından gelen
		 * veriyi boş listeye eşliyoruz. (alanlarıyla birlikte)
		 * 
		 */
	}

	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		/*
		 * Brand brand = new Brand(); brand.setName(createBrandRequest.getName());
		 */

		// benim bir createBrandRequest im var, onu Brand tipine çevir. (Brand.class)
		Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);

		this.brandRepository.save(brand);

// forRequest arkaplanda Brand'i newliyor (yukarıdaki ilk işlem), createBrandRequest'in bütün alanlarını karşılaştırıyor ve aynı olanlarını newlediğine aktarıyor.		
// artık elinde bir veritabanı nesnesi var (Brand brand)		

		// veritabanı brand'in ne olduğunu biliyor, brandrequesti bilmiyor o yüzden
		// bizden brand türünde bişey istiyor.
	}

	@Override
	public GetByIdBrandResponse getById(int id) {
		Brand brand = this.brandRepository.findById(id).orElseThrow();
		
		GetByIdBrandResponse response 
		= this.modelMapperService.forResponse()
		.map(brand, GetByIdBrandResponse.class);
		
		return response;
	}

	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		// jparepository brand tanıdığı için hep brand nesnesi lazım.
		
		Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		this.brandRepository.save(brand);    // updaterequest içinde id olduğu için buradaki save, update işlemi yapar.
	}

	@Override
	public void delete(int id) {
		this.brandRepository.deleteById(id);	
	}

}

//@Autowired --> git parametrelerine bak,(brandRepository ) git uygulamayı tara,
// brandRepository'i kim implemente ediyor? (InMemoryBrandManager) onun
// new'lenmiş halini bana ver
// veritabanı katmanını buraya constructor ile enjekte ettik.
// business, dataAccess'i kullanır bu yüzden lazım.
/*
 * @Autowired public BrandManager(BrandRepository brandRepository) {
 * 
 * this.brandRepository = brandRepository; }
 */
