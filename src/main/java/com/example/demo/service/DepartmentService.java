package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;

@Service 
public class DepartmentService {
    @Autowired 
    private DepartmentRepository departmentRepository;

    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    public Department getById(Integer id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public String insert(Department department) {
        try {
            departmentRepository.save(department);

            return "Berhasil melakukan insert Departemen";
        } catch (Exception e) {
            // TODO: handle exception
            return "gagal melakukan insert";
        }
    }

    public String update(Integer id, Department department) {
        Department oldDepartment = departmentRepository.findById(id).orElse(null);

        if (oldDepartment == null) {
            return "Data tidak ditemukan";
        }

        oldDepartment.setName(department.getName());
        departmentRepository.save(oldDepartment);
        return "Departemen berhasil di update";
    }

    public String delete(Integer id) {
        departmentRepository.deleteById(id);
        return "Departemen berhasil di hapus";
    }
}
