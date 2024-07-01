package panafie.fie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import panafie.fie.dto.CalendarDTO;
import panafie.fie.model.calendar.Calendar;
import panafie.fie.model.user.User;
import panafie.fie.repository.CalendarRepository;
import panafie.fie.repository.UserRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/calendars")
public class CalendarController {

    @Autowired
    private CalendarRepository calendarRepository;

    @Autowired
    private UserRepository userRepository;

    // Historia # GCO-04 - Programar fechas de pago
    // Programar una fecha de pago
    @PostMapping("/schedule")
    public ResponseEntity<String> schedulePaymentDate(@RequestBody CalendarDTO calendarDTO) {
        User user = userRepository.findById(calendarDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (calendarDTO.getPaymentDate().after(calendarDTO.getMaximumPaymentDate())) {
            return ResponseEntity.status(400).body("Error: La fecha de pago no puede ser posterior a la fecha máxima de pago.");
        }

        Calendar calendar = new Calendar();
        calendar.setUserId(user);
        calendar.setPaymentDate(calendarDTO.getPaymentDate());
        calendar.setMaximumPaymentDate(calendarDTO.getMaximumPaymentDate());
        calendar.setAmount(calendarDTO.getAmount());

        calendarRepository.save(calendar);

        return ResponseEntity.ok("Fecha de pago programada exitosamente para el usuario: " +
                user.getName()+ " " + user.getLastName()+ ", Monto: " + calendar.getAmount());
    }

    // Historia # GCO-01 - Visualización del calendario de pagos
    // Ver todos los calendarios
    @PostMapping("/view")
    public ResponseEntity<List<Calendar>> viewAllCalendars() {
        List<Calendar> calendars = calendarRepository.findAll();
        if (calendars.isEmpty()) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.ok(calendars);
    }

    // Historia # GCO-01 - Visualización del calendario de pagos
    // Ver detalles de un calendario
    @PostMapping("/details/{id}")
    public ResponseEntity<String> viewCalendarDetails(@PathVariable Long id) {
        Optional<Calendar> calendar = calendarRepository.findById(id);
        return calendar.map(cal -> ResponseEntity.ok("Detalles del calendario: Usuario: " +
                cal.getUserId().getName()+ " " + cal.getUserId().getLastName()+ ", Fecha de pago: " +
                cal.getPaymentDate() + ", Monto: " + cal.getAmount()))
                .orElseGet(() -> ResponseEntity.status(404).body("Calendario no encontrado."));
    }

    // Supervisar actividades de los jugadores
    /*@PostMapping("/supervise")
    public ResponseEntity<List<Calendar>> superviseActivities(@RequestParam String filter) {
        List<Calendar> calendars;
        switch (filter) {
            case "incompleto":
                calendars = calendarRepository.findByEstado("incompleto");
                break;
            case "atrasado":
                calendars = calendarRepository.findByPaymentDateBefore(new Date());
                break;
            case "todos":
            default:
                calendars = calendarRepository.findAll();
                break;
        }
        if (calendars.isEmpty()) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.ok(calendars);
    }*/
}
