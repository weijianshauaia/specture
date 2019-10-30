package cn.edu.pku.controllers;

import cn.edu.pku.dao.FileDao;
import cn.edu.pku.ui.AboutDialog;
import cn.edu.pku.ui.WelcomeStage;
import cn.edu.pku.controllers.TabController;
import cn.edu.pku.util.OpenFileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class IndexController {
	final String __indexpath = "/view/Index.fxml";
	final String __iconpath = "/images/cas.png";
	@FXML
	private javafx.scene.layout.VBox root;

	@FXML
	private javafx.scene.control.TabPane tabPane;

	@FXML
	private javafx.scene.layout.VBox filterBox;

	private FileDao fileDao;
	private File sourceFile;
	private String defaultDirectory = ".";
	private Stage stage;

	@FXML
	private void closeWindowsAction() {
		Platform.exit();
	}

	@FXML
	private void openFileAction(ActionEvent ae) {

		Window window = (Stage)root.getScene().getWindow();

		sourceFile = OpenFileUtils.open(window, defaultDirectory);

		if(sourceFile != null){

			// Update the latest directory as defaultDirectory
			defaultDirectory = sourceFile.toString() + "/..";

			// Get series from file
			fileDao = new FileDao(sourceFile);
			XYChart.Series<Number, Number> series = fileDao.read();

			// Create TabController and then add Tab
			TabController tab = new TabController(series,tabPane);
			tab.setText(sourceFile.getName());
			tabPane.getTabs().add(tab);
			fileDao.setTabPane(tabPane);  // set THE tabpane to dao package

		} // end of if

	}

	@FXML
	private void saveAction(ActionEvent ae) {
		fileDao.write(sourceFile);
	}

	@FXML
	private void saveAsAction(ActionEvent ae) {

		// Get selected tab
		TabController tab = getCurrentTab();
		LineChart<Number, Number> linechart = tab.getLineChart();

		SaveController oSaveController = new SaveController(linechart.getData().get(0)) ;
		oSaveController.primaryProcess();

	}
	//调用外部软件
		@FXML
		void MScert(ActionEvent event) throws IOException, InterruptedException {
			Runtime r=Runtime.getRuntime();
			//Process p=r.exec("E:/prote/MSConvertGUI.exe");//����Ҫ����ע��
			Process p=r.exec("C:/Program Files/ProteoWizard/ProteoWizard/MSConvertGUI.exe");//����Ҫ����ע��
			//Process p=r.exec("E:/prote/MSConvertGUI.exe");//����Ҫ����ע��
			InputStream is=p.getInputStream();
			InputStreamReader ir=new InputStreamReader(is);
			BufferedReader br=new BufferedReader(ir);
			String str=null;
			while((str=br.readLine())!=null){
			System.out.println(str);
		}
		//��ȡ���̵ķ���ֵ,Ϊ0����,Ϊ2��������
	    int ret=p.waitFor();
	    int exit_v=p.exitValue();
	    System.out.println("return value:"+ret);
	   System.out.println("exit value:"+exit_v);
		    }
		//获取当前光谱数据
		@FXML
		void DataOpen(ActionEvent event) throws IOException, InterruptedException {
		    String cmd = "cmd /c start C:/Users/S0047/Desktop/sp/start.bat";//网易音乐安装目录E:/wyyyy/CloudMusic/
	         try {
	             Process ps = Runtime.getRuntime().exec(cmd);
	             ps.waitFor();
	         } catch (IOException ioe) {
	             ioe.printStackTrace();
	         }
	         catch (InterruptedException e) {
	             e.printStackTrace();
	         }
	         System.out.println("传输脚本");
	      
	       


			//Runtime r1=Runtime.getRuntime();
			//Process p=r.exec("E:/prote/MSConvertGUI.exe");//����Ҫ����ע��
			//Process p1=r1.exec("C:/Users/hasee/Desktop/socket.exe");//����Ҫ����ע��
			//Process p=r.exec("E:/prote/MSConvertGUI.exe");//����Ҫ����ע��
		/*	InputStream is1=p1.getInputStream();
			InputStreamReader ir1=new InputStreamReader(is1);
			BufferedReader br=new BufferedReader(ir1);
			String str1=null;
			while((str1=br.readLine())!=null){
			System.out.println(str1);
		}
		//��ȡ���̵ķ���ֵ,Ϊ0����,Ϊ2��������
	    int ret1=p1.waitFor();
	    int exit_v1=p1.exitValue();
	    System.out.println("return value:"+ret1);
	   System.out.println("exit value:"+exit_v1);*/
		    }
		@FXML
		void BKDataOpen(ActionEvent event) throws IOException, InterruptedException {
		    String cmd = "cmd /c start C:/Users/S0047/Desktop/sp/start_2.bat";//网易音乐安装目录E:/wyyyy/CloudMusic/
	         try {
	             Process ps = Runtime.getRuntime().exec(cmd);
	             ps.waitFor();
	         } catch (IOException ioe) {
	             ioe.printStackTrace();
	         }
	         catch (InterruptedException e) {
	             e.printStackTrace();
	         }
	         System.out.println("背景传输脚本");
	      
		    }
		@FXML
		void Datafinal(ActionEvent event) throws IOException, InterruptedException {
		    String cmd = "cmd /c start C:/Users/S0047/Desktop/sp/start_3.bat";//网易音乐安装目录E:/wyyyy/CloudMusic/
	         try {
	             Process ps = Runtime.getRuntime().exec(cmd);
	             ps.waitFor();
	         } catch (IOException ioe) {
	             ioe.printStackTrace();
	         }
	         catch (InterruptedException e) {
	             e.printStackTrace();
	         }
	         System.out.println("背景传输脚本");
	      
		    }
		@FXML
		void DataClose(ActionEvent event) throws IOException, InterruptedException {
		    String cmd = "cmd /c start C:/Users/S0047/Desktop/sp/close.bat";//
		    
	         try {
	             Process ps = Runtime.getRuntime().exec(cmd);
	             ps.waitFor();
	         } catch (IOException ioe) {
	             ioe.printStackTrace();
	         }
	         catch (InterruptedException e) {
	             e.printStackTrace();
	         }
	         System.out.println("传输脚本");
	      
	       


			//Runtime r1=Runtime.getRuntime();
			//Process p=r.exec("E:/prote/MSConvertGUI.exe");//����Ҫ����ע��
			//Process p1=r1.exec("C:/Users/hasee/Desktop/socket.exe");//����Ҫ����ע��
			//Process p=r.exec("E:/prote/MSConvertGUI.exe");//����Ҫ����ע��
		/*	InputStream is1=p1.getInputStream();
			InputStreamReader ir1=new InputStreamReader(is1);
			BufferedReader br=new BufferedReader(ir1);
			String str1=null;
			while((str1=br.readLine())!=null){
			System.out.println(str1);
		}
		//��ȡ���̵ķ���ֵ,Ϊ0����,Ϊ2��������
	    int ret1=p1.waitFor();
	    int exit_v1=p1.exitValue();
	    System.out.println("return value:"+ret1);
	   System.out.println("exit value:"+exit_v1);*/
		    }
    @FXML
    void about(ActionEvent event) {
        AboutDialog aboutDialog = new AboutDialog(stage);
        aboutDialog.showAbout();
    }
    @FXML 
    void DataTime(ActionEvent event){
    	Stage secondStage = new Stage();
    	secondStage.setTitle("设置积分时间/秒");
       /* Label label_data = new Label("积分时间设置(秒)"); // 放一个标签
      
        label_data.setTranslateY(-40);
        label_data.setFont(new Font("Cambria", 32));
        TextField textField = new TextField ();
        textField.setPrefWidth(5.0);
        字体缩放效果
 * label_data.setOnMouseEntered((MouseEvent e) -> {
            label_data.setScaleX(1.5);
            label_data.setScaleY(1.5);
        });
         
        label_data.setOnMouseExited((MouseEvent e) -> {
            label_data.setScaleX(1);
            label_data.setScaleY(1);
        });
        HBox hb = new HBox();
        hb.getChildren().addAll(label_data, textField);
        hb.setSpacing(10);*/
    	GridPane grid = new GridPane();
    	grid.setPadding(new Insets(10, 10, 10, 10));
    	grid.setVgap(5);
    	grid.setHgap(5);
    	//设置积分时间标签
    	//Defining the Name text field 设置积分时间
    	
    	final TextField name = new TextField();
    	name.setPromptText("设置积分时间.");
    	name.setPrefColumnCount(10);
    	name.getText();
    	GridPane.setConstraints(name, 0, 0);
    	grid.getChildren().add(name);	
    	//Defining the Submit button
    	Button submit = new Button("确认");
    	GridPane.setConstraints(submit, 1, 0);
    	grid.getChildren().add(submit);
    	//Defining the Clear button
    	Button clear = new Button("Clear");
    	GridPane.setConstraints(clear, 1, 1);
    	grid.getChildren().add(clear);
    	
        StackPane secondPane = new StackPane(grid);
        Scene secondScene = new Scene(secondPane, 330, 100);
        secondStage.setScene(secondScene);
        secondStage.show();
    }

    TabController getCurrentTab(){
    	System.out.println("Tab:"+ (TabController) tabPane.getSelectionModel().getSelectedItem());
    	return (TabController) tabPane.getSelectionModel().getSelectedItem();
    }



    /*
     * @FXML
     * filter parameters listener : set parameters' values
     * 1. Set parameters
     * 2. re-calculate output, which is restart the filters of the linechart by order
     *
     * DETAILS
     * 1. Choose the right filter in the filter list to set its parameters' value
     * 2. Re-calculate and order by filter list
     * */

    /*
    void print( LineChart<Number, Number> linechart ) {
    	for (int i = 0; i < linechart.getData().size(); i++) {
			XYChart.Series<Number, Number> series = linechart.getData().get(i);
			for (int j = 0; j < series.getData().size(); j++) {
				 System.out.println( j+1 + ". " + series.getData().get(j).getXValue() +"," + series.getData().get(j).getYValue());
			}
		}
    }
     */
}
