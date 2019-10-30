package cn.edu.pku.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;

import cn.edu.pku.controllers.TabController;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class FileDao extends Dao<XYChart.Series<Number, Number>, File, LineChart<Number, Number>> {

	@FXML
	private javafx.scene.control.TabPane tabPane;

	File data = null;

	// Constructor
	public FileDao(File data) {
		this.data = data;
	}

	@Override
	public XYChart.Series<Number, Number> read() {

		XYChart.Series<Number, Number> series = new XYChart.Series<Number, Number>();
		series.setName("spectra Data");

		try {
			BufferedReader in = new BufferedReader(new FileReader(data));
			String tempString = null;
			//现在的情况是一次读一行 ，还有可能一行里有很多文件	
			// Read a line once a time, until the end of the file which is null
			
			while ((tempString = in.readLine()) != null) {
				if (!tempString.isEmpty() && Character.isDigit(tempString.charAt(0))) {
					// fake data from Internet
					// separate X-Axis and Y-Axis with ','
					 //String[] tmpString = tempString.split("\t|,");
					

					// 04/24 data structure test
					// separate X-Axis and Y-Axis with '\t'(tab)
					//String[] tmpString = tempString.split("[, \t]");
					//String[] tmpString = tempString.split("[,\t]");
					//String[] sArr=s2.split("[： ， ；]"); 例子
					String[] tmpString = tempString.split("[, \t]");
					//String[] tmpString = tempString.split("\t|,|\\\s");
					// Add data into series
				
					
					for(int i=0;i<tmpString.length-1;i+=2){
						series.getData().add(
							new XYChart.Data<>(Double.parseDouble(tmpString[i].trim()), Double.parseDouble(tmpString[i+1].trim())));
					}
					
				}
			}

			series.getData().sort(Comparator.comparingDouble(d -> d.getXValue().doubleValue()));
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return series;
	}

	@Override
	public void write(File data) {
		// TODO Auto-generated method stub
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(data));
			// 03/16, get the specific linechart from specific tab
			TabController tab = (TabController) tabPane.getSelectionModel().getSelectedItem();
			LineChart<Number, Number> linechart = tab.getLineChart();
			linechart.setTitle("RaMan");
			
			for (int i = 0; i < linechart.getData().size(); i++) {
				XYChart.Series<Number, Number> series = linechart.getData().get(i);
				for (int j = 0; j < series.getData().size(); j++) {
					// original data structure
					// out.write(series.getData().get(j).getXValue() + "," + series.getData().get(j).getYValue());

					// 04/24 true data structure
					out.write(series.getData().get(j).getXValue() + "\t" + series.getData().get(j).getYValue());
					out.newLine();
				}
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void write(File data, LineChart<Number, Number> lc) {
		// TODO Auto-generated method stub

		try {

			BufferedWriter out = new BufferedWriter(new FileWriter(data));

			for (int i = 0; i < lc.getData().size(); i++) {

				XYChart.Series<Number, Number> series = lc.getData().get(i);
				for (int j = 0; j < series.getData().size(); j++) {
					// original data structure
					// out.write(series.getData().get(j).getXValue() + "," + series.getData().get(j).getYValue());

					// 04/24 true data structure
					out.write(series.getData().get(j).getXValue() + "\t" + series.getData().get(j).getYValue());
					out.newLine();
				}

			}

			out.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void setTabPane(javafx.scene.control.TabPane tabPane) {
		this.tabPane = tabPane;
	}

	public javafx.scene.control.TabPane getTabPane() {
		return this.tabPane;
	}

}
