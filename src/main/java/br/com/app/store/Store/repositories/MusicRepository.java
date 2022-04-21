package br.com.app.store.Store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.app.store.Store.model.Music;

@Repository
public interface MusicRepository extends JpaRepository<Music, Long> {

}
