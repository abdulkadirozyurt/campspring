package kodlama.io.rentACar;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;

@SpringBootApplication
public class RentACarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentACarApplication.class, args);		
	
	}
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	// uygulama başladığında hata verdi, çünkü bu modelmapper nesnesi aslında yok. onu biz oluşturduk.
	
}

