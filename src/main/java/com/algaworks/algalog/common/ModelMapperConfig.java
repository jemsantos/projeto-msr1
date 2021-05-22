/**
 * 
 */
package com.algaworks.algalog.common;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author José Eustaquio Muniz
 *
 */
@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper modelMapper() {

		return new ModelMapper();

	}

}
