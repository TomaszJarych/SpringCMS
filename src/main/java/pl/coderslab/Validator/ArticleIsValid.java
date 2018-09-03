package pl.coderslab.Validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import pl.coderslab.Validator.Class.ArticleValidator;

@Constraint(validatedBy = ArticleValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
public @interface ArticleIsValid {

  int titleMaxLength() default 200;

  int contentMinLength() default 500;

  String message() default "Invalid article's data. Check requiremtn for fields";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
