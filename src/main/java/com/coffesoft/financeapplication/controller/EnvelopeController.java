package com.coffesoft.financeapplication.controller;

import com.coffesoft.financeapplication.exception.EnvelopeNotFoundException;
import com.coffesoft.financeapplication.exception.NotFoundException;
import com.coffesoft.financeapplication.model.personal.Envelope;
import com.coffesoft.financeapplication.service.personal.EnvelopeService;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnvelopeController {
    private static final Logger logger = Logger.getLogger(EnvelopeController.class);
    private final EnvelopeService envelopeService;

    public EnvelopeController(EnvelopeService envelopeService) {
        this.envelopeService = envelopeService;
    }

    @GetMapping(value = "/envelope", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Envelope>> getAll() {
        return new ResponseEntity<>(envelopeService.findAllEnvelope(), HttpStatus.OK);
    }

    @GetMapping(value = "/envelope/{envelopeId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Envelope> getById(@PathVariable Long envelopeId) {
        try {
            return new ResponseEntity<>(envelopeService.findByIdEnvelope(envelopeId), HttpStatus.OK);
        } catch (EnvelopeNotFoundException e) {
            logger.warn("Get request: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping(value = "/user/{userId}/envelope/", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Envelope>> getByUserId(@PathVariable Long userId) {
        try {
            return new ResponseEntity<>(envelopeService.findByUserIdEnvelope(userId), HttpStatus.OK);
        } catch (NotFoundException e) {
            logger.warn("Get request: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(value = "/envelope", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Envelope> create(@RequestBody Envelope envelope) throws NotFoundException {
        return new ResponseEntity<>(envelopeService.saveEnvelope(envelope), HttpStatus.OK);
    }

    @PutMapping(value = "/envelope", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Envelope> update(@RequestBody Envelope envelope) {
        try {
            return new ResponseEntity<>(envelopeService.updateEnvelope(envelope), HttpStatus.OK);
        } catch (EnvelopeNotFoundException e) {
            logger.warn("Put request: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping(value = "/envelope", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> delete(@RequestBody Envelope envelope) {
        try {
            envelopeService.deleteEnvelope(envelope);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EnvelopeNotFoundException e) {
            logger.warn("Delete request: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
