package cn.cvuuhk.vitamin.dao;

import cn.cvuuhk.vitamin.entity.VitaminSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VitaminSystemRepository extends JpaRepository<VitaminSystem, String> {}
