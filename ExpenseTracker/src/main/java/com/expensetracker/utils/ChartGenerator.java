package com.expensetracker.utils;

import com.expensetracker.model.Database;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.sql.*;

public class ChartGenerator {
    public static void showCategoryChart() {
        DefaultPieDataset dataset = new DefaultPieDataset();

        String sql = "SELECT category, SUM(amount) as total FROM expenses GROUP BY category";
        try (Connection conn = Database.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                dataset.setValue(rs.getString("category"), rs.getDouble("total"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JFreeChart chart = ChartFactory.createPieChart("Expenses by Category", dataset, true, true, false);
        ChartPanel panel = new ChartPanel(chart);
        JFrame frame = new JFrame("Expense Analytics");
        frame.setContentPane(panel);
        frame.setSize(600, 400);
        frame.setVisible(true);
    }
}
