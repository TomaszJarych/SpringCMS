package pl.coderslab.Validator.Class;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import pl.coderslab.DTO.ArticleDTO;
import pl.coderslab.Validator.ArticleIsValid;

public class ArticleValidator implements ConstraintValidator<ArticleIsValid, ArticleDTO> {

  private int titleMaxLength;
  private int contentMinLength;

  @Override
  public void initialize(ArticleIsValid constraintAnnotation) {
    this.titleMaxLength = constraintAnnotation.titleMaxLength();
    this.contentMinLength = constraintAnnotation.contentMinLength();
  }

  @Override
  public boolean isValid(ArticleDTO value, ConstraintValidatorContext context) {
    if (value.getTitle().length() > titleMaxLength
        || value.getTitle().isEmpty()
        || value.getTitle() == null) {
      return false;
    }
    if (value.getContent().length() < contentMinLength
        || value.getTitle().isEmpty()
        || value.getTitle() == null) {
      return false;
    }
    if (value.getCategories().isEmpty() || value.getCategories() == null) {
      return false;
    }
    return true;
  }
}
