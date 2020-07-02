package com.jp.metro.card.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jp.metro.card.entity.Station;

@Repository
public interface StationRepository extends JpaRepository<Station, String> {

}
