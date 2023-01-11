package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;

@RestController // annotation --> bilgilendirme, spring framework , bu uygulama çalışırken kimde
				// restcontroller var diye arıyor, aa burda var deyip demek ki burası erişim
				// noktarı olarak algılıyor.
@RequestMapping("/api/brands") // kontrolörle (ucaktaki pilot) kontrol merkeziyle nasıl iletişim kursun

public class BrandsController {

	private BrandService brandService;

	@Autowired // spring yeni versiyonlarında koymayınca da çalışır
	// git parametrelerine bak,(brandservice ) git uygulamayı tara, brandservice'i
	// kim implemente ediyor? (brandmanager) onun new'lenmiş halini bana ver

	public BrandsController(BrandService brandService) {
		this.brandService = brandService;
	}

	@GetMapping("/getall")
	public List<GetAllBrandsResponse> getAll() {

// @Autowired bunu yazma yerine geçer	//BrandManager brandManager = new BrandManager(new InMemoryBrandRepository());

		return this.brandService.getAll();

//   www.rentacar.com/api/brands/getAll deyince çalışacak olan yer. (ÖRNEK)
	}
	
	@PostMapping("/add")
	public void add(CreateBrandRequest createBrandRequest) {
		this.brandService.add(createBrandRequest);	
	}

}

// istek, kontrolöre yani buraya yapılıyor, kontrolör isteği doğru bulursa business'a gidiyor, orada iş kurallarına uyarda data access'e veriyi getir deniyor.'