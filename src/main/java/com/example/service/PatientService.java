package com.example.service;

import com.example.model.Patient;
import com.example.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public void save(Patient data) {
        patientRepository.save(data);
    }

    public List<Patient> getPatients() {
        return patientRepository.findAll();

    }

    public Optional<Patient> getPatientById(Long cedula) {
        return patientRepository.findById(cedula);
    }

    public Patient updatePatient(Patient user, Long cedula) {
        Patient patient = patientRepository.getReferenceById(cedula);

        patient.setNombres(user.getNombres());
        patient.setApellidos(user.getApellidos());
        patient.setTelefono(user.getTelefono());
        patient.setCorreo(user.getCorreo());
        patient.setDireccion(user.getDireccion());
        return patientRepository.save(patient);
    }

    public void deletePatient(Long cedula) {
        patientRepository.deleteById(cedula);
    }
}
