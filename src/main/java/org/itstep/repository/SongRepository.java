package org.itstep.repository;

import com.zaxxer.hikari.util.ConcurrentBag;
import org.itstep.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Integer> {
}