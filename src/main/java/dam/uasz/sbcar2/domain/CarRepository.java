package dam.uasz.sbcar2.domain;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
public interface CarRepository extends CrudRepository<Car, Long>{
    List<Car> findByBrand(@Param("brand")String brand);

    List<Car> findByColor(@Param("color")String color);
    
    List<Car> findByBrandAndModel(String brand, String Model);
    
    List<Car> findByBrandOrColor(String brand, String color);

    @Query("select c from Car c where c.model = ?1")
    List<Car> findByModel(String model);

}
