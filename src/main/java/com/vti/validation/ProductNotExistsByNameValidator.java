package vti.validation;

import com.vti.repository.IProductRepository;
import com.vti.validation.ProductNotExistsByName;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ProductNotExistsByNameValidator implements ConstraintValidator<ProductNotExistsByName, String> {
    @Autowired
    private IProductRepository repository;

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        return !repository.existsByName(name);
    }
}
