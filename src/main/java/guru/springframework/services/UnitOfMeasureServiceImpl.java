package guru.springframework.services;

import guru.springframework.commands.UnitOfMeasureCommand;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by Radu on 8/30/2018.
 */
@Service
@Slf4j
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
