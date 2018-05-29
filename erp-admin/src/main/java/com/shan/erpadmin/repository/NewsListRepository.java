package com.shan.erpadmin.repository;


import com.shan.erpadmin.domain.NewsList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NewsListRepository extends JpaRepository<NewsList,Integer>,PagingAndSortingRepository<NewsList,Integer> {
}
