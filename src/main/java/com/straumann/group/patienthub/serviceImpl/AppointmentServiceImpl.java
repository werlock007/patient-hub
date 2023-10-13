package com.straumann.group.patienthub.serviceImpl;

import com.straumann.group.patienthub.entity.Appointment;
import com.straumann.group.patienthub.exception.AppointmentException;
import com.straumann.group.patienthub.repository.AppointmentRepository;
import com.straumann.group.patienthub.service.AppointmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment getAppointmentById(Long id) {
        Optional<Appointment> optionalAppointment = appointmentRepository.findById(id);
        return optionalAppointment.orElse(null);
    }

    @Override
    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment updateAppointment(Long id, Appointment appointment) throws AppointmentException {
        if (appointmentRepository.existsById(id)) {
            appointment.setId(id);
            return appointmentRepository.save(appointment);
        }
        return null;
    }

    @Override
    public boolean deleteAppointment(Long id) {
    	  if (appointmentRepository.existsById(id)) {
    		  Optional<Appointment> optionalAppointment = appointmentRepository.findById(id);
    		  appointmentRepository.deleteById(id);
    		  return true;
    	  }
    	  return false;
    }
}
