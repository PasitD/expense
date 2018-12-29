import javafx.collections.ObservableList;

public interface Connector {
    ObservableList<History> viewHistory();
    void add(String type, String money, String description);
}
