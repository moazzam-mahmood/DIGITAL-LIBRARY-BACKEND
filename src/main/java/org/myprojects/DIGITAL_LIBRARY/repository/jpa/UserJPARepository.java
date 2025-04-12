package org.myprojects.DIGITAL_LIBRARY.repository.jpa;

import org.myprojects.DIGITAL_LIBRARY.entities.output.UserOutputEntity;
import org.myprojects.DIGITAL_LIBRARY.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJPARepository extends JpaRepository<UserOutputEntity, Long> {
}
