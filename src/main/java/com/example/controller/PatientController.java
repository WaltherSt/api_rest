package com.example.controller;

import com.example.model.Patient;
import com.example.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/patients")
public class PatientController {
    @Autowired
    PatientService patientService;

    //metodo para REGISTRAR
    @PostMapping(consumes = "application/json")
    public ResponseEntity<Patient> addPatient(@Valid @RequestBody Patient patient) {
        try {
            patientService.save(patient);
            return new ResponseEntity<>(patient, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //Metodo para CONSULTAR todos los registros
    @GetMapping()
    public ResponseEntity<List<Patient>> getPatients() {
        try {
            return new ResponseEntity<>(patientService.getPatients(), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Metodo para CONSULTAR cada registro individualmente
    @GetMapping("/{cedula}")
    public ResponseEntity<Optional<Patient>> getPatientById(@PathVariable Long cedula) {
        try {
            return new ResponseEntity<>(patientService.getPatientById(cedula), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Metodo para EDITAR un registro
    @PatchMapping("/{cedula}")
    public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient, @PathVariable Long cedula) {
        try {
            return new ResponseEntity<>(patientService.updatePatient(patient, cedula), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    //Metodo para ELIMINAR un registro
    @DeleteMapping("/{cedula}")
    public ResponseEntity<String> deletePatient(@PathVariable Long cedula) {
        try {
            patientService.deletePatient(cedula);
            return new ResponseEntity<>("El paciente ha sido eliminado", HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

