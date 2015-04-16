package cz.jiripinkas.jba.repository;

import cz.jiripinkas.jba.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ksolodovnik
 */
public interface ItemRepository extends JpaRepository<Item,Integer> {
}
