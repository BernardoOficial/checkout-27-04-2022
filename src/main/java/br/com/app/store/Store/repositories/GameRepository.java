package br.com.app.store.Store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.app.store.Store.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

}
