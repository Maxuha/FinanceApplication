package com.coffesoft.financeapplication.service.personal;

import com.coffesoft.financeapplication.exception.EnvelopeNotFoundException;
import com.coffesoft.financeapplication.exception.NotFoundException;
import com.coffesoft.financeapplication.model.monobank.AccountMono;
import com.coffesoft.financeapplication.model.monobank.UserMono;
import com.coffesoft.financeapplication.model.personal.Envelope;
import com.coffesoft.financeapplication.model.personal.UserCard;
import com.coffesoft.financeapplication.model.system.Wallet;
import com.coffesoft.financeapplication.repository.personal.EnvelopeRepository;
import com.coffesoft.financeapplication.service.monobank.AccountMonoService;
import com.coffesoft.financeapplication.service.monobank.UserMonoService;
import com.coffesoft.financeapplication.service.system.WalletService;
import com.coffesoft.financeapplication.util.CalculatePercent;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnvelopeServiceImpl implements EnvelopeService {
    private final EnvelopeRepository envelopeRepository;
    private final CalculatePercent calculatePercent;
    private final AccountMonoService accountMonoService;
    private final UserMonoService userMonoService;
    private final UserCardService userCardService;
    private final WalletService walletService;

    public EnvelopeServiceImpl(EnvelopeRepository envelopeRepository, CalculatePercent calculatePercent, AccountMonoService accountMonoService, UserMonoService userMonoService, UserCardService userCardService, WalletService walletService) {
        this.envelopeRepository = envelopeRepository;
        this.calculatePercent = calculatePercent;
        this.accountMonoService = accountMonoService;
        this.userMonoService = userMonoService;
        this.userCardService = userCardService;
        this.walletService = walletService;
    }

    @Override
    public List<Envelope> findAllEnvelope() {
        return envelopeRepository.findAll();
    }

    @Override
    public List<Envelope> findByUserIdEnvelope(Long userId) {
        return envelopeRepository.findByUserId(userId);
    }

    @Override
    public Envelope findByIdEnvelope(Long id) throws EnvelopeNotFoundException {
        Optional<Envelope> envelopeDb = envelopeRepository.findById(id);
        return envelopeDb.orElseThrow(() -> new EnvelopeNotFoundException(id));
    }

    @Override
    public Envelope saveEnvelope(Envelope envelope) throws NotFoundException {
        return envelopeRepository.save(calculationBalanceToEnvelope(envelope));
    }

    @Override
    public Envelope updateEnvelope(Envelope envelope) throws EnvelopeNotFoundException {
        Optional<Envelope> envelopeDb = envelopeRepository.findById(envelope.getId());
        if (envelopeDb.isPresent()) {
            return envelopeRepository.save(envelope);
        }
        throw new EnvelopeNotFoundException(envelope.getId());
    }

    @Override
    public void deleteEnvelope(Envelope envelope) throws EnvelopeNotFoundException {
        envelopeRepository.delete(findByIdEnvelope(envelope.getId()));
    }

    private Envelope calculationBalanceToEnvelope(Envelope envelope) throws NotFoundException {
        List<AccountMono> accountMonoList = accountMonoService.findByUserMonoIdAccountMono(envelope.getUser().getWallet().getUserCard().getUserMono().getId());
        Integer balance = 0;
        for (AccountMono accountMono : accountMonoList) {
            balance += accountMono.getBalance();
            balance -= accountMono.getCreditLimit();
        }
        envelope.setBalanceMax(calculatePercent.getValueForPercent(100, balance));
        envelope.setBalanceCurrent(calculatePercent.getValueForPercent(100, balance));
        return envelope;
    }
}
