package com.expensetracker.utils;

import com.expensetracker.model.Expense;
import java.io.FileWriter;
import java.util.List;

public class CSVExporter {
    public static void exportToCSV(List<Expense> expenses, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("ID,Category,Amount,Date,Description\n");
            for (Expense e : expenses) {
                writer.write(e.getId() + "," + e.getCategory() + "," + e.getAmount() + "," + e.getDate() + "," + e.getDescription() + "\n");
            }
            System.out.println("✅ Data exported successfully to " + filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
