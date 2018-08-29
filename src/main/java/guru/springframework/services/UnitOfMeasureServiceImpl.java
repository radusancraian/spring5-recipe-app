package guru.springframework.services;

import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.UnitOfMeasureRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Radu on 8/30/2018.
 */
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    private final UnitOfMeasureRepository unitOfMeasureRepository;


    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public Set<UnitOfMeasure> getUnitOfMeasures() {

        Set<UnitOfMeasure> unitOfMeasureSet = new HashSet<>();

        unitOfMeasureRepository.findAll().iterator().forEachRemaining(unitOfMeasure -> unitOfMeasureSet.add(unitOfMeasure));

        return unitOfMeasureSet;
    }
}
