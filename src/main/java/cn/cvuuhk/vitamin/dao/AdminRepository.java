package cn.cvuuhk.vitamin.dao;

import cn.cvuuhk.vitamin.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {}
