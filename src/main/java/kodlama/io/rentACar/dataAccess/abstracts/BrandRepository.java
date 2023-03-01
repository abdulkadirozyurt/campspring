package kodlama.io.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentACar.entities.concretes.Brand;

// repository, Dao ---> bunlar genellikle veritabanı işlemi yapacak sınıflara verdiğimiz isimlerdir.


public interface BrandRepository extends JpaRepository<Brand,Integer> {
	//Brand[] getAll();	
	//List<Brand> getAll();
	
	 boolean existsByName(String name);  // jpa bize exist'i gördüğünde kendisi true false dönen bir sorgu oluşturuyor. Keyword,
	

}
