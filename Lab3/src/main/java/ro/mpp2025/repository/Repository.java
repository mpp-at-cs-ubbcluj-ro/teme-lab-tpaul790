package ro.mpp2025.repository;


import ro.mpp2025.domain.Car;
import ro.mpp2025.domain.Entity;

import java.util.List;

public interface Repository<ID,E extends Entity<ID>> {
    public List<E> findAll();

    public E findOne(ID id);

    public E save(E entity);

    public E delete(ID id);

    public E update(E entity);

}
