package com.bcopstein.CtrlCorredorV1.service;

import com.bcopstein.CtrlCorredorV1.entity.AbstractEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public abstract class AbstractService <
    Entity extends AbstractEntity,
    EntityRepository extends CrudRepository<Entity, Long>> {

  @Autowired
  protected EntityRepository repository;

  @Transactional( rollbackFor = Exception.class )
  public Entity save( Entity entity ) throws Exception {
    return repository.save(entity);
  }

  @Transactional( rollbackFor = Exception.class )
  public Entity edit( Long id, Entity entity ) {
    entity.setId(id);
    return repository.save(entity);
  }

  public List<Entity> listAll() {
    return (List<Entity>) repository.findAll();
  }

  @Transactional(rollbackFor = Exception.class)
  public boolean deleteById(Long id){
    Entity entity = repository.findById(id).get();
    boolean exists = entity == null ? false : true;
    repository.deleteById(id);
    return exists;
  }

  public Entity findById(Long id){
    return repository.findById(id).get();
  }
}
