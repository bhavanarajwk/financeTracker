package com.webknot.demo.repository;

import com.webknot.demo.entity.FinanceEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinanceEntryRepository
        extends JpaRepository<FinanceEntry, Long> {
}
