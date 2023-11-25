package com.accountable.gui;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private String currentUsername;

    public MainWindow(String username) {
        this.currentUsername = username;

        setTitle("Accountable - Main Window");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Budget", new BudgetPanel());
        tabbedPane.addTab("Expenses", new ExpensePanel());
        tabbedPane.addTab("Income", new IncomePanel());
        tabbedPane.addTab("Reports", new ReportPanel());
        SettingsPanel settingsPanel = new SettingsPanel(currentUsername);
        tabbedPane.addTab("Settings", settingsPanel);

        add(tabbedPane, BorderLayout.CENTER);

        // Apply the theme based on the user's settings
        settingsPanel.loadAndApplyTheme();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginWindow loginWindow = new LoginWindow();
            loginWindow.setVisible(true);
        });
    }
}
