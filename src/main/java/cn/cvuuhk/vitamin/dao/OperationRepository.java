package cn.cvuuhk.vitamin.dao;

import cn.cvuuhk.vitamin.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRepository extends JpaRepository<Operation, String> {}
