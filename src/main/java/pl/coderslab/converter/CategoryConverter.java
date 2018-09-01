package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.coderslab.DTO.CategoryDTO;
import pl.coderslab.Service.ServiceDTO.CategoryServiceDTO;

public class CategoryConverter implements Converter<String, CategoryDTO> {

  @Autowired private CategoryServiceDTO serviceDTO;

  @Override
  public CategoryDTO convert(String source) {
    return serviceDTO.getCategoryByID(Long.valueOf(source));
  }
}
