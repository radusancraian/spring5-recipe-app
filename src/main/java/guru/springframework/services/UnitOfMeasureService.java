package guru.springframework.services;

import guru.springframework.domain.UnitOfMeasure;

import java.util.Set;

/**
 * Created by Radu on 8/30/2018.
 */
public interface UnitOfMeasureService {

    Set<UnitOfMeasure> getUnitOfMeasures();
}
