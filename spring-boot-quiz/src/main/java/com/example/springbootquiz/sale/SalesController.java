package com.example.springbootquiz.sale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sales")
public class SalesController {

    private final SalesService salesService;

    @Autowired
    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    @GetMapping
    public List<Sale> getAllSales() {
        return salesService.getAllSales();
    }

    @PostMapping
    public Sale createSale(@RequestBody Sale sale) {
        return salesService.createSale(sale);
    }

    @PutMapping("/{id}")
    public Sale updateSale(@PathVariable Long id, @RequestBody Sale updatedSale) {
        return salesService.updateSale(id, updatedSale);
    }

    @PostMapping("/{saleId}/transactions")
    public Transaction addTransactionToSale(@PathVariable Long saleId, @RequestBody Transaction transaction) {
        return salesService.addTransactionToSale(saleId, transaction);
    }

    @PutMapping("/{saleId}/transactions/{transactionId}")
    public Transaction updateTransactionInSale(@PathVariable Long saleId, @PathVariable Long transactionId, @RequestBody Transaction updatedTransaction) {
        return salesService.updateTransactionInSale(saleId, transactionId, updatedTransaction);
    }

    @DeleteMapping("/{saleId}/transactions/{transactionId}")
    public ResponseEntity<?> deleteTransactionFromSale(@PathVariable Long saleId, @PathVariable Long transactionId) {
        salesService.deleteTransactionFromSale(saleId, transactionId);
        return ResponseEntity.ok().build();
    }
}
