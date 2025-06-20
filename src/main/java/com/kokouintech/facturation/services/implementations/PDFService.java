package com.kokouintech.facturation.services.implementations;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.kokouintech.facturation.models.Facture;
import com.kokouintech.facturation.repositories.FactureRepository;
import com.kokouintech.facturation.services.interfaces.IPDFService;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class PDFService implements IPDFService {

    private FactureRepository factureRepository;

    public  Long id;

    public PDFService(FactureRepository factureRepository) {
        this.factureRepository = factureRepository;
    }

    @Override
    public Document generateFacture(Long id) throws FileNotFoundException, DocumentException {

        Optional<Facture> optFacture = factureRepository.findById(id);

        Facture facture = optFacture.get();
        Document doc = new Document();

        PdfWriter.getInstance(doc, new FileOutputStream("Facture"+ LocalDate.now() +".pdf"));

        doc.open();

        Paragraph par = new Paragraph("Facture ");
        par.setAlignment(Element.ALIGN_CENTER);

        Paragraph espace = new Paragraph("\n");
        doc.add(espace);
        doc.add(par);

        Paragraph par1 = new Paragraph("Nom :  " + facture.getClient().getNom());
        Paragraph par2 = new Paragraph(" Facture numéro : " + facture.getReference());
        doc.add(espace);
        doc.add(espace);
        doc.add(par1);
        doc.add(par2);

        PdfPTable table = new PdfPTable(3);
        doc.add(espace);
        doc.add(espace);
        tableHeader(table);
        addRow(table,facture);

        doc.add(table);
        doc.add(espace);
        Paragraph totalHT = new Paragraph("Total HT : " + facture.getTotalHT() + " €");
        Paragraph totalTVA = new Paragraph("TVA : " + facture.getTotalTVA() + " €");
        Paragraph totalTTC = new Paragraph("Total TTC : " + facture.getTotalTTC() + " €");

        totalHT.setAlignment(Element.ALIGN_RIGHT);
        totalTVA.setAlignment(Element.ALIGN_RIGHT);
        totalTTC.setAlignment(Element.ALIGN_RIGHT);

        doc.add(totalHT);
        doc.add(totalTVA);
        doc.add(totalTTC);


        doc.close();
        return null;
    }

    private static void tableHeader (PdfPTable table){
        Stream.of("Description","Quantite", "PrixUnitaire HT").forEach(title ->{
            PdfPCell header = new PdfPCell();
            header.setBackgroundColor(BaseColor.LIGHT_GRAY);
            header.setBorderWidth(1);
            header.setPhrase(new Phrase(title));
            table.addCell(header);
        });
    }

    private static void addRow (PdfPTable table, Facture facture){
        facture.getLignes().forEach(ligneFacture -> {
            table.addCell(ligneFacture.getDescription());
            table.addCell(String.valueOf(ligneFacture.getQuantite()));
            table.addCell(String.valueOf(ligneFacture.getPrixUnitaireHT()));

        });

    }



}
