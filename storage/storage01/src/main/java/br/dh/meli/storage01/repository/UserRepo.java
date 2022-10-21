package br.dh.meli.storage01.repository;

import br.dh.meli.storage01.model.UserBD;
import org.springframework.data.repository.CrudRepository;

// CRUD = Create, Read, Update, Delete
public interface UserRepo extends CrudRepository<UserBD, Long> {

}
