package gui;

import java.util.Locale;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewController {
	
	@FXML
	private TextField txtA;
	
	@FXML
	private TextField txtB;
	
	@FXML
	private TextField txtC;

	@FXML
	private Button btCalcular;

	@FXML
	private Label lblDelta;
	
	@FXML
	private Label lblRaiz;
	
	@FXML
	private Label lblX1;
	
	@FXML
	private Label lblX2;

	public void btOnCalcAction() {
		try {
			Locale.setDefault(Locale.US);
			double a = Double.parseDouble(txtA.getText());
			double b = Double.parseDouble(txtB.getText());
			double c = Double.parseDouble(txtC.getText());

			double delta = Math.pow(-b, 2) - 4 * a * c;

			if (delta < 0) {
				lblDelta.setText(String.format("%.2f", delta));
				lblRaiz.setText("As Raízes são complexas");
				double p1 = -b / 2 * a;
				double p2 = Math.sqrt(-delta) / 2 * a;
				lblX1.setText(String.format("%.2f", p1) + "+" + String.format("%.2f", p2) + "j");
				lblX2.setText(String.format("%.2f", p1) + "-" + String.format("%.2f", p2) + "j");
			} else if (delta > 0) {
				lblDelta.setText(String.format("%.2f", delta));
				lblRaiz.setText("As Raízes são reais");
				double x1 = (-b + Math.sqrt(delta)) / (2 * a);
				lblX1.setText(String.format("%.2f", x1));
				double x2 = (-b - Math.sqrt(delta)) / (2 * a);
				lblX2.setText(String.format("%.2f", x2));
			} else {
				lblDelta.setText(String.format("%.2f", delta));
				lblRaiz.setText("As Raízes são reais e iguais");
				double x1 = (-b + Math.sqrt(delta)) / (2 * a);
				lblX1.setText(String.format("%.2f", x1));
				double x2 = (-b - Math.sqrt(delta)) / (2 * a);
				lblX2.setText(String.format("%.2f", x2));
			}

		} catch (NumberFormatException e) {
			Alerts.showAlert("Error", null, e.getMessage(), AlertType.ERROR);
		}
	}
	
}
