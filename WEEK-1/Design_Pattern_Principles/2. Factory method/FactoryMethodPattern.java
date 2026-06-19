public class FactoryMethodPattern {

    // Document interface
    interface Document {
        void open();
    }

    // Concrete document classes

    static class WordDocument implements Document {

        public void open() {
            System.out.println("Word document created.");
        }
    }

    static class PdfDocument implements Document {

        public void open() {
            System.out.println("PDF document created.");
        }
    }

    static class ExcelDocument implements Document {

        public void open() {
            System.out.println("Excel document created.");
        }
    }

    // Abstract factory

    static abstract class DocumentFactory {

        public abstract Document createDocument();
    }

    // Concrete factories

    static class WordFactory extends DocumentFactory {

        public Document createDocument() {
            return new WordDocument();
        }
    }

    static class PdfFactory extends DocumentFactory {

        public Document createDocument() {
            return new PdfDocument();
        }
    }

    static class ExcelFactory extends DocumentFactory {

        public Document createDocument() {
            return new ExcelDocument();
        }
    }

    public static void main(String[] args) {

        DocumentFactory wordFactory = new WordFactory();
        DocumentFactory pdfFactory = new PdfFactory();
        DocumentFactory excelFactory = new ExcelFactory();

        Document word = wordFactory.createDocument();
        Document pdf = pdfFactory.createDocument();
        Document excel = excelFactory.createDocument();

        word.open();
        pdf.open();
        excel.open();
    }
}