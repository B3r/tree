package it.marvinflock.tree.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface AbstractRepository<T> extends CrudRepository<T, Long> {

  @Override
  List<T> findAll();
}
