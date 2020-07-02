package com.jp.metro.card.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jp.metro.card.entity.Address;

public interface AddressRepository extends JpaRepository<Address, String> {

}
