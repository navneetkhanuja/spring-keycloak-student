package com.nav.springkeycloak.demo.repository;

import com.nav.springkeycloak.demo.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*This class is not needed once KeycloakSecurityConfig is created and users/roles are created in keycloak.*/
@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {
}
