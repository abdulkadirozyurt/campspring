package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;
import lombok.AllArgsConstructor;

@RestController // annotation --> bilgilendirme, spring framework , bu uygulama çalışırken kimde
				// restcontroller var diye arıyor, aa burda var deyip demek ki burası erişim
				// noktarı olarak algılıyor.
@RequestMapping("/api/brands") // kontrolörle (ucaktaki pilot) kontrol merkeziyle nasıl iletişim kursun
@AllArgsConstructor
public class BrandsController {

	private BrandService brandService;	

	@GetMapping()
	public List<GetAllBrandsResponse> getAll() {

		return this.brandService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetByIdBrandResponse getById(@PathVariable int id) {
		return brandService.getById(id);
	}
	
	@PostMapping()
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody @Valid() CreateBrandRequest createBrandRequest) {
		this.brandService.add(createBrandRequest);	
	}
	
	@PutMapping
	public void update(@RequestBody UpdateBrandRequest updateBrandRequest) {
		this.brandService.update(updateBrandRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.brandService.delete(id);
	}
}


//www.rentacar.com/api/brands/getAll deyince çalışacak olan yer. (ÖRNEK)

// istek, kontrolöre yani buraya yapılıyor, kontrolör isteği doğru bulursa business'a gidiyor, orada iş kurallarına uyarda data access'e veriyi getir deniyor.'


//@Autowired bunu yazma yerine geçer	//BrandManager brandManager = new BrandManager(new InMemoryBrandRepository());

























/*
 * @Autowired // spring yeni versiyonlarında koymayınca da çalışır // git
 * parametrelerine bak,(brandservice ) git uygulamayı tara, brandservice'i //
 * kim implemente ediyor? (brandmanager) onun new'lenmiş halini bana ver
 * 
 * public BrandsController(BrandService brandService) { this.brandService =
 * brandService; }
 */