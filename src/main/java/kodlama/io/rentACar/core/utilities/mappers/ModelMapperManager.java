package kodlama.io.rentACar.core.utilities.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service    // her seferinde yeni bir ModelMapper üretilmesin, bu IoC ye yerleşsin istiyorum
@AllArgsConstructor
public class ModelMapperManager implements ModelMapperService{

	private ModelMapper modelMapper;
	
	
	
	@Override
	public ModelMapper forResponse() {
		this.modelMapper.getConfiguration()
		.setAmbiguityIgnored(false)
		.setMatchingStrategy(MatchingStrategies.LOOSE);
		
		return this.modelMapper;
	}

	@Override
	public ModelMapper forRequest() {
		this.modelMapper.getConfiguration()
		.setAmbiguityIgnored(false)
		.setMatchingStrategy(MatchingStrategies.STANDARD);
		
		return this.modelMapper;
		
	}

}






/*
  
  public ModelMapper forResponse() {
		this.modelMapper.getConfiguration()
		.setAmbiguityIgnored(false)
		.setMatchingStrategy(MatchingStrategies.LOOSE);
		
		return this.modelMapper;
	}
  -----------
  
  loose, yani gevşek mapleme yap,
  gevşek mapleme ne demek
  veritabanında diyelim ki id,name,x,y,z bir sürü alan var,
  benim response nesnemde sadece id,name gibi 2si varsa onları maple, 
  diğerleri yok diye bana kızma
  demek.
  
  ***************************************************
  ancak request aldığımda (standart)
  her şeyin bir karşılığı olsun yoksa kız bana.
  standart bu anlama geliyor.
  
  
  
  */

