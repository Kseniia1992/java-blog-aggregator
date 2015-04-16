package cz.jiripinkas.jba.repository;

import cz.jiripinkas.jba.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ksolodovnik
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
