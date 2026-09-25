package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Bank;
import com.example.demo.repository.BankRepository;

@Service  
public class BankService {
    @Autowired 
    private BankRepository bankRepository;

    public List<Bank> getAll() {
        return bankRepository.findAll();
    }

    public Bank getById(Integer id) {
        return bankRepository.findById(id).orElse(null);
    }

    public String insert(Bank bank) {
        try {
            if (bank.getCreatedAt() == null) {
                bank.setCreatedAt(LocalDate.now());
            }
          
            bankRepository.save(bank);
            return "Bank berhasil ditambahkan";
        } catch (Exception e) {
            return "Bank gagal ditambahkan";
        }
    }

    public String update(Integer id, Bank bank) {
        Bank oldBank = bankRepository.findById(id).orElse(null);
        if (oldBank == null) {
            return "Bank tidak ditemukan";
        }

        try {
            oldBank.setName(bank.getName());
            bankRepository.save(oldBank);
            return "Bank berhasil diupdate";
        } catch (Exception e) {
            return "Bank gagal diupdate";
        }
    }

    public String delete(Integer id) {
        Bank bank = bankRepository.findById(id).orElse(null);
        if (bank == null) {
            return "Bank tidak ditemukan";
        }

        try {
            bankRepository.deleteById(id);
            return "Bank berhasil dihapus";
        } catch (Exception e) {
            return "Bank gagal dihapus";
        }
    }
}
