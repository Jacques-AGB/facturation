package com.kokouintech.facturation.Controllers;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.kokouintech.facturation.dto.ClientDto;
import com.kokouintech.facturation.dto.FactureDto;
import com.kokouintech.facturation.models.Client;
import com.kokouintech.facturation.models.Facture;
import com.kokouintech.facturation.services.implementations.ClientService;
import com.kokouintech.facturation.services.implementations.FactureService;
import com.kokouintech.facturation.services.implementations.PDFService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("facture")
public class FactureController {
    private final FactureService factureService;
    private final PDFService pdfService;

    public FactureController(FactureService factureService, PDFService pdfService) {
        this.factureService = factureService;
        this.pdfService = pdfService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createFacture(@RequestBody FactureDto factureDto){
        return new ResponseEntity<>(factureService.createFacture(factureDto), HttpStatus.CREATED);
    }

    @PostMapping("/generate/{id}")
    public ResponseEntity<Document> generateFacture(@PathVariable Long id) throws DocumentException, FileNotFoundException {
        return new ResponseEntity<Document>(pdfService.generateFacture(id), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Facture>> getFactures(){
        List<Facture> facture = factureService.getFactures();
        return ResponseEntity.ok(facture);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Facture> getFacture(@PathVariable Long id){
        Facture facture = factureService.getFacture(id);
        return ResponseEntity.ok(facture);

    }
}
