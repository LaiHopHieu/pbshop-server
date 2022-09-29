package com.vti.specification;

import com.vti.entity.Category_;
import com.vti.entity.Product;
import com.vti.entity.Product_;
import com.vti.entity.Ram;
import com.vti.form.ProductFilterForm;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.time.LocalDate;

public class ProductSpecification {
    public static Specification<Product> buildWhere(ProductFilterForm form) {
        if (form == null) {
            return null;
        }
        return hasNameLike(form.getSearch())
                .or(hasCategoryNameLike(form.getSearch()))
                .and(hasMinSalePrice(form.getMinSalePrice()))
                .and(hasMaxSalePrice(form.getMaxSalePrice()))
                .and(hasRamEqual(form.getRam()))
                .and(hasCategoryIdEqual(form.getCategoryId()))
                .and(hasYearGreaterThanOrEqualTo(form.getMinYear()))
                .and(hasYearLessThanOrEqualTo(form.getMaxYear()))
                .and(hasCreatedDateGreaterThanOrEqualTo(form.getMinCreatedDate()))
                .and(hasCreatedDateLessThanOrEqualTo(form.getMaxCreatedDate()));
    }

    private static Specification<Product> hasRamEqual(Ram ram) {
        return (root, query, builder) -> {
            if (ram == null) {
                return null;
            }
            return builder.equal(root.get(Product_.ram), ram);
        };
    }

    private static Specification<Product> hasCategoryIdEqual(Integer categoryId) {
        return (root, query, builder) -> {
            if (categoryId == null) {
                return null;
            }
            return builder.equal(root.get(Product_.category).get(Category_.id), categoryId);
        };
    }

    private static Specification<Product> hasCategoryNameLike(String value) {
        return (root, query, builder) -> {
            if (!StringUtils.hasText(value)) {
                return null;
            }
            return builder.like(root.get(Product_.category).get((Category_.name)), "%" + value.trim() + "%");
        };
    }

    private static Specification<Product> hasMaxSalePrice(Double maxSalePrice) {
        return (root, query, builder) -> {
            if (maxSalePrice == null) {
                return null;
            }
            return builder.lessThanOrEqualTo(root.get(Product_.salePrice), maxSalePrice);
        };
    }

    private static Specification<Product> hasMinSalePrice(Double minSalePrice) {
        return (root, query, builder) -> {
            if (minSalePrice == null) {
                return null;
            }
            return builder.greaterThanOrEqualTo(root.get(Product_.salePrice), minSalePrice);
        };
    }

    private static Specification<Product> hasCreatedDateLessThanOrEqualTo(LocalDate maxCreatedDate) {
        return (root, query, builder) -> {
            if (maxCreatedDate == null) {
                return null;
            }
            return builder.greaterThanOrEqualTo(root.get(Product_.createdDate).as(LocalDate.class), maxCreatedDate);
        };
    }

    private static Specification<Product> hasCreatedDateGreaterThanOrEqualTo(LocalDate minCreatedDate) {
        return (root, query, builder) -> {
            if (minCreatedDate == null) {
                return null;
            }
            return builder.greaterThanOrEqualTo(root.get(Product_.createdDate).as(LocalDate.class), minCreatedDate);
        };
    }

    private static Specification<Product> hasYearLessThanOrEqualTo(Integer maxYear) {
        return (root, query, builder) -> {
            if (maxYear == null) {
                return null;
            }
            return builder.greaterThanOrEqualTo(
                    builder.function("YEAR", Integer.class, root.get(Product_.createdDate)),
                    maxYear
            );
        };
    }

    private static Specification<Product> hasYearGreaterThanOrEqualTo(Integer minYear) {
        return (root, query, builder) -> {
            if (minYear == null) {
                return null;
            }
            return builder.greaterThanOrEqualTo(
                    builder.function("YEAR", Integer.class, root.get(Product_.createdDate)),
                    minYear
            );
        };
    }

    private static Specification<Product> hasNameLike(String value) {
        return (root, query, builder) -> {
            if (!StringUtils.hasText(value)) {
                return null;
            }
            return builder.like(root.get(Product_.name), "%" + value.trim() + "%");
        };
    }
}
