package com.expensetracker.controller;

import com.expensetracker.model.Database;
import com.expensetracker.model.Expense;
import com.expensetracker.utils.CSVExporter;
import com.expensetracker.utils.ChartGenerator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;

public class ExpenseController {

    @FXML private TextField categoryField, amountField, descriptionField;
    @FXML private DatePicker datePicker;
    @FXML private TableView<Expense> expenseTable;
    @FXML private TableColumn<Expense, String> categoryCol, dateCol, descriptionCol;
    @FXML private TableColumn<Expense, Double> amountCol;

    private ObservableList<Expense> expenses;

    @FXML
    public void initialize() {
        // Create table if not exists
        Database.createTableIfNotExists();

        // Set up TableView columns to map to Expense properties
        categoryCol.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getCategory()));
        amountCol.setCellValueFactory(cellData -> new javafx.beans.property.SimpleObjectProperty<>(cellData.getValue().getAmount()));
        dateCol.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getDate()));
        descriptionCol.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getDescription()));

        // Load data from database
        expenses = FXCollections.observableArrayList(Database.getAllExpenses());
        expenseTable.setItems(expenses);
    }

    @FXML
    private void addExpense() {
        try {
            String category = categoryField.getText();
            double amount = Double.parseDouble(amountField.getText());
            String date = datePicker.getValue() != null ? datePicker.getValue().toString() : LocalDate.now().toString();
            String description = descriptionField.getText();

            Expense e = new Expense(category, amount, date, description);

            // Add to database
            Database.addExpense(e);

            // Add directly to ObservableList so TableView updates immediately
            expenses.add(e);

            // Clear input fields
            categoryField.clear();
            amountField.clear();
            descriptionField.clear();
            datePicker.setValue(null);

        } catch (NumberFormatException nfe) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Amount must be a number", ButtonType.OK);
            alert.showAndWait();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void showChart() {
        ChartGenerator.showCategoryChart();
    }

    @FXML
    private void exportCSV() {
        CSVExporter.exportToCSV(Database.getAllExpenses(), "expenses.csv");
    }
}
