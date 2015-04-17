package cz.jiripinkas.jba.dao;

import cz.jiripinkas.jba.entity.Role;
import org.springframework.stereotype.Component;

/**
 * @author ksolodovnik
 */
@Component("roleDao")
public class RoleDaoImpl extends GenericDaoImpl<Role> implements RoleDao {}
