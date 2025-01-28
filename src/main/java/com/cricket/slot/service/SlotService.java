package com.cricket.slot.service;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cricket.slot.entity.Slot;
import com.cricket.slot.repository.SlotRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SlotService {

    @Autowired
    private SlotRepository slotRepository;

    public Slot saveSlot(Slot slot) {
        return slotRepository.save(slot);
    }

    public Slot updateSlot(int id, Slot slot) {
        Optional<Slot> existingSlot = slotRepository.findById(id);
        if (existingSlot.isPresent()) {
            slot.setId(id);
            return slotRepository.save(slot);
        } else {
            throw new RuntimeException("Slot not found with id: " + id);
        }
    }

    public List<Slot> getAllSlots() {
        return slotRepository.findAll();
    }

    public Slot getSlotById(int id) {
        return slotRepository.findById(id).orElseThrow(() -> 
            new RuntimeException("Slot not found with id: " + id));
    }

    public void deleteSlot(int id) {
        if (slotRepository.existsById(id)) {
            slotRepository.deleteById(id);
        } else {
            throw new RuntimeException("Slot not found with id: " + id);
        }
    }
}

