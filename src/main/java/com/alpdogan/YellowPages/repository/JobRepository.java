package com.alpdogan.YellowPages.repository;

import com.alpdogan.YellowPages.entity.Job;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends CrudRepository<Job, Integer> {



}
