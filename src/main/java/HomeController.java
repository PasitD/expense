import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class HomeController {
    private Connector connector;
    private Account account;

    @FXML
    protected Label totalMoneyLabel, alertLabel;
    @FXML
    protected TextField moneyField, descriptionField;
    @FXML
    TableView<History> tableView;
    @FXML
    TableColumn moneyCol, descriptionCol;

    public void initialize(){
        account = new Account();
        connector = DBConnector.getInstance();

        descriptionCol.setCellValueFactory(new PropertyValueFactory<History, String>("description"));
        moneyCol.setCellValueFactory(new PropertyValueFactory<History, String>("money"));
        tableView.setItems(connector.viewHistory());
        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<History>() {
            @Override
            public void changed(ObservableValue<? extends History> observable, History oldValue, History newValue) {

            }
        });

        totalMoneyLabel.setText("Total Money: 0");
    }

    @FXML
    public void actionExpenseBtn(ActionEvent event){
        alertLabel.setVisible(false);
        try {
            String money = moneyField.getText();
            String description = descriptionField.getText();
            account.expense(Double.parseDouble(money),description);
            connector.add("Expense", "-" + money,  description);
            moneyField.clear();
            descriptionField.clear();
            tableView.setItems(connector.viewHistory());
            displayTotal();
        }
        catch (Exception e){
            alertLabel.setVisible(true);
            moneyField.clear();
            descriptionField.clear();
            alertLabel.setText("Money must be number.");
            System.err.println("Money must be number.");
        }
    }

    @FXML
    public void actionIncomeBtn(ActionEvent event){
        alertLabel.setVisible(false);
        try {
            String money = moneyField.getText();
            String description = descriptionField.getText();
            account.income(Double.parseDouble(money),description);
            connector.add("Income", "+" + money,  description);
            moneyField.clear();
            descriptionField.clear();
            tableView.setItems(connector.viewHistory());
            displayTotal();
        }
        catch (Exception e){
            alertLabel.setVisible(true);
            alertLabel.setText("Money must be number.");
            moneyField.clear();
            descriptionField.clear();
            System.err.println("Money must be number.");
        }
    }

    public void displayTotal(){
        double total = 0;
        for (History i : connector.viewHistory()) {
            if (i.getType().equals("Income")) {
                total += Double.valueOf(i.getMoney().substring(1).trim());
            }
            else if (i.getType().equals("Expense")) {
                total -= Double.valueOf(i.getMoney().substring(1).trim());
            }
        }
        System.out.println(total);
        totalMoneyLabel.setText("Total Money: "+ total);
    }
}
