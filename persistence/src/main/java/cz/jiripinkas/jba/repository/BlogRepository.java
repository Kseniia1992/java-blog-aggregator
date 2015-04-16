package cz.jiripinkas.jba.repository;

import cz.jiripinkas.jba.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ksolodovnik
 */
public interface BlogRepository extends JpaRepository<Blog,Integer> {
}
