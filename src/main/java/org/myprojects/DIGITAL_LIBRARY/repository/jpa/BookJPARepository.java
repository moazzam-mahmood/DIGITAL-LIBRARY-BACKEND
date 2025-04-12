package org.myprojects.DIGITAL_LIBRARY.repository.jpa;

import org.myprojects.DIGITAL_LIBRARY.entities.output.BookOutputEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookJPARepository extends JpaRepository<BookOutputEntity, Long> {
}
