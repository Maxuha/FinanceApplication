package com.coffesoft.financeapplication.controller;

import com.coffesoft.financeapplication.exception.MaskedPanMonoNotFoundException;
import com.coffesoft.financeapplication.model.monobank.MaskedPanMono;
import com.coffesoft.financeapplication.service.monobank.MaskedPanMonoService;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MaskedPanMonoController {
    private static final Logger logger = Logger.getLogger(WalletController.class);
    private final MaskedPanMonoService maskedPanMonoService;

    public MaskedPanMonoController(MaskedPanMonoService maskedPanMonoService) {
        this.maskedPanMonoService = maskedPanMonoService;
    }

    @GetMapping(value = "/mono/masked-pan", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<MaskedPanMono>> getAll() {
        return new ResponseEntity<>(maskedPanMonoService.findAllMaskedPanMono(), HttpStatus.OK);
    }

    @GetMapping(value = "/mono/masked-pan/{maskedPanMonoId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<MaskedPanMono> getById(@PathVariable Long maskedPanMonoId) {
        try {
            return new ResponseEntity<>(maskedPanMonoService.findByIdMaskedPanMono(maskedPanMonoId), HttpStatus.OK);
        } catch (MaskedPanMonoNotFoundException e) {
            logger.warn("Get request: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(value = "/mono/masked-pan", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<MaskedPanMono> create(@RequestBody MaskedPanMono maskedPanMono) {
        try {
            return new ResponseEntity<>(maskedPanMonoService.saveMaskedPanMono(maskedPanMono), HttpStatus.OK);
        } catch (MaskedPanMonoNotFoundException e) {
            logger.warn("Post request: " + e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(value = "/mono/masked-pans", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<MaskedPanMono>> createForAccountMono(@RequestBody List<MaskedPanMono> accountMonoList) {
        try {
            return new ResponseEntity<>(maskedPanMonoService.saveMaskedPanMonoListForAccountMono(accountMonoList), HttpStatus.OK);
        } catch (MaskedPanMonoNotFoundException e) {
            logger.warn("Post request: " + e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/mono/masked-pan", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<MaskedPanMono> update(@RequestBody MaskedPanMono maskedPanMono) {
        try {
            return new ResponseEntity<>(maskedPanMonoService.updateMaskedPanMono(maskedPanMono), HttpStatus.OK);
        } catch (MaskedPanMonoNotFoundException e) {
            logger.warn("Put request: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping(value = "/mono/masked-pan", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> delete(@RequestBody MaskedPanMono maskedPanMono) {
        try {
            maskedPanMonoService.deleteMaskedPanMono(maskedPanMono);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (MaskedPanMonoNotFoundException e) {
            logger.warn("Delete request: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
