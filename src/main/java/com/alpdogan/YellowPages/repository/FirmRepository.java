package com.alpdogan.YellowPages.repository;

import com.alpdogan.YellowPages.entity.Firm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FirmRepository extends CrudRepository<Firm, Integer> {



}
