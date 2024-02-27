package com.example.springbootquiz.sale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesService {

    private final SalesRepository salesRepository;
    private final TransactionRepository transactionRepository;


    @Autowired
    public SalesService(SalesRepository salesRepository, TransactionRepository transactionRepository) {
        this.salesRepository = salesRepository;
        this.transactionRepository = transactionRepository;
    }

    public List<Sale> getAllSales() {
        return salesRepository.findAll();
    }

    public Sale createSale(Sale sale) {
        return salesRepository.save(sale);
    }

    public Sale updateSale(Long id, Sale updatedSale) {
        Sale existingSale = salesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Sale with id " + id + " not found"));

        existingSale.setCreationDate(updatedSale.getCreationDate());
        existingSale.setClient(updatedSale.getClient());
        existingSale.setSeller(updatedSale.getSeller());

        return salesRepository.save(existingSale);
    }

    public Transaction addTransactionToSale(Long saleId, Transaction transaction) {
        Sale sale = salesRepository.findById(saleId)
                .orElseThrow(() -> new IllegalArgumentException("Sale with id " + saleId + " not found"));
        transaction.setSale(sale);
        return transactionRepository.save(transaction);
    }

    public Transaction updateTransactionInSale(Long saleId, Long transactionId, Transaction updatedTransaction) {
        Sale sale = salesRepository.findById(saleId)
                .orElseThrow(() -> new IllegalArgumentException("Sale with id " + saleId + " not found"));
        Transaction existingTransaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new IllegalArgumentException("Transaction with id " + transactionId + " not found"));

        if (!existingTransaction.getSale().getId().equals(saleId)) {
            throw new IllegalArgumentException("Transaction with id " + transactionId + " does not belong to sale with id " + saleId);
        }
        existingTransaction.setProductName(updatedTransaction.getProductName());
        existingTransaction.setQuantity(updatedTransaction.getQuantity());
        existingTransaction.setPrice(updatedTransaction.getPrice());
        return transactionRepository.save(existingTransaction);
    }

    public void deleteTransactionFromSale(Long saleId, Long transactionId) {
        Sale sale = salesRepository.findById(saleId)
                .orElseThrow(() -> new IllegalArgumentException("Sale with id " + saleId + " not found"));
        Transaction existingTransaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new IllegalArgumentException("Transaction with id " + transactionId + " not found"));
        if (!existingTransaction.getSale().getId().equals(saleId)) {
            throw new IllegalArgumentException("Transaction with id " + transactionId + " does not belong to sale with id " + saleId);
        }

        transactionRepository.delete(existingTransaction);
    }
}
