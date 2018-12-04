package com.chigo.BSL;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

//import com.chigo.TOFcon.Consumer;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;

public class BSLController extends ChScraper implements Initializable{
	
    private final static int WT_AM = 2;
    private final static int ZERO_MINUTES = 0;
    private final static long ONCE_PER_DAY = 1000*60*60*24;
    private ScheduledExecutorService scheduledExecutorService;
    //private Consumer cn = new Consumer();
    //private Thread ty = new Thread(new Consumer());
    private exodus ex = new exodus();
    private volatile boolean started = true;
	
	

	   @FXML
	    private TableView<Currencies> tb1;
	    @FXML
	    private Button btn1;

	    @FXML
	    private TableColumn<Currencies, String> curr;
	    

	    @FXML
	    private ProgressIndicator pbar1;
	    

	    @FXML
	    private Label status;
    	

	    

	    @FXML
	    private TableColumn<Currencies, String> currBid;

	    @FXML
	    private TableColumn<Currencies, Double> lastBid;
	    
	    public ObservableList<Currencies> getAll(){
	    	
	    	//Consumer cons = new Consumer();
	    	status.setTextFill(javafx.scene.paint.Color.RED);
	    	//status.setText("Getting Currency names.");
	    	
	    	//status.setText("Getting Currency names..");
	    	//status.setText("Getting Currency names...");
	    	//status.setText("Getting Currency names.");
	    	//status.setText("Getting Currency names..");
	    	//status.setText("Getting Currency names...");
	    	
	    	
	    	
	    	ObservableList<Currencies> currData = FXCollections.observableArrayList();
	    	//Currencies(String name, String eikonBid, double webBid)
	    	/*
	    	try {
				TimeUnit.SECONDS.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
	    	currData.add(new Currencies(pound, Pound1, Consumer.VPound1));
	    	currData.add(new Currencies(canadian, Can1, Consumer.VCan1));
	    	currData.add(new Currencies(usdollar, USD1, Consumer.VUSD1));
	    	currData.add(new Currencies(swedish, Swede1, Consumer.VSwede1));
	    	currData.add(new Currencies(swissfranc, Swiss1, Consumer.VSwiss1));
	    	currData.add(new Currencies(japanese, YEN1, Consumer.VYEN1));
	    	currData.add(new Currencies(norweigian, Nor1, Consumer.VNor1));
	    	currData.add(new Currencies(euro, EUR1, Consumer.VEUR1));
	    	currData.add(new Currencies(danish, DAN1, Consumer.VDAN1));
	    	currData.add(new Currencies(australian, AUS1, Consumer.VAUS1));
	    	currData.add(new Currencies(saudiriyal, Saudi1, Consumer.VSaudi1));
	    	currData.add(new Currencies(kuwaitdinah, Kuwait1, Consumer.VKuwait1));
	    	currData.add(new Currencies(uae, UAE1, Consumer.VUAE1));
	    	currData.add(new Currencies(mzansi, Rand1, Consumer.VRand1));
	    	currData.add(new Currencies(chineserem, China1, Consumer.VChina1));
	    	currData.add(new Currencies(hongkong, HONG1, Consumer.VHONG1));
	    	currData.add(new Currencies(sdr, SDR1, Consumer.VSDR1));
	    	currData.add(new Currencies(cfafranc, CFA1, Consumer.VCFA1));
	    	currData.add(new Currencies(gambiandalasi, GMB1, Consumer.VGMB1));
	    	currData.add(new Currencies(guinean, GUI1, Consumer.VGUI1));
	    	currData.add(new Currencies(cedi, CEDI1, Consumer.VCEDI1));
	    	currData.add(new Currencies(naija, NGN1, Consumer.VNGN1));
	    	currData.add(new Currencies(liberia, LIB1, Consumer.VLIB1));
	    	currData.add(new Currencies(capeverde, CABO1, Consumer.VCABO1));
	    	
	    	
	    	//currData.add(new Currencies("XXX", "Angry", 1.0));
	    	//currData.add(new Currencies("FXXX", "FAngry", 32.0));
	    	System.out.println("&&&&&777 " +currData.get(0));
	    	System.out.println(currData.size());
			return currData;
	    	
	    }

	    @FXML
	    public void start() {
	    	//run3();
	    	btn1.setDisable(true);
	    	
	    	
	    	//Thread th2 = new Thread(run4());
	    	//th2.start();
	    	
	    	
	    	
	    	System.out.println("Started");
	    	
	    	System.out.println(tb1.getColumns());
	    		    	
	    	curr.setCellValueFactory(new PropertyValueFactory<Currencies, String>("name"));
	    	
	    	currBid.setCellValueFactory(new PropertyValueFactory<>("eikonBid"));
	    	lastBid.setCellValueFactory(new PropertyValueFactory<>("webBid"));
	    	

	    	tb1.setItems(getAll());
	    	

	    	System.out.println("col : " + curr.getCellData(0));
	    	pbar1.setProgress(-1.0f);
	    	System.out.println("I am almost done");
	    	ran();
	    	
	    	System.out.println("I am done");
	    	

	    }
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
	    	//Consumer cons = new Consumer();
	    	//Thread th = new Thread(new Consumer());
	    	updateStatus("Starting.");
	    	ex.start();
	    	
	    	run3();



	
	
	    	
			
		}
		
		@FXML public Runnable updateStatus(String value) {
			//btn1.setDisable(true);
			status.setText(value);
			
			//status.setText(value + "..");
			
			
			
			  Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(10), 
				        new EventHandler<ActionEvent>() {
				            @Override
				            public void handle(ActionEvent event) {

				            	status.setText(value + "....");
				            

				    	 
				
				    	    	
				    	    
				    	    	

				        		
				        		}
				        		
				                
				      
				        }
				    ));
				    //timeline.setCycleCount(Animation.INDEFINITE);
				    timeline.play();
					return null;
				    
				    
				    
			
		}
		
		
		
		@FXML public Runnable run3() {
			//btn1.setDisable(true);
			tb1.setItems(getAll());
	    	curr.setCellValueFactory(new PropertyValueFactory<Currencies, String>("name"));
	    	
	    	currBid.setCellValueFactory(new PropertyValueFactory<>("eikonBid"));
	    	lastBid.setCellValueFactory(new PropertyValueFactory<>("webBid"));
			
			  Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(60), 
				        new EventHandler<ActionEvent>() {
				            @Override
				            public void handle(ActionEvent event) {
				                //run2();
				                

				    	    	System.out.println("Refreshing GUI");
				    	    	
				    	    	//System.out.println(tb1.getColumns());
				    	    	
				    	    	curr.setCellValueFactory(new PropertyValueFactory<Currencies, String>("name"));
				    	    	
				    	    	currBid.setCellValueFactory(new PropertyValueFactory<>("eikonBid"));
				    	    	lastBid.setCellValueFactory(new PropertyValueFactory<>("webBid"));
				    	    	
				    	    	
				    	    	tb1.setItems(getAll());
				    	    	

				    	    	//System.out.println("col : " + curr.getCellData(0));

				        		
				        		}
				        		
				                
				      
				        }
				    ));
				    timeline.setCycleCount(Animation.INDEFINITE);
				    timeline.play();
					return null;
				    
				    
				    
			
		}
@FXML public void run5() {
	System.out.println("setting 1......");
	tb1.setItems(getAll());
	curr.setCellValueFactory(new PropertyValueFactory<Currencies, String>("name"));
	
	currBid.setCellValueFactory(new PropertyValueFactory<>("eikonBid"));
	lastBid.setCellValueFactory(new PropertyValueFactory<>("webBid"));
	
}
		@FXML public Runnable run4() {
			System.out.println("setting......");
			tb1.setItems(getAll());
	    	curr.setCellValueFactory(new PropertyValueFactory<Currencies, String>("name"));
	    	
	    	currBid.setCellValueFactory(new PropertyValueFactory<>("eikonBid"));
	    	lastBid.setCellValueFactory(new PropertyValueFactory<>("webBid"));
			
		    ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {
		        @Override
		        public Thread newThread(Runnable r) {
		            Thread thread = new Thread(r);
		            thread.setDaemon(true);
		            return thread;
		        }
		    });
		    
		    
		    
		    scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
		        @Override
		        public void run() {
		            final Runnable runnable = new Runnable() {
		                @Override
		                public void run() {
			    	    	System.out.println("Started");
			    	    	
			    	    	//System.out.println(tb1.getColumns());
			    	    	int counter = 1;
			    	    	System.out.println("lets see : " +counter++);
			    	    	
			    	    	curr.setCellValueFactory(new PropertyValueFactory<Currencies, String>("name"));
			    	    	
			    	    	currBid.setCellValueFactory(new PropertyValueFactory<>("eikonBid"));
			    	    	lastBid.setCellValueFactory(new PropertyValueFactory<>("webBid"));
			    	    	
			    	    	
			    	    	tb1.setItems(getAll());
			    	    	

			    	    	//System.out.println("col : " + curr.getCellData(0));


		                }
		            };
		            Platform.runLater(runnable);
		        }
		    }, 0, 30, TimeUnit.SECONDS);


			
			
			

			

					return null;
				    
				    
				    
			
		}
		
		public void ran() {

	    	//status.setText("Waiting for set time of 1PM, I think..");
	    	updateStatus("Waiting for set time of 3:20PM, I think.");

		    //ScheduledExecutorService scheduledExecutorService;
		    scheduledExecutorService =
	                Executors.newScheduledThreadPool(1);
	        System.out.println("---ScheduledSendLog created " + LocalDateTime.now());
	        startSchedule(LocalTime.of(15, 20));
	        
		}
		
	    private void startSchedule(LocalTime atTime) {
	        this.scheduledExecutorService.scheduleWithFixedDelay(() -> {
	                    System.out.println(Thread.currentThread().getName() +
	                            " |  scheduleWithFixedDelay | " + LocalDateTime.now());
	                    status.setTextFill(javafx.scene.paint.Color.BLUE);
	                    
	                	//tb1.setItems(getAll());
	                	//curr.setCellValueFactory(new PropertyValueFactory<Currencies, String>("name"));
	                	
	                	//currBid.setCellValueFactory(new PropertyValueFactory<>("eikonBid"));
	                	//lastBid.setCellValueFactory(new PropertyValueFactory<>("webBid"));
	                    
	                    

	                    System.out.println(" restarting....");
	                    //cn.shutdown();
	                    
	        	    	
	        	    	//Thread th = new Thread(new Consumer());
	                    //cn.shutup();
	                    //updateStatus("Uinitializing Consumer.");
	                    exodus ex2 = new exodus();
	                    ex.close();
	                    Consumer cas = new Consumer();
	                    
	                    
	                    status.setTextFill(javafx.scene.paint.Color.GREEN);
	                    updateStatus("STARTING CONSUMER.");
	                    ex2.start();
	        	    	//ty.start();
	                	System.out.println("setting 1......");
	
	

	         
	                    //status.setText("STARTING CONSUMER...");
	                    
	                    

	        	    	updateStatus("Starting Contribution engine.");

	        	    	
	                    
	                }, calculateInitialDelayInSec(atTime),
	                LocalTime.MAX.toSecondOfDay(),
	                TimeUnit.SECONDS);
	    }
	    private long calculateInitialDelayInSec(LocalTime atTime) {
	        int currSec = LocalTime.now().toSecondOfDay();
	        int atSec = atTime.toSecondOfDay();
	        return (currSec < atSec) ?
	                atSec - currSec : (LocalTime.MAX.toSecondOfDay() + atSec - currSec);

	    } 
	    
	    //close
	    @FXML
	    public void stopButtonAction(ActionEvent e) {
	        shutdown();
	    }

	    public void shutdown() {
	      
			if (started) {


	            started = false;
	        }
	    }

	    

}
