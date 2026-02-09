package com.creatio.crm.framework.utilities;

import java.io.FileInputStream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFUtil {

	// Common method to read the data from PDF file.
	public static String readPDF(String fileName, int startPage, int endPage) {

		// Create a variable to store the data from PDF files.
		String pdfData = "";

		try {

			// Read the PDF file from the specific folder.
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\Files\\" + fileName);

			// Load the file into PDDocument class to analyze the PDF file.
			PDDocument document = PDDocument.load(fis);

			// Extract the text from the PDF file using PDFTextStripper class by specifying the start page and end page.
			PDFTextStripper pdf = new PDFTextStripper();
			pdf.setStartPage(startPage);
			pdf.setEndPage(endPage);

			// Get the data
			pdfData = pdf.getText(document);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return pdfData;
	}

}
