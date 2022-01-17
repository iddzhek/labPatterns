package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.util.Optional;
import java.util.function.Function;

public class Controller{

    @FXML
    private LineChart chart;

    @FXML
    private Label warningText;

    @FXML
    private TableView<DataTableColumn> table;

    @FXML
    private Button addButton;

    @FXML
    private Button delButton;

    @FXML
    private Button editButton;

    private final TableColumn<DataTableColumn, Double> xColumn;
    private final TableColumn<DataTableColumn, Double> yColumn;

    private final Function<Double, Double> function;
    private final ObservableList<DataTableColumn> list;
    private DataTableColumn selectDataTable;

    public Controller() {
        function = (x -> x*x);
        list = FXCollections.observableArrayList();
        xColumn = new TableColumn<DataTableColumn,Double>("xColumn");
        xColumn.setPrefWidth(100);
        xColumn.setCellValueFactory(new PropertyValueFactory<DataTableColumn, Double>("xColumn"));
        yColumn = new TableColumn<DataTableColumn,Double>("yColumn");
        yColumn.setPrefWidth(100);
        yColumn.setCellValueFactory(new PropertyValueFactory<DataTableColumn, Double>("yColumn"));
        yColumn.setEditable(false);
        yColumn.setSortable(false);
    }

    public void addData(Double x){
        list.add(new DataTableColumn(x, function));
        if (!chart.getData().isEmpty()){
            chart.getData().remove(0);
        }
        createChart(list);
    }

    public void createChart(ObservableList<DataTableColumn> list){
        XYChart.Series<String, Double> series = new XYChart.Series<>();
        list.stream().sorted().forEach(data-> series.getData()
                .add(new XYChart.Data<>(String.valueOf(data.getXColumn()), data.getYColumn())));
        chart.getData().addAll(series);
    }

    public void initialize() {
        addData(-3.0);
        addData(-2.0);
        addData(-1.0);
        addData(0.0);
        addData(1.0);
        addData(2.0);
        addData(3.0);

        table.setItems(list);
        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection)  -> {
            if (newSelection != null) {
                selectDataTable = newSelection;
                editButton.setDisable(false);
                delButton.setDisable(false);
            }
        });
        table.getColumns().addAll(xColumn, yColumn);
    }


    @FXML
    void addButton(MouseEvent event) {
        TextInputDialog textInputDialog = new Builder(0.0)
                .header("Add a point")
                .content("X:")
                .build();
        Optional<String> result = textInputDialog.showAndWait();
        if (result.isPresent()) {
            try {
                Double newXData = Double.valueOf(result.get());
                Optional<DataTableColumn> listData = list.stream().filter(data -> data.getXColumn() == newXData).findFirst();
                listData.ifPresentOrElse(
                        data -> {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Error");
                            alert.setHeaderText("The point exists");
                            alert.show();
                        },
                        () -> addData(newXData)
                );
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Value incorrect");
                alert.show();
            }
        }
    }

    @FXML
    void editButton(MouseEvent event) {
        TextInputDialog textInputDialog = new Builder(selectDataTable.getXColumn())
                .header("Editing a point")
                .content("X:")
                .build();
        textInputDialog.setResult(String.valueOf(selectDataTable.getXColumn()));
        Optional<String> result = textInputDialog.showAndWait();
        if (result.isPresent()) {
            try {
                Double newXData = Double.valueOf(result.get());
                Optional<DataTableColumn> listData = list.stream().filter(data -> data.getXColumn() == selectDataTable.getXColumn()).findFirst();
                listData.ifPresentOrElse(
                        data -> {
                            list.remove(data);
                            addData(newXData);
                        },
                        () -> {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Error");
                            alert.setHeaderText("The point exists");
                            alert.show();
                        }
                );
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Value incorrect");
                alert.show();
            }
        }
    }

    @FXML
    void delButton(MouseEvent event) {
        list.remove(selectDataTable);
        if (!chart.getData().isEmpty()){
            chart.getData().remove(0);
        }
        createChart(list);
    }

//    public double callFunction(String stringX){
//        x = Double.parseDouble(stringX);
//        y = x*x;
//        return y;
//    }
//
//    public String changeStringX(double coefficient){
//        double value = Double.parseDouble(stringX);
//        value-=coefficient;
//        setChangeStringX(String.valueOf(value));
//        return getChangeStringX();
//    }

//    public boolean checkInputText(){
//        warningText.setText("");
//        setStringX(inputTextField.getText());
//        Pattern validEditingState = Pattern.compile("-?(([1-9][0-9]*)|0)?(\\.[0-9]*)?");
//        if (!validEditingState.matcher(stringX).matches() | stringX.isEmpty()){
//            warningText.setText("Enter only numbers!");
//            return false;
//        }
//        if(inputTextField.getLength() >=5){
//            warningText.setText("Enter fewer characters!");
//            return false;
//        }
//        return true;
//    }

    private static class Builder {

        private final TextInputDialog dialog;

        public Builder(Double defaultInputValue) {
            dialog = new TextInputDialog(String.valueOf(defaultInputValue));
        }

        public Builder header(String header) {
            dialog.setHeaderText(header);
            return this;
        }

        public Builder content(String content) {
            dialog.setContentText(content);
            return this;
        }

        public TextInputDialog build() {
            return dialog;
        }
    }
}

