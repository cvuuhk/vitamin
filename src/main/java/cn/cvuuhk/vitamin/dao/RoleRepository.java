package cn.cvuuhk.vitamin.dao;

import cn.cvuuhk.vitamin.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {}
