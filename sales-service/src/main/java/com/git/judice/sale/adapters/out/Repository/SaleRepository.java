package com.git.judice.sale.adapters.out.Repository;

import com.git.judice.sale.adapters.out.Repository.entity.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<SaleEntity, Integer> {

}
