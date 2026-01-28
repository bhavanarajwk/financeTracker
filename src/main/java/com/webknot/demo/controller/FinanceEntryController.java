package com.webknot.demo.controller;

import com.webknot.demo.entity.FinanceEntry;
import com.webknot.demo.service.FinanceEntryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/entries")
public class FinanceEntryController {

    private final FinanceEntryService service;

    public FinanceEntryController(FinanceEntryService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<FinanceEntry> create(
            @RequestBody @Valid FinanceEntry entry) {
        return ResponseEntity.ok(service.create(entry));
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<FinanceEntry>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<FinanceEntry> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<FinanceEntry> update(
            @PathVariable Long id,
            @RequestBody FinanceEntry entry) {
        return ResponseEntity.ok(service.update(id, entry));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Entry deleted successfully");
    }
}
