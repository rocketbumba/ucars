package com.ucars.test.repository;

import com.ucars.test.model.CarModel;
import com.ucars.test.model.CarModel_;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;


public class CarCustomRepositoryImpl implements CarModelCustomRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<CarModel> findByNameOrDescription(String name, String description) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();

        Root<CarModel> carModelRoot = cq.from(CarModel.class);

        Predicate namePredicate = cb.equal(carModelRoot.get(CarModel_.NAME), name);
        Predicate descriptionPreidace =  cb.equal(carModelRoot.get(CarModel_.DESCRIPTION), description);

        cq.where(namePredicate, descriptionPreidace);
        TypedQuery<CarModel> query = entityManager.createQuery(cq);

        return query.getResultList();
    }
}
