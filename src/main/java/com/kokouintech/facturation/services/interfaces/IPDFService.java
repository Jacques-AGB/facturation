package com.kokouintech.facturation.services.interfaces;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;

import java.io.FileNotFoundException;

public interface IPDFService {

    public Document generateFacture(Long id) throws FileNotFoundException, DocumentException;
}
