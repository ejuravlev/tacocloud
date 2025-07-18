package ru.ejuravlev.tacocloud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import ru.ejuravlev.tacocloud.models.TacoOrder;

import org.springframework.web.bind.annotation.PostMapping;
import ru.ejuravlev.tacocloud.repository.OrderRepository;


@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {
    private OrderRepository orderRepo;

    public OrderController(OrderRepository orderRepo) {
      this.orderRepo = orderRepo;
    }

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder order, Errors errors, SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            log.error("invalid order model: {}", errors.toString());
            return "orderForm";
        }
        orderRepo.save(order);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
