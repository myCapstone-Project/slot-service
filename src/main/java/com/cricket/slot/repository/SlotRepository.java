package com.cricket.slot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cricket.slot.entity.Slot;

public interface SlotRepository extends JpaRepository<Slot,Integer>{
    
}
