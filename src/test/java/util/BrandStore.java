package util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BrandStore {
    private List<Brand> brands = new ArrayList<>();

    public void addBrand(Brand brand) {
        brands.add(brand);
    }

    public void addAllBrands(Collection<Brand> brands) {
        this.brands.addAll(brands);
    }

}

