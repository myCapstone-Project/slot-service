package com.cricket.slot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cricket.slot.entity.Slot;
import com.cricket.slot.service.SlotService;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/slots")
public class SlotController {

    @Autowired
    private SlotService slotService;

    @PostMapping
    public ResponseEntity<Slot> createSlot(@RequestBody Slot slot) {
        Slot createdSlot = slotService.saveSlot(slot);
        return new ResponseEntity<>(createdSlot, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Slot> updateSlot(@PathVariable int id, @RequestBody Slot slot) {
        Slot updatedSlot = slotService.updateSlot(id, slot);
        return ResponseEntity.ok(updatedSlot);
    }

    @GetMapping
    public ResponseEntity<List<Slot>> getAllSlots() {
        List<Slot> slots = slotService.getAllSlots();
        return ResponseEntity.ok(slots);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Slot> getSlotById(@PathVariable int id) {
        Slot slot = slotService.getSlotById(id);
        return ResponseEntity.ok(slot);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSlot(@PathVariable int id) {
        slotService.deleteSlot(id);
        return ResponseEntity.noContent().build();
    }
}

