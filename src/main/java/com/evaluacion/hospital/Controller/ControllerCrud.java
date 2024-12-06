package com.evaluacion.hospital.Controller;

import com.evaluacion.hospital.Entity.Citas;
import com.evaluacion.hospital.Entity.Consultorio;
import com.evaluacion.hospital.Entity.Doctores;
import com.evaluacion.hospital.repository.ICitas;
import com.evaluacion.hospital.repository.IConsultorio;
import com.evaluacion.hospital.repository.IDoctores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ControllerCrud {


    @Autowired
    private IDoctores doctoresRepository;
    @Autowired
    private IConsultorio consultorioRepository;
    @Autowired
    private ICitas citasRepository;



    @PostMapping("/api/saveDoctores")
    public Map<String, String> saveDoctores(@RequestBody Map<String, String> request) {
        Doctores doctores = new Doctores();
        doctores.setNombre(request.get("nombre").toString());
        doctores.setApellidoPaterno(request.get("apellidoPaterno").toString());
        doctores.setApellidoMaterno(request.get("apellidoMaterno").toString());
        try{
            doctoresRepository.save(doctores);
        }catch (Exception e){
            System.out.println(e.toString());
        }

        Map<String, String> response = new HashMap<>();
        response.put("message", "Datos recibidos al backend");
        System.out.println(doctoresRepository.findAll());
        return response; // Respuesta en formato JSON
    }

    @PostMapping("/api/altaConsultorio")
    public Map<String, String> saveConsultorio(@RequestBody Map<String, String> request){

        System.out.println("request: "+request);
        Consultorio consultorio = new Consultorio();
        consultorio.setNumConsultorio(request.get("numConsultorio"));
        consultorio.setPiso(request.get("piso"));

        try{
            consultorioRepository.save(consultorio);
        }catch (Exception e){
            System.out.println(e.toString());
        }


        Map<String, String> response = new HashMap<>();
        response.put("message", "Datos recibidos al backend");

        List<Consultorio> listaConsultorio= consultorioRepository.findAll();
        System.out.println(listaConsultorio);
        for (int i = 0; i < listaConsultorio.size(); i++){
            System.out.println(listaConsultorio.get(i).getNumConsultorio());
        }
        return response; // Respuesta en formato JSON
    }

    @PostMapping("/api/altaCita")
    public Map<String, String> saveCita(@RequestBody Map<String, String> request){

        System.out.println("request: "+request);
        Citas citas = new Citas();
        citas.setConsultorio(request.get("idconsultorio"));
        citas.setDoctor(request.get("iddoctor"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime fechaHora = LocalDateTime.parse(request.get("horario"), formatter);
        citas.setHorario(fechaHora);
        citas.setPaciente(request.get("paciente"));

        try{
            citasRepository.save(citas);
        }catch (Exception e){
            System.out.println(e.toString());
        }


        Map<String, String> response = new HashMap<>();
        response.put("message", "Datos recibidos al backend");

        List<Citas> listaCitas= citasRepository.findAll();
        System.out.println(listaCitas);
        for (int i = 0; i < listaCitas.size(); i++){
            System.out.println(listaCitas.get(i).toString());
        }
        return response; // Respuesta en formato JSON
    }

    @GetMapping("/api/getDoctores")
    public Map<String,String> getDoctores() {
        List<Doctores> listaDoctores = doctoresRepository.findAll();
        Map<String,String> response = new HashMap<>();
        for (Doctores doctor : listaDoctores){
            response.put(doctor.getId().toString(),
                    doctor.getNombre() + " " +
                            doctor.getApellidoPaterno() + " " +
                            doctor.getApellidoMaterno());
        }
        return response;
    }
    @GetMapping("/api/getConsultorio")
    public Map<String,String> getConsultorio() {
        List<Consultorio> listaConsultorio = consultorioRepository.findAll();
        Map<String,String> response = new HashMap<>();
        for (Consultorio consultorio : listaConsultorio){
            response.put(consultorio.getId().toString(),
                    "consultorio: " + consultorio.getNumConsultorio() +
                            " piso " + consultorio.getPiso());
        }
        return response;
    }
}
