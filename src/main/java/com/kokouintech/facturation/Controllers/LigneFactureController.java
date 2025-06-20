package com.kokouintech.facturation.Controllers;

import com.kokouintech.facturation.dto.LigneFactureDto;
import com.kokouintech.facturation.models.LigneFacture;
import com.kokouintech.facturation.services.implementations.LigneFactureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ligneFacture")
public class LigneFactureController {
    private final LigneFactureService ligneFactureService;

    public LigneFactureController(LigneFactureService ligneFactureService) {
        this.ligneFactureService = ligneFactureService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createLigneFacture(@RequestBody LigneFactureDto ligneFactureDto){
        return new ResponseEntity<>(ligneFactureService.createLigneFacture(ligneFactureDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LigneFacture>> getLigneFactures(){
        List<LigneFacture> ligneFacture = ligneFactureService.getLigneFactures();
        return ResponseEntity.ok(ligneFacture);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LigneFacture> getLigneFacture(@PathVariable Long id){
        LigneFacture ligneFacture = ligneFactureService.getLigneFacture(id);
        return ResponseEntity.ok(ligneFacture);

    }
}
