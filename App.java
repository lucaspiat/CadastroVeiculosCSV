import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
public class App {

	private static final String SAMPLE_CSV_FILE_PATH = "passengermock.csv";

	public static void main(String[] args) throws IOException {
        try (
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        ) {
            for (CSVRecord csvRecord : csvParser) {
                // Accessing Values by Column Index
                String cpf = csvRecord.get(0);
                String nome = csvRecord.get(1);
                String formPgto = csvRecord.get(2);
                String nrocartao = csvRecord.get(3);

                System.out.println("Record No - " + csvRecord.getRecordNumber());
                System.out.println("---------------");
                System.out.println("CPF : " + cpf);
                System.out.println("Nome : " + nome);
                System.out.println("Forma de Pagamento : " + formPgto);
                System.out.println("Numero Cartao : " + nrocartao);
                System.out.println("---------------\n\n");
            }
        }
    }

}
