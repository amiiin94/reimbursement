package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Role;
import com.example.demo.repository.RoleRepository;

@Service
public class RoleService {
    @Autowired 
    RoleRepository roleRepository;

    @Transactional 
    public String insert(Role role) {
        if (
            role.getName().isEmpty() ||
            role.getCreatedBy().equals(0)
        ) {return "Gagal melakukan update role";}

        try {
            roleRepository.insert(role.getName(), role.getCreatedBy());

            return "Berhasil melakukan insert role";
        } catch (Exception e) {
            // TODO: handle exception
            return "gagal melakukan insert";
        }
    }

    public List<Role> getRole() {
        return roleRepository.findAll();
    }

    public Role getRoleById(Integer id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Transactional
    public String update(Integer id, Role roleDetails) {
        Role existingRole = roleRepository.findById(id).orElse(null);
        if (existingRole == null) {
            return "Role tidak ditemukan";
        }
     
        existingRole.setName(roleDetails.getName());
        roleRepository.save(existingRole);
        return "Berhasil melakukan update role";
    }

    public String delete(Integer id) {
        Role role = roleRepository.findById(id).orElse(null);
        if (role == null) {
            return "Role tidak ditemukan";
        }

        roleRepository.deleteById(id);
        return "Role berhasil dihapus";  
    }
}
