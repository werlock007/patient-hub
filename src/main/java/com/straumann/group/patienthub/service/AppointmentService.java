package com.straumann.group.patienthub.service;

import com.straumann.group.patienthub.entity.Appointment;
import com.straumann.group.patienthub.exception.AppointmentException;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface AppointmentService {
    List<Appointment> getAllAppointments();
    Appointment getAppointmentById(Long id);
    Appointment createAppointment(Appointment appointment);
    Appointment updateAppointment(Long id, Appointment appointment) throws AppointmentException;
    boolean deleteAppointment(Long id);
}
