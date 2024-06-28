/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package panafie.fie.controller;

/**
 *
 * @author alejandro.reyes
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import panafie.fie.dto.CalendarDTO;
import panafie.fie.model.calendar.Calendar;
import panafie.fie.model.user.User;
import panafie.fie.repository.CalendarRepository;
import panafie.fie.repository.UserRepository;

@RestController
@RequestMapping("/api/calendar")
public class CalendarController {

    @Autowired
    private CalendarRepository calendarRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<String> registerCalendar(@RequestBody CalendarDTO calendarDTO) {
        User user = userRepository.findById(calendarDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Calendar calendar = new Calendar();
        calendar.setUserId(user);
        calendar.setPaymentDate(calendarDTO.getPaymentDate());
        calendar.setMaximumPaymentDate(calendarDTO.getMaximumPaymentDate());
        calendar.setAmount(calendarDTO.getAmount());

        calendarRepository.save(calendar);

        return ResponseEntity.ok("Calendar registered successfully");
    }
}