import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;

public class FileConnector implements Connector {
    private static final String fileName = "history.txt";
    private static String line = null;

    private static final FileConnector instance = new FileConnector();

    static public FileConnector getInstance() {
        return instance;
    }

    private FileConnector() {}

    public ObservableList<History> viewHistory() {
        ObservableList<History> datas = FXCollections.observableArrayList();
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(" ");
                datas.add(new History(data[0], data[1], data[2]));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return datas;
    }

    public void add(String type, String money, String description) {
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(type + " " + money + " " + description);
            bufferedWriter.newLine();
            bufferedWriter.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
