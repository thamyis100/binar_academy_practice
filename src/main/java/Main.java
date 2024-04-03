import com.binar.batch7.ch3.pertemuan2.Category;
import com.binar.batch7.ch3.pertemuan2.CategoryType;
import com.binar.batch7.ch3.pertemuan2.DetailProduct;
import com.binar.batch7.ch3.pertemuan2.Product;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        // 4. Membuat Objek kategori type
        CategoryType categoryType = new CategoryType("Iphone");
        // 3. Membuat objek kategori
        Category category = new Category("Electronics",Optional.of(categoryType));
        // 2 .Membuat objek detail produk dengan kategori
        DetailProduct detailProduct = new DetailProduct("Smartphone", Optional.of(category));
        // 1 :Membuat objek produk dengan detail produk
        Product product = new Product("iPhone", Optional.of(detailProduct));

        // OrElse String
        Optional<String> optionalValue = Optional.ofNullable(null);
        String value = optionalValue.orElse("Default Value");
        System.out.println("or else : "+value);

        // OrElse Object ?
        Optional<DetailProduct> detailProduct1 = Optional.ofNullable(null);
        DetailProduct detailProductNew = new DetailProduct("VIVO", Optional.of(category));

        DetailProduct value1 = detailProduct1.orElse(detailProductNew);
        System.out.println("or else di Objek :"+value1);

        // OrElseGet
        Optional<String> optionalValueGet = Optional.ofNullable(null);
        String value3 = optionalValue.orElseGet(() -> "Default Value");
        System.out.println("or else get: "+value3);

//orelseGet versi 2
        String value4 = optionalValue.orElseGet(() ->{
            //tulis logic yang dibutuhkan
            return "Default Value dari value 4";
        });
        System.out.println("or else get value4 : "+value4);

//orelseGet Object 3 tampa logic
        DetailProduct value5 = detailProduct1.orElseGet(()->detailProductNew);
        System.out.println("or else get object: "+value5);

//orelseGet Object dengan logic
        DetailProduct value6 = detailProduct1.orElseGet(()->{
            // menuliskan logic
            return detailProductNew;
        });
        System.out.println("or else get object 2: "+value6);

    }
}

