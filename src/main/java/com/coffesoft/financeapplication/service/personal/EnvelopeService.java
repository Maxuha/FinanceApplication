package com.coffesoft.financeapplication.service.personal;

import com.coffesoft.financeapplication.exception.EnvelopeNotFoundException;
import com.coffesoft.financeapplication.exception.NotFoundException;
import com.coffesoft.financeapplication.model.personal.Envelope;

import java.util.List;

public interface EnvelopeService {
    List<Envelope> findAllEnvelope();
    List<Envelope> findByUserIdEnvelope(Long userId) throws NotFoundException;
    Envelope findByIdEnvelope(Long id) throws EnvelopeNotFoundException;
    Envelope saveEnvelope(Envelope envelope) throws NotFoundException;
    Envelope updateEnvelope(Envelope envelope)  throws EnvelopeNotFoundException;
    void deleteEnvelope(Envelope envelope)  throws EnvelopeNotFoundException;
}
