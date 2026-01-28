package com.webknot.demo.service;

import com.webknot.demo.entity.FinanceEntry;
import com.webknot.demo.repository.FinanceEntryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinanceEntryService {

    private final FinanceEntryRepository repository;

    public FinanceEntryService(FinanceEntryRepository repository) {
        this.repository = repository;
    }

    public FinanceEntry create(FinanceEntry entry) {
        return repository.save(entry);
    }

    public List<FinanceEntry> getAll() {
        return repository.findAll();
    }

    public FinanceEntry getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entry not found"));
    }

    public FinanceEntry update(Long id, FinanceEntry updated) {
        FinanceEntry entry = getById(id);
        entry.setAmount(updated.getAmount());
        entry.setCategory(updated.getCategory());
        entry.setDate(updated.getDate());
        entry.setDescription(updated.getDescription());
        entry.setType(updated.getType());
        return repository.save(entry);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
