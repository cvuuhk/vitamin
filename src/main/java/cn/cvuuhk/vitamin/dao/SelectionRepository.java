package cn.cvuuhk.vitamin.dao;

import cn.cvuuhk.vitamin.entity.Selection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SelectionRepository extends JpaRepository<Selection, String> {}
