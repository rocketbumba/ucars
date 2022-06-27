package com.ucars.test.repository;

import com.ucars.test.model.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarModelRepository extends JpaRepository<CarModel, Integer>, CarModelCustomRepository, JpaSpecificationExecutor<CarModel> {
    @Query("from CarModel as cm where cm.brand_id=:brand_id")
    List<CarModel> findModelByBrand(int brand_id);

}
