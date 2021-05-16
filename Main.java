package application;

import javafx.scene.paint.Color;

import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Main extends Application {
	static int countb1 = 0;
	static int countb2 = 0;
	static boolean turn = true;
	static boolean inputtingships = false;
	static double p1hits = 0;
	static double p2hits = 0;
	static double p1miss = 0;
	static double p2miss = 0;
	static boolean endgame = false;
	static char porien = 'u';
	//tracks the chosen orientation
	static boolean orienpressed = false;
	static boolean disable = true;
	static int p1shiplength = 2;
	static int p2shiplength = 2;


	@Override
	public void start(Stage primaryStage) {
		//title page stage

		Pane root1 = new Pane();
		Scene scene1 = new Scene(root1,1300,600);
		root1.setStyle("-fx-background-color: Blue");
		//https://stackoverflow.com/questions/49149502/button-color-change-in-javafx used for colouring background
		primaryStage.setScene(scene1);
		primaryStage.show();

		Text title = new Text();
		title.setText("Water Wars!");
		root1.getChildren().add(title);
		title.setTranslateX(455); 
		title.setTranslateY(60);
		title.setFont(Font.font ("Verdana",FontWeight.BOLD, 50));
		//https://www.tutorialspoint.com/javafx/javafx_text.htm
		title.setFill(javafx.scene.paint.Color.BLACK);

		Button start = new Button("Start");
		start.setFont(Font.font ("Verdana", 80));
		root1.getChildren().add(start);
		start.setStyle("-fx-background-color: LightBlue");
		start.setPrefHeight(300);
		start.setPrefWidth(500);
		start.setTranslateX(385);
		start.setTranslateY(100);
		start.setOnAction(event -> {
			game();
			primaryStage.close();
		});
		//refers to the game method if start is pressed

		Button instruction = new Button("Instructions");
		instruction.setFont(Font.font ("Verdana", 20));
		root1.getChildren().add(instruction);
		instruction.setStyle("-fx-background-color: Lightblue");
		instruction.setPrefHeight(100);
		instruction.setPrefWidth(200);
		instruction.setTranslateX(960);
		instruction.setTranslateY(200);
		instruction.setOnAction(event -> {
			instructions();
			//calls instructions method, which displays instructions of game if instruction button is pressed
		});

	}
	public static Stage instructionthing = new Stage();
	public static void instructions() {
		//method displays all instrcutions for game
		Pane root2 = new Pane();
		//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/Pane.html
		Scene instructionscene = new Scene(root2,1300,600);
		//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/Scene.html
		Text instructiontext = new Text();
		instructiontext.setText("Instructions:");
		root2.getChildren().add(instructiontext);
		instructiontext.setX(50); 
		instructiontext.setY(50);
		instructiontext.setFont(Font.font ("Verdana", 30));
		instructiontext.setFill(javafx.scene.paint.Color.BLUE);

		Text instructiontext1 = new Text();
		instructiontext1.setText("1. Both players input their ship locations; First click the orientation of the ship via one of the four centre buttons,");
		root2.getChildren().add(instructiontext1);
		instructiontext1.setX(100); 
		instructiontext1.setY(90);
		instructiontext1.setFont(Font.font ("Verdana", 20));
		instructiontext1.setFill(javafx.scene.paint.Color.BLUE);

		Text instructiontext1a = new Text();
		instructiontext1a.setText("and then chose where you would like to place your ship on the board(each ship takes up four spaces. Make sure to finalize");
		root2.getChildren().add(instructiontext1a);
		instructiontext1a.setX(100); 
		instructiontext1a.setY(130);
		instructiontext1a.setFont(Font.font ("Verdana", 20));
		instructiontext1a.setFill(javafx.scene.paint.Color.BLUE);

		Text instructiontext1b = new Text();
		instructiontext1b.setText("your ships by pressing the 'Player x ships finalized' button below each respective board. When ships are being inputed");
		root2.getChildren().add(instructiontext1b);
		instructiontext1b.setX(100); 
		instructiontext1b.setY(170);
		instructiontext1b.setFont(Font.font ("Verdana", 20));
		instructiontext1b.setFill(javafx.scene.paint.Color.BLUE);

		Text instructiontext1c = new Text();
		instructiontext1c.setText("by one player, make sure the opponent can not see the ships being inputed, by facing the screen away from the");
		root2.getChildren().add(instructiontext1c);
		instructiontext1c.setX(100); 
		instructiontext1c.setY(210);
		instructiontext1c.setFont(Font.font ("Verdana", 20));
		instructiontext1c.setFill(javafx.scene.paint.Color.BLUE);

		Text instructiontext1d = new Text();
		instructiontext1d.setText("opponent.");
		root2.getChildren().add(instructiontext1d);
		instructiontext1d.setX(100); 
		instructiontext1d.setY(250);
		instructiontext1d.setFont(Font.font ("Verdana", 20));
		instructiontext1d.setFill(javafx.scene.paint.Color.BLUE);

		Text instructiontext1e = new Text();
		instructiontext1e.setText("*Any inputed ships that would go off the board are invalid - Text will pop up and tell you to re-enter");
		root2.getChildren().add(instructiontext1e);
		instructiontext1e.setX(100); 
		instructiontext1e.setY(290);
		instructiontext1e.setFont(Font.font ("Verdana", 20));
		instructiontext1e.setFill(javafx.scene.paint.Color.BLUE);

		Text instructiontext1f = new Text();
		instructiontext1f.setText("orientation if your ship input is invalid*");
		root2.getChildren().add(instructiontext1f);
		instructiontext1f.setX(100); 
		instructiontext1f.setY(330);
		instructiontext1f.setFont(Font.font ("Verdana", 20));
		instructiontext1f.setFill(javafx.scene.paint.Color.BLUE);

		Text instructiontext1g = new Text();
		instructiontext1g.setText("*submarine = 2 spaces, destroyer = 3 spaces, dreadnought = 4 spaces, aircraft carrier = 5 spaces*");
		root2.getChildren().add(instructiontext1g);
		instructiontext1g.setX(100); 
		instructiontext1g.setY(370);
		instructiontext1g.setFont(Font.font ("Verdana", 20));
		instructiontext1g.setFill(javafx.scene.paint.Color.BLUE);

		Text instructiontext2 = new Text();
		instructiontext2.setText("2. The game will then start; The player who goes first will be displayed, and is chosen at random.");
		root2.getChildren().add(instructiontext2);
		instructiontext2.setX(100); 
		instructiontext2.setY(410);
		instructiontext2.setFont(Font.font ("Verdana", 20));
		instructiontext2.setFill(javafx.scene.paint.Color.BLUE);

		Text instructiontext3 = new Text();
		instructiontext3.setText("3. The players then takes turns attempting to hit the each others ship's, by pressing one of the buttons on their");
		root2.getChildren().add(instructiontext3);
		instructiontext3.setX(100); 
		instructiontext3.setY(450);
		instructiontext3.setFont(Font.font ("Verdana", 20));
		instructiontext3.setFill(javafx.scene.paint.Color.BLUE);

		Text instructiontext3a = new Text();
		instructiontext3a.setText("opponent's board.");
		root2.getChildren().add(instructiontext3a);
		instructiontext3a.setX(100); 
		instructiontext3a.setY(490);
		instructiontext3a.setFont(Font.font ("Verdana", 20));
		instructiontext3a.setFill(javafx.scene.paint.Color.BLUE);

		Text instructiontext4 = new Text();
		instructiontext4.setText("4. Game ends when a player has sunk all 4 of their oppositions ships. Hit%'s of each player will be displayed.");
		root2.getChildren().add(instructiontext4);
		instructiontext4.setX(100); 
		instructiontext4.setY(530);
		instructiontext4.setFont(Font.font ("Verdana", 20));
		instructiontext4.setFill(javafx.scene.paint.Color.BLUE);

		Text instructiontext4a = new Text();
		instructiontext4a.setText("*PRESS THE QUIT BUTTON AT ANY TIME TO QUIT THE GAME*");
		root2.getChildren().add(instructiontext4a);
		instructiontext4a.setX(100); 
		instructiontext4a.setY(570);
		instructiontext4a.setFont(Font.font ("Verdana", 20));
		instructiontext4a.setFill(javafx.scene.paint.Color.BLUE);

		instructionthing.setTitle("Instructions");
		instructionthing.setScene(instructionscene);
		instructionthing.show();

	}

	public static Stage mainthing = new Stage();
	public static void game() {
		//game method displays actual game itself

		Text textp1 = new Text();
		textp1.setText("Player 1 Board");
		textp1.setX(255); 
		textp1.setY(50);
		textp1.setFont(Font.font ("Verdana", 20));
		textp1.setFill(javafx.scene.paint.Color.BLUE);

		Text textp2 = new Text();
		textp2.setText("Player 2 Board");
		textp2.setX(930); 
		textp2.setY(50);
		textp2.setFont(Font.font ("Verdana",20));
		textp2.setFill(javafx.scene.paint.Color.RED);

		Text textTitle = new Text();
		textTitle.setText("Water Wars!");
		textTitle.setX(550); 
		textTitle.setY(35);
		textTitle.setFont(Font.font ("Verdana",FontWeight.BOLD, 30));
		textTitle.setFill(javafx.scene.paint.Color.DARKBLUE);

		Text pinputsign = new Text();
		//pops up to tell player 1 to input his/her ships
		pinputsign.setText("Player 1 input ships");
		pinputsign.setX(555); 
		pinputsign.setY(200);
		pinputsign.setFont(Font.font ("Verdana",20));
		pinputsign.setFill(javafx.scene.paint.Color.BLUE);

		Text textpressagain = new Text();
		textpressagain.setText("");
		textpressagain.setX(450); 
		textpressagain.setY(585);
		textpressagain.setFont(Font.font ("Verdana", 15));
		textpressagain.setFill(javafx.scene.paint.Color.BLUE);

		Text playerturntext = new Text();
		playerturntext.setText("");
		playerturntext.setX(400); 
		playerturntext.setY(570);
		playerturntext.setFont(Font.font ("Verdana", 15));
		playerturntext.setFill(javafx.scene.paint.Color.BLUE);


		boolean[][] p1inputarr = new boolean[10][10];
		//creates array for booleans for player 1 ships; true means a ship is at that element

		boolean[][] p2inputarr = new boolean[10][10];
		//creates array for booleans for player 2 ships; true means a ship is at that element

		Rectangle shipbase = new Rectangle();
		Rectangle shiproom = new Rectangle();
		Rectangle window1 = new Rectangle();
		Rectangle window2 = new Rectangle();
		Rectangle window3 = new Rectangle();
		Text p1 = new Text();

		Rectangle rocket = new Rectangle();
		Rectangle shipbase1 = new Rectangle();
		Rectangle shiproom1 = new Rectangle();
		Rectangle window11 = new Rectangle();
		Rectangle window22 = new Rectangle();
		Rectangle window33 = new Rectangle();
		Text p2 = new Text();
		//the 14 declarations above are for the animation at the end of the game

		Pane roott = new Pane(textp1,textp2,textTitle,pinputsign,textpressagain,playerturntext,shipbase,shiproom,window1,window2,window3,p1,shipbase1,shiproom1,window11,window22,window33,p2,rocket); 

		Scene scene = new Scene(roott,1300,695);

		roott.setStyle("-fx-background-color: LightBlue");

		Text winnerline1 = new Text();
		winnerline1.setText("");
		roott.getChildren().add(winnerline1);
		winnerline1.setX(560); 
		winnerline1.setY(400);
		winnerline1.setFont(Font.font ("Verdana",FontWeight.BOLD, 40));
		winnerline1.setFill(javafx.scene.paint.Color.BLACK);
		//text for the winner which is displayed at end of game

		Text winnerline2 = new Text();
		winnerline1.setText("");
		roott.getChildren().add(winnerline2);
		winnerline2.setX(585); 
		winnerline2.setY(450);
		winnerline2.setFont(Font.font ("Verdana",FontWeight.BOLD, 40));
		winnerline2.setFill(javafx.scene.paint.Color.BLACK);
		//line 2 of text for the winner which is displayed at end of game

		Button continuep1 = new Button();
		Font fontcontinuep1 = new Font(20);
		continuep1.setPrefHeight(40);
		continuep1.setPrefWidth(350);
		continuep1.setTranslateX(145);
		continuep1.setTranslateY(530);
		continuep1.setText("Player 1 Ships Finalized");
		continuep1.setFont(fontcontinuep1);

		Button continuep2 = new Button();
		Font fontcontinuep2 = new Font(20);
		continuep2.setPrefHeight(40);
		continuep2.setPrefWidth(350);
		continuep2.setTranslateX(810);
		continuep2.setTranslateY(530);
		continuep2.setText("Player 2 Ships Finalized");
		continuep2.setFont(fontcontinuep2);

		Button quit = new Button("Quit Game");
		quit.setFont(Font.font ("Verdana", 20));
		roott.getChildren().add(quit);
		quit.setStyle("-fx-background-color: Aquamarine");
		quit.setPrefHeight(50);
		quit.setPrefWidth(150);
		quit.setTranslateX(7);
		quit.setTranslateY(7);
		quit.setOnAction(event -> {
			Platform.exit();
			//if quit button is pressed at any time, the game quits and the program closes
		});	

		Text orientation = new Text("P1 Select Orientation of submarine"); 
		roott.getChildren().add(orientation);
		orientation.setX(550); 
		orientation.setY(250);
		orientation.setFont(Font.font ("Verdana", 10));
		orientation.setFill(javafx.scene.paint.Color.BLACK);

		Button up = new Button("Up");
		up.setFont(Font.font ("Verdana", 20));
		roott.getChildren().add(up);
		up.setStyle("-fx-background-color: Aqua");
		up.setPrefHeight(90);
		up.setPrefWidth(90);
		up.setTranslateX(555);
		up.setTranslateY(270);

		Button down = new Button("Down");
		down.setFont(Font.font ("Verdana", 20));
		roott.getChildren().add(down);
		down.setStyle("-fx-background-color: Aqua");
		down.setPrefHeight(90);
		down.setPrefWidth(90);
		down.setTranslateX(660);
		down.setTranslateY(270);

		Button left = new Button("Left");
		left.setFont(Font.font ("Verdana", 20));
		roott.getChildren().add(left);
		left.setStyle("-fx-background-color: Aqua");
		left.setPrefHeight(90);
		left.setPrefWidth(90);
		left.setTranslateX(555);
		left.setTranslateY(380);

		Button right = new Button("Right");
		right.setFont(Font.font ("Verdana", 20));
		roott.getChildren().add(right);
		right.setStyle("-fx-background-color: Aqua");
		right.setPrefHeight(90);
		right.setPrefWidth(90);
		right.setTranslateX(660);
		right.setTranslateY(380);

		up.setOnAction(eventup ->{
			//once up orientation button is pressed, all buttons are disabled 
			porien = 'u';
			up.setDisable(true);
			down.setDisable(true);
			left.setDisable(true);
			right.setDisable(true);
			orienpressed=true;
		});
		down.setOnAction(eventdown -> {
			//once down orientation button is pressed, all buttons are disabled 
			porien = 'd';
			up.setDisable(true);
			down.setDisable(true);
			left.setDisable(true);
			right.setDisable(true);
			orienpressed=true;
		});
		left.setOnAction(eventleft -> {
			//once left orientation button is pressed, all buttons are disabled 
			porien = 'l';
			up.setDisable(true);
			down.setDisable(true);
			left.setDisable(true);
			right.setDisable(true);
			orienpressed=true;
		});
		right.setOnAction(eventright -> {
			//once right orientation button is pressed, all buttons are disabled 
			porien = 'r';
			up.setDisable(true);
			down.setDisable(true);
			left.setDisable(true);
			right.setDisable(true);
			orienpressed=true;
		});


		Button[][] p2buttonarr = new Button[10][10];
		Button[][] p1buttonarr = new Button[10][10];
		for(int i = 0, y = 80;i<10;i++,y=y+45) {
			//loops through all buttons for first button array and initializes them and are put on the stage. Also allows for any button to be pressed, and the code under the setOnAction to then be executed
			for(int j = 0, x = 100;j<10;j++,x=x+45) {				
				p1buttonarr[i][j] = new Button();
				roott.getChildren().add(p1buttonarr[i][j]);
				p1buttonarr[i][j].setPrefHeight(40);
				p1buttonarr[i][j].setPrefWidth(40);
				p1buttonarr[i][j].setTranslateX(x);
				p1buttonarr[i][j].setTranslateY(y);
				p1buttonarr[i][j].setStyle("-fx-background-color: DarkBlue");
				int k = i;
				int l = j;
				p1buttonarr[i][j].setOnAction(event -> {
					//when ever a ANY(why I have the loop) button is pressed, it is either for inputting of ship, or guessing ship places during the actual game
					if(endgame==false) {
						//this boolean controls if the game is over or not; when the game is over, endgame will be true and the buttons will no longer be able to be pressed
						if(countb1<=4) {
							if(orienpressed==true) {
								//checks if a orientation is pressed. If one has not been pressed, the code will not proceed and a line of text will pop up to ask the user to click an orientation
								if(p1inputarr[k][l]==false) {
									//if statement checks if a button on the player 1 board has been previously pressed. If the button pressed has be been previously pressed when entering previous ships, the program will continue to the switch statement
									textpressagain.setText("");
									//text set to "" because if program gets to this point, it means an orientation and button has been pressed, so any message displayed to re-press a button will go away
									switch(porien) {
									//swtich statement is for inputting ships depending on orientation that was pressed(by the 4 orientation buttons) by player 1
									case 'u':
										if(k-(p1shiplength-1)>=0) {
											//checks to see if ship will fit(ie does not go off the screen) 
											int countb1testforallvaluesfalse = 0;
											for(int c = 0;c<=p1shiplength-1;c++) {
												if(p1inputarr[k-c][l]==true) {
													countb1testforallvaluesfalse++;
													//this counter and loop checks if the inputed ship overlaps any other inputed ships. If the counter is zero, the ship does not overlap
												}
											}
											if(countb1testforallvaluesfalse==0) {
												countb1++;
												//counts how many ships have been inputed for p1 - goes up if the ship inputed is valid(ie it does not overlap or go off or screen)
												for(int a = 0;a<=p1shiplength-1;a++) {
													//this loop fills in the buttons of the valid inputed ship with a grey filling, and also turns the corresponding elements in the p1 boolean in array to true, as true means a ship is in that spot. 
													p1inputarr[k-a][l] = true; 
													p1buttonarr[k-a][l].setStyle("-fx-background-color: Grey");
												}
												p1shiplength++;
												//ships length is increased as you input a larger ship(in length) for each input turn of player 1

											}
											else {
												textpressagain.setX(450);
												textpressagain.setText("Orientation does not Fit; Chose Another Orientation");
												//this message occurs if countb1testforallvaluesfalse!=0, meaning the inputed ship would overlap another ship
											}
										}
										else {
											textpressagain.setX(450);
											textpressagain.setText("Orientation does not Fit; Chose Another Orientation");
											//this message occurs if the inputed ship would go off the screen
										}
										break;
									case 'd':
										if(k+p1shiplength<=10) {
											//checks to see if ship will fit(ie does not go off the screen) 
											int countb1testforallvaluesfalse = 0;
											for(int c = 0;c<=p1shiplength-1;c++) {
												if(p1inputarr[k+c][l]==true) {
													countb1testforallvaluesfalse++;
													//this counter and loop checks if the inputed ship overlaps any other inputed ships. If the counter is zero, the ship does not overlap
												}
											}
											if(countb1testforallvaluesfalse==0) {
												countb1++;
												//counts how many ships have been inputed for p1 - goes up if the ship inputed is valid(ie it does not overlap or go off or screen)
												for(int a = 0;a<=p1shiplength-1;a++) {
													p1inputarr[k+a][l] = true; 
													p1buttonarr[k+a][l].setStyle("-fx-background-color: Grey");
												}
												p1shiplength++;
												//ships length is increased as you input a larger ship(in length) for each input turn of player 1
											}
											else {
												textpressagain.setX(450);
												textpressagain.setText("Orientation does not Fit; Chose Another Orientation");
												//this message occurs if countb1testforallvaluesfalse!=0, meaning the inputed ship would overlap another ship
											}
										}
										else {
											textpressagain.setX(450);
											textpressagain.setText("Orientation does not Fit; Chose Another Orientation");
											//this message occurs if the inputed ship would go off the screen
										}
										break;
									case 'l':
										if(l-(p1shiplength-1)>=0) {
											//checks to see if ship will fit(ie does not go off the screen) 
											int countb1testforallvaluesfalse = 0;
											for(int c = 0;c<=p1shiplength-1;c++) {
												if(p1inputarr[k][l-c]==true) {
													countb1testforallvaluesfalse++;
													//this counter checks if the inputed ship overlaps any other inputed ships. If the counter is zero, the ship does not overlap
												}
											}
											if(countb1testforallvaluesfalse==0) {
												countb1++;
												//counts how many ships have been inputed for p1 - goes up if the ship inputed is valid(ie it does not overlap or go off or screen)
												for(int a = 0;a<=p1shiplength-1;a++) {
													p1inputarr[k][l-a] = true; 
													p1buttonarr[k][l-a].setStyle("-fx-background-color: Grey");
												}
												p1shiplength++;
												//ships length is increased as you input a larger ship(in length) for each input turn of player 1
											}
											else {
												textpressagain.setX(450);
												textpressagain.setText("Orientation does not Fit; Chose Another Orientation");
												//this message occurs if countb1testforallvaluesfalse!=0, meaning the inputed ship would overlap another ship
											}
										}
										else {
											textpressagain.setX(450);
											textpressagain.setText("Orientation does not Fit; Chose Another Orientation");
											//this message occurs if the inputed ship would go off the screen
										}
										break;
									case 'r':

										if(l+p1shiplength<=10) {
											//checks to see if ship will fit(ie does not go off the screen) 
											int countb1testforallvaluesfalse = 0;
											for(int c = 0;c<=p1shiplength-1;c++) {
												if(p1inputarr[k][l+c]==true) {
													countb1testforallvaluesfalse++;
													//this counter checks if the inputed ship overlaps any other inputed ships. If the counter is zero, the ship does not overlap
												}
											}

											if(countb1testforallvaluesfalse==0) {
												countb1++;
												//counts how many ships have been inputed for p1 - goes up if the ship inputed is valid(ie it does not overlap or go off or screen)
												for(int a = 0;a<=p1shiplength-1;a++) {
													p1inputarr[k][l+a] = true; 
													p1buttonarr[k][l+a].setStyle("-fx-background-color: Grey");//why do non of the buttons turn grey when i click the up button
												}
												p1shiplength++;
												//ships length is increased as you input a larger ship(in length) for each input turn of player 1
											}
											else {
												textpressagain.setX(450);
												textpressagain.setText("Orientation does not Fit; Chose Another Orientation");
												//this message occurs if countb1testforallvaluesfalse!=0, meaning the inputed ship would overlap another ship
											}
										}
										else {
											textpressagain.setX(450);
											textpressagain.setText("Orientation does not Fit; Chose Another Orientation");
											//this message occurs if the inputed ship would go off the screen
										}
										break;
									default:
									}
									orienpressed=false; 

									//changed to false, so the inputing of a ship cannot occur until an orientation button is pressed, as any orientation button will turn this variable true to allow a ship to then be inputed
									if(countb1<4) {
										//enables all orientation buttons to be pressed(unless 4 turns have been reached), so an orientation can be chosen for the next ship
										up.setDisable(false);
										down.setDisable(false);
										left.setDisable(false);
										right.setDisable(false);
									}
									if(p1shiplength==3) {
										//just a few nested if statements which tells the user which ship they are inputing(1st, 2nd, 3rd, 4th ship)
										orientation.setText("P1 Select Orientation of destroyer");
										//if the submarine had just been inputed, p1shiplength has been incremented to 3, meaning the destroyer should now be inputed
									}
									else {
										if(p1shiplength==4) {
											orientation.setText("P1 Select Orientation of dreadnought");
											//if the destroyer had just been inputed, p1shiplength has been incremented to 4, meaning the dreadnought should now be inputed
										}
										else {
											if(p1shiplength==5) {
												orientation.setText("P1 Select Orientation of aircraft carrier");
												////if the dreadnought had just been inputed, p1shiplength has been incremented to 5, meaning the aircraft carrier should now be inputed
											}
										}
									}	
								}
							}
							else {
								//if a button if button on the player 1 board has been pressed for inputting ships, with out an orientation being pressed first, a message will pop up asking player 1 to press an orientation first
								textpressagain.setX(563);
								textpressagain.setText("Choose Orientation First");
							}
							if(countb1>=4) {
								//this allows for no more ships to be inputed if all 4 ships have been inputed(function of the if statement)
								inputtingships=true;
								//variable  controls if player 2 can enter coordinates yet - we dont want player 2 entering in coordinates until player 1 has pressed continue button
								roott.getChildren().add(continuep1);
								continuep1.setOnAction(eventt -> {
									//if the 'finalized ships' button is pressed a loop is run to turn all buttons blue to hide the player 1 ships so player 2 can then input his/her ships
									for(int a = 0;a<10;a++) {
										for(int b = 0;b<10;b++) {
											p1buttonarr[a][b].setStyle("-fx-background-color: DarkBlue");
											//hides player 1 ships by turning the whole player one board blue so player 2 can't see player 1 ships when player 2 beings to enter ships(which occurs after player 1 enters ships)
										}
										up.setDisable(false);
										//https://www.programcreek.com/java-api-examples/?class=javafx.scene.control.Button&method=setDisable
										down.setDisable(false);
										left.setDisable(false);
										right.setDisable(false);
										//enables all orientation buttons
										orientation.setText("P2 Select Orientation of submarine");
										for(int c = 0;c<10;c++) {
											for(int d = 0;d<10;d++) {
												p2buttonarr[c][d].setDisable(false);
												p1buttonarr[c][d].setDisable(true);
												//disables player 1 board and enables player 2 board to player 2 can input ships
											}
										}
									}

									pinputsign.setFill(javafx.scene.paint.Color.RED);
									pinputsign.setText("Player 2 input ships");
									continuep1.setDisable(true);

								});
							}	
						}

						else {
							//program executes the following code if the inputing ship process if already complete
							if(turn==false) {
								//if turn is false, it means player 2 just went, hence to sign switches to 'its player ones turn'
								pinputsign.setText("Player 1's turn");
								pinputsign.setX(590);
								turn=true;
								if(p1inputarr[k][l]==true) {
									//this if statement checks if the button chosen by player 2 is a hit on players one board. If true, the button turns red and the button is disabled so it cannot b pressed again
									p1buttonarr[k][l].setStyle("-fx-background-color: Red");
									p1buttonarr[k][l].setDisable(true);
									p2hits++;
								}
								else {
									//this else statement is executed if the button chosen by p2 is a miss. This results in the button turning white, and becoming disabled
									p1buttonarr[k][l].setStyle("-fx-background-color: White");
									p1buttonarr[k][l].setDisable(true);
									p2miss++;
								} 
								if(p2hits==14) {
									//this if statement checks if player 2 has won, meaning he has sunk all of player 1's ships. Once this happens, it states player 2 wins and the endgame method is executed
									winnerline1.setText("Player 2");
									winnerline2.setText("Wins!");
									pinputsign.setText("");
									endgame=true;
									ploseanimation(shipbase,shiproom,window1,window2,window3,p1,shipbase1,shiproom1,window11,window22,window33,p2,rocket);
									endGame(roott);
								}
							}
						}
					}
				});
			}
		}

		int h = (1+(int)(Math.random()*2));
		for(int i = 0, y = 80;i<10;i++,y=y+45) {
			for(int j = 0, x = 760;j<10;j++,x=x+45) {
				//loops through all buttons for second button array, and initializes them. Also allows for any button to be pressed, and the code under the setOnAction to then be executed
				p2buttonarr[i][j] = new Button();
				roott.getChildren().add(p2buttonarr[i][j]);
				p2buttonarr[i][j].setPrefHeight(40);
				p2buttonarr[i][j].setPrefWidth(40);
				p2buttonarr[i][j].setTranslateX(x);
				p2buttonarr[i][j].setTranslateY(y);
				p2buttonarr[i][j].setStyle("-fx-background-color: DarkBlue");
				int k = i;
				int l = j;
				p2buttonarr[i][j].setDisable(true);
				//disables the player 2 board before the game, so only player 1 can input ships when the game starts - changes to false when all player one ships have been inputed and player one presses the 'finalized ships' button
				p2buttonarr[i][j].setOnAction(event -> {
					if(endgame==false) {
						//endgame control if the game is over - if true, the game is over, meaning on player has sunk all of the other players ships.
						if(inputtingships==true) {
							//if true, it means player 1 is done inputting ships, so player 2 can go ahead and input ships
							if(countb2<4) {
								if(orienpressed==true) {
									//checks if an orientation has been clicked, which one must be in order to continue and pick a ship location
									if(p2inputarr[k][l]==false) {
										//must check is the button clicked it false, because if it is true, it means it has already been clicked, so if clicked again should not again be recorded as a ship
										textpressagain.setText("");
										switch(porien) {
										//acts in same way the switch statement for player 1 input does - refer to switch statment for player 1 for comments
										case 'u':
											if(k-(p2shiplength-1)>=0) {
												//checks to see if ship will fit(ie does not go off the screen) 
												int countb2testforallvaluesfalse = 0;
												for(int c = 0;c<=p2shiplength-1;c++) {
													if(p2inputarr[k-c][l]==true) {
														countb2testforallvaluesfalse++;
														//this counter checks if the inputed ship overlaps any other inputed ships. If the counter is zero, the ship does not overlap
													}
												}
												if(countb2testforallvaluesfalse==0) {
													countb2++;
													//counts how many ships have been inputed for p1 - goes up if the ship inputed is valid(ie it does not overlap or go off or screen)
													for(int a = 0;a<=p2shiplength-1;a++) {
														p2inputarr[k-a][l] = true; 
														p2buttonarr[k-a][l].setStyle("-fx-background-color: Grey");
													}
													p2shiplength++;
													//ships length is increased as you input a larger ship(in length) for each input turn of player 2
												}
												else {
													textpressagain.setX(450);
													textpressagain.setText("Orientation does not Fit; Chose Another Orientation");
													//this message occurs if countb1testforallvaluesfalse!=0, meaning the inputed ship would overlap another ship
												}
											}
											else {
												textpressagain.setX(450);
												textpressagain.setText("Orientation does not Fit; Chose Another Orientation");
												//this message occurs if the inputed ship would go off the screen
											}
											break;
										case 'd':
											if(k+p2shiplength<=10) {
												//checks to see if ship will fit(ie does not go off the screen) 
												int countb2testforallvaluesfalse = 0;
												for(int c = 0;c<=p2shiplength-1;c++) {
													if(p2inputarr[k+c][l]==true) {
														countb2testforallvaluesfalse++;
														//this counter checks if the inputed ship overlaps any other inputed ships. If the counter is zero, the ship does not overlap
													}
												}
												if(countb2testforallvaluesfalse==0) {
													countb2++;
													//counts how many ships have been inputed for p1 - goes up if the ship inputed is valid(ie it does not overlap or go off or screen)
													for(int a = 0;a<=p2shiplength-1;a++) {
														p2inputarr[k+a][l] = true; 
														p2buttonarr[k+a][l].setStyle("-fx-background-color: Grey");
													}
													p2shiplength++;
													//ships length is increased as you input a larger ship(in length) for each input turn of player 2
												}
												else {
													textpressagain.setX(450);
													textpressagain.setText("Orientation does not Fit; Chose Another Orientation");
													//this message occurs if countb1testforallvaluesfalse!=0, meaning the inputed ship would overlap another ship
												}
											}
											else {
												textpressagain.setX(450);
												textpressagain.setText("Orientation does not Fit; Chose Another Orientation");
												//this message occurs if the inputed ship would go off the screen
											}
											break;
										case 'l':
											if(l-(p2shiplength-1)>=0) {
												//checks to see if ship will fit(ie does not go off the screen) 
												int countb2testforallvaluesfalse = 0;
												for(int c = 0;c<=p2shiplength-1;c++) {
													if(p2inputarr[k][l-c]==true) {
														countb2testforallvaluesfalse++;
														//this counter checks if the inputed ship overlaps any other inputed ships. If the counter is zero, the ship does not overlap
													}
												}
												if(countb2testforallvaluesfalse==0) {
													countb2++;
													//counts how many ships have been inputed for p1 - goes up if the ship inputed is valid(ie it does not overlap or go off or screen)
													for(int a = 0;a<=p2shiplength-1;a++) {
														p2inputarr[k][l-a] = true; 
														p2buttonarr[k][l-a].setStyle("-fx-background-color: Grey");
													}
													p2shiplength++;
													//ships length is increased as you input a larger ship(in length) for each input turn of player 2
												}
												else {
													textpressagain.setX(450);
													textpressagain.setText("Orientation does not Fit; Chose Another Orientation");
													//this message occurs if countb1testforallvaluesfalse!=0, meaning the inputed ship would overlap another ship
												}
											}
											else {
												textpressagain.setX(450);
												textpressagain.setText("Orientation does not Fit; Chose Another Orientation");
												//this message occurs if the inputed ship would go off the screen
											}
											break;
										case 'r':
											if(l+p2shiplength<=10) {
												//checks to see if ship will fit(ie does not go off the screen) 
												int countb2testforallvaluesfalse = 0;
												for(int c = 0;c<=p2shiplength-1;c++) {
													if(p2inputarr[k][l+c]==true) {
														countb2testforallvaluesfalse++;
														//this counter checks if the inputed ship overlaps any other inputed ships. If the counter is zero, the ship does not overlap
													}
												}

												if(countb2testforallvaluesfalse==0) {
													countb2++;
													//counts how many ships have been inputed for p1 - goes up if the ship inputed is valid(ie it does not overlap or go off or screen)
													for(int a = 0;a<=p2shiplength-1;a++) {
														p2inputarr[k][l+a] = true; 
														p2buttonarr[k][l+a].setStyle("-fx-background-color: Grey");//why do non of the buttons turn grey when i click the up button
													}
													p2shiplength++;
													//ships length is increased as you input a larger ship(in length) for each input turn of player 2
												}
												else {
													textpressagain.setX(450);
													textpressagain.setText("Orientation does not Fit; Chose Another Orientation");
													//this message occurs if countb1testforallvaluesfalse!=0, meaning the inputed ship would overlap another ship
												}
											}
											else {
												textpressagain.setX(450);
												textpressagain.setText("Orientation does not Fit; Chose Another Orientation");
												//this message occurs if the inputed ship would go off the screen
											}
											break;
										default:
										}
									}
									orienpressed=false; 
									//set to false, so then the only way to input another is to press an orientation first, for the next ship that will be inputed
									if(countb2<4) {
										//enables all orientation buttons to be pressed(unless 4 turns have been reached), so an orientation can be chosen for the next ship
										up.setDisable(false);
										down.setDisable(false);
										left.setDisable(false);
										right.setDisable(false);
									}

									if(p2shiplength==3) {
										orientation.setText("P2 Select Orientation of destroyer");
										//if the submarine had just been inputed, p2shiplength has been incremented to 3, meaning the destroyer should now be inputed
									}
									else {
										if(p2shiplength==4) {
											orientation.setText("P2 Select Orientation of dreadnought");
											//if the destroyer had just been inputed, p2shiplength has been incremented to 4, meaning the dreadnought should now be inputed
										}
										else {
											if(p2shiplength==5) {
												orientation.setText("P2 Select Orientation of aircraft carrier");
												//if the submarine had just been inputed, p2shiplength has been incremented to 5, meaning the aircraft carrier should now be inputed
											}
										}
									}	
								}
								else {
									//Executes if a button if button on the player 2 board has been pressed for inputting ships, with out an orientation being pressed first, a message will pop up asking player 2 to press an orientation first
									textpressagain.setX(563);
									textpressagain.setText("Choose Orientation First");
								}

								if(countb2>=4) {
									//checks if player 2 has inputed the max(4) ships
									roott.getChildren().add(continuep2);
									continuep2.setOnAction(eventt -> {
										for(int a = 0;a<10;a++) {
											for(int b = 0;b<10;b++) {
												//loops through all buttons for second button array and sets them to dark blue, like the rest of the buttons, so the ships become hidden, so player 1 can't see player 2's ships when the game starts
												p2buttonarr[a][b].setStyle("-fx-background-color: DarkBlue");
											}
										}
										orientation.setText("");
										up.setStyle("-fx-background-color: Transparent");
										up.setText("");
										down.setStyle("-fx-background-color: Transparent");
										down.setText("");
										left.setStyle("-fx-background-color: Transparent");
										left.setText("");
										right.setStyle("-fx-background-color: Transparent");
										right.setText("");
										//all orientation buttons disappear, as they are no longer needed for the actual game
										continuep2.setDisable(true);
										pinputsign.setFill(javafx.scene.paint.Color.PURPLE);
										pinputsign.setX(485);
										pinputsign.setY(60);
										pinputsign.setFont(Font.font ("Verdana",FontWeight.BOLD, 20));
										for(int c = 0;c<10;c++) {
											for(int d = 0;d<10;d++) {
												p1buttonarr[c][d].setDisable(false);
												//enables player 1 board so both boards are active for the starting of the actual game
											}
										}
										pinputsign.setText("Game Starts! Player "+h+" goes first");
										//h was randomized above at line 400 or so, to become an integer between 1 and 2
										if(h==1) {
											turn=true;
											//means p1 goes first
										}
										else {
											turn=false;
											//means p2 goes first
										}											
										inputtingships = false;
										//this condition is false now so no more ships can be inputed
									});
								}
							}
						}
						else {
							if(turn==true) {
								//if turn is true, it means player 1 just went, so its player 2's turn now
								pinputsign.setText("Player 2's turn");
								pinputsign.setX(590);
								turn=false;
								if(p2inputarr[k][l]==true) {
									//checks if the pressed button by p1 is a hit. If it is a hit, the button turns red and is disabled
									p2buttonarr[k][l].setStyle("-fx-background-color: Red");
									p1hits++;
									p2buttonarr[k][l].setDisable(true);
								}
								else {
									//this else statement is executed if the button chosen by p1 is a miss. This results in the button turning white, and becoming disabled
									p2buttonarr[k][l].setStyle("-fx-background-color: White");
									p2buttonarr[k][l].setDisable(true);
									p1miss++;
								}
								if(p1hits==14) {
									//this if statement checks if player 1 has won, meaning he has sunk all of player 2's ships. Once this happens, it states player 1 wins and the endgame method is executed
									winnerline1.setText("Player 1");
									winnerline2.setText("Wins!");
									pinputsign.setText("");
									endgame=true;
									ploseanimation(shipbase,shiproom,window1,window2,window3,p1,shipbase1,shiproom1,window11,window22,window33,p2,rocket);
									endGame(roott);
								}								
							}
						}
					}
				});
			}
		}
		mainthing.setTitle("Water Wars!");
		mainthing.setScene(scene);
		mainthing.show();
	}
	public static void endGame(Pane roott) {
		//this method is called on when the game ends, so the Hit%'s can be displayed
		Text p1hitpercent1 = new Text("P1 Hit %: ");
		roott.getChildren().add(p1hitpercent1);
		p1hitpercent1.setX(590); 
		p1hitpercent1.setY(200);
		p1hitpercent1.setFont(Font.font ("Verdana",FontWeight.BOLD, 25));
		p1hitpercent1.setFill(javafx.scene.paint.Color.BLACK);

		Text p1hitpercent2 = new Text(Math.round((p1hits/(p1hits+p1miss))*100.0)+"%");
		roott.getChildren().add(p1hitpercent2);
		p1hitpercent2.setX(610); 
		p1hitpercent2.setY(250);
		p1hitpercent2.setFont(Font.font ("Verdana",FontWeight.BOLD, 25));
		p1hitpercent2.setFill(javafx.scene.paint.Color.BLACK);

		Text p2hitpercent1 = new Text("P2 Hit %: ");
		roott.getChildren().add(p2hitpercent1);
		p2hitpercent1.setX(590); 
		p2hitpercent1.setY(300);
		p2hitpercent1.setFont(Font.font ("Verdana",FontWeight.BOLD, 25));
		p2hitpercent1.setFill(javafx.scene.paint.Color.BLACK);

		Text p2hitpercent2 = new Text(Math.round((p2hits/(p2hits+p2miss))*100.0)+"%");
		roott.getChildren().add(p2hitpercent2);
		p2hitpercent2.setX(610); 
		p2hitpercent2.setY(350);
		p2hitpercent2.setFont(Font.font ("Verdana",FontWeight.BOLD, 25));
		p2hitpercent2.setFill(javafx.scene.paint.Color.BLACK);
	}
	public static void ploseanimation(Rectangle shipbase,Rectangle shiproom,Rectangle window1,Rectangle window2,Rectangle window3,Text p1,Rectangle shipbase1,Rectangle shiproom1,Rectangle window11,Rectangle window22,Rectangle window33,Text p2,Rectangle rocket){
		//this method is called on when the game ends, so a small animation can be displayed, of the winner shooting down the loser in the form of ships
		shipbase.setX(100-310);
		shipbase.setY(605); 
		shipbase.setWidth(200); 
		shipbase.setHeight(45);
		shipbase.setFill(Color.GREY);
		TranslateTransition slideRightsb = new TranslateTransition(Duration.millis(5000), shipbase);
		slideRightsb.setByX(800);
		//https://www.javatpoint.com/javafx-translate-transition - used for all translations
		//https://docs.oracle.com/javafx/2/api/javafx/animation/TranslateTransition.html - used for all translations
		TranslateTransition slideDownsb = new TranslateTransition(Duration.millis(7000), shipbase);
		slideDownsb.setByY(300);
		SequentialTransition sqsb = new SequentialTransition(slideRightsb,slideDownsb);
		//https://www.javatpoint.com/javafx-sequential-transition - used for all sequential translations
		sqsb.play();
		//losing players ship comes from right side of screen, and this part of ship, along with rest of ship, slides right

		shiproom.setX(120-310); 
		shiproom.setY(575); 
		shiproom.setWidth(70); 
		shiproom.setHeight(30);
		shiproom.setFill(Color.GREY);
		shiproom.setStroke(Color.BLACK); 
		shiproom.setStrokeWidth(3);
		TranslateTransition slideRightsr = new TranslateTransition(Duration.millis(5000), shiproom);
		slideRightsr.setByX(800);
		TranslateTransition slideDownsr = new TranslateTransition(Duration.millis(7000), shiproom);
		slideDownsr.setByY(300);
		SequentialTransition sqsr = new SequentialTransition(slideRightsr,slideDownsr);
		sqsr.play();
		//losing players ship comes from right side of screen, and this part of ship, along with rest of ship, slides right


		p1.setX(135-310); 
		p1.setY(635);
		p1.setFont(Font.font ("Verdana",FontWeight.BOLD,20));
		if(p2hits==16) {
			//if p2 wins, the sinking ship is labeled 'player 1'
			p1.setText("Player 1");
			p1.setFill(javafx.scene.paint.Color.BLUE);
		}
		else {
			//if p1 wins, the sinking ship is labeled 'player 2'
			p1.setText("Player 2");
			p1.setFill(javafx.scene.paint.Color.RED);
		}
		TranslateTransition slideRighttext = new TranslateTransition(Duration.millis(5000), p1);
		slideRighttext.setByX(800);
		TranslateTransition slideDowntext = new TranslateTransition(Duration.millis(7000), p1);
		slideDowntext.setByY(300);
		SequentialTransition sqtext = new SequentialTransition(slideRighttext,slideDowntext);
		sqtext.play();

		window1.setX(168-310); 
		window1.setY(583); 
		window1.setWidth(15); 
		window1.setHeight(15);
		window1.setFill(Color.LIGHTBLUE);
		window1.setStroke(Color.BLACK); 
		window1.setStrokeWidth(3);
		TranslateTransition slideRightw1 = new TranslateTransition(Duration.millis(5000), window1);
		slideRightw1.setByX(800);
		TranslateTransition slideDownw1 = new TranslateTransition(Duration.millis(7000), window1);
		slideDownw1.setByY(300);
		SequentialTransition sqw1 = new SequentialTransition(slideRightw1,slideDownw1);
		sqw1.play();
		//losing players ship comes from right side of screen, and this part of ship, along with rest of ship, slides right

		window2.setX(148-310); 
		window2.setY(583); 
		window2.setWidth(15); 
		window2.setHeight(15);
		window2.setFill(Color.LIGHTBLUE);
		window2.setStroke(Color.BLACK); 
		window2.setStrokeWidth(3);
		TranslateTransition slideRightw2 = new TranslateTransition(Duration.millis(5000), window2);
		slideRightw2.setByX(800);
		TranslateTransition slideDownw2 = new TranslateTransition(Duration.millis(7000), window2);
		slideDownw2.setByY(300);
		SequentialTransition sqw2 = new SequentialTransition(slideRightw2,slideDownw2);
		sqw2.play();
		//losing players ship comes from right side of screen, and this part of ship, along with rest of ship, slides right

		window3.setX(128-310); 
		window3.setY(583); 
		window3.setWidth(15); 
		window3.setHeight(15);
		window3.setFill(Color.LIGHTBLUE);
		window3.setStroke(Color.BLACK); 
		window3.setStrokeWidth(3);
		TranslateTransition slideRightw3 = new TranslateTransition(Duration.millis(5000), window3);
		slideRightw3.setByX(800);
		TranslateTransition slideDownw3 = new TranslateTransition(Duration.millis(7000), window3);
		slideDownw3.setByY(300);
		SequentialTransition sqw3 = new SequentialTransition(slideRightw3,slideDownw3);
		sqw3.play();
		//losing players ship comes from right side of screen, and this part of ship, along with rest of ship, slides right

		shipbase1.setX(1700-310);
		shipbase1.setY(605); 
		shipbase1.setWidth(200); 
		shipbase1.setHeight(45);
		shipbase1.setFill(Color.GREY);
		TranslateTransition slideLeftsb1 = new TranslateTransition(Duration.millis(2000), shipbase1);
		slideLeftsb1.setByX(-300);
		slideLeftsb1.play();
		TranslateTransition slideLeftsb11 = new TranslateTransition(Duration.millis(20000), shipbase1);
		slideLeftsb11.setByX(-1800);
		slideLeftsb1.setOnFinished(event ->{
			//once the winning players ship has moved leftward onto the screen, it will fire a small rocket leftwards toward the losing players ships, and will then continue to go leftward
			slideLeftsb11.play();
			rocket.setX(1400-310);
			rocket.setY(620); 
			rocket.setWidth(50); 
			rocket.setHeight(10);
			rocket.setFill(Color.GREY);
			TranslateTransition slideLeftr = new TranslateTransition(Duration.millis(2000), rocket);
			slideLeftr.setByX(-450);
			slideLeftr.play();
			slideLeftr.setOnFinished(eventt->{
				//once the rocket hits the losing players ship, it turns transparent.
				rocket.setFill(Color.TRANSPARENT);
			});
		});

		shiproom1.setX(1800-310); 
		shiproom1.setY(575); 
		shiproom1.setWidth(70); 
		shiproom1.setHeight(30);
		shiproom1.setFill(Color.GREY);
		shiproom1.setStroke(Color.BLACK); 
		shiproom1.setStrokeWidth(3);
		TranslateTransition slideLeftsr1 = new TranslateTransition(Duration.millis(2000), shiproom1);
		slideLeftsr1.setByX(-300);
		TranslateTransition slideLeftsr11 = new TranslateTransition(Duration.millis(20000), shiproom1);
		slideLeftsr11.setByX(-1800);
		slideLeftsr1.play();
		slideLeftsr1.setOnFinished(event ->{
			//once the rocket is fired, this part of the ship(of the winning player) begins to continue to move leftwards, along with the rest of the parts of the ship 
			slideLeftsr11.play();
		});

		p2.setX(1750-310); 
		p2.setY(635);
		p2.setFont(Font.font ("Verdana",FontWeight.BOLD,20));
		if(p2hits==16) {
			//if p2 wins, the ship that shoots the other ship down, is labeled 'player 2'
			p2.setText("Player 2");
			p2.setFill(javafx.scene.paint.Color.RED);
		}
		else {
			//if p1 wins, the ship that shoots the other ship down, is labeled 'player 2'
			p2.setText("Player 1");
			p2.setFill(javafx.scene.paint.Color.BLUE);
		}
		TranslateTransition slideLefttext2 = new TranslateTransition(Duration.millis(2000), p2);
		slideLefttext2.setByX(-300);
		TranslateTransition slideLefttext22 = new TranslateTransition(Duration.millis(20000), p2);
		slideLefttext22.setByX(-1800);
		slideLefttext2.play();
		slideLefttext2.setOnFinished(event ->{
			//once the rocket is fired, this text on the ship(of the winning player) begins to continue to move leftwards, along with the rest of the parts of the ship 
			slideLefttext22.play();
		});

		window11.setX(1848-310); 
		window11.setY(583); 
		window11.setWidth(15); 
		window11.setHeight(15);
		window11.setFill(Color.LIGHTBLUE);
		window11.setStroke(Color.BLACK); 
		window11.setStrokeWidth(3);
		TranslateTransition slideLeftw11 = new TranslateTransition(Duration.millis(2000), window11);
		slideLeftw11.setByX(-300);
		TranslateTransition slideLeftw111 = new TranslateTransition(Duration.millis(20000), window11);
		slideLeftw111.setByX(-1800);
		slideLeftw11.play();
		slideLeftw11.setOnFinished(event ->{
			//once the rocket is fired, this part of the ship(of the winning player) begins to continue to move leftwards, along with the rest of the parts of the ship 
			slideLeftw111.play();
		});

		window22.setX(1828-310); 
		window22.setY(583); 
		window22.setWidth(15); 
		window22.setHeight(15);
		window22.setFill(Color.LIGHTBLUE);
		window22.setStroke(Color.BLACK); 
		window22.setStrokeWidth(3);
		TranslateTransition slideLeftw22 = new TranslateTransition(Duration.millis(2000), window22);
		slideLeftw22.setByX(-300);
		TranslateTransition slideLeftw222 = new TranslateTransition(Duration.millis(20000), window22);
		slideLeftw222.setByX(-1800);
		slideLeftw22.play();
		slideLeftw22.setOnFinished(event ->{
			//once the rocket is fired, this part of the ship(of the winning player) begins to continue to move leftwards, along with the rest of the parts of the ship 
			slideLeftw222.play();
		});

		window33.setX(1808-310); 
		window33.setY(583); 
		window33.setWidth(15); 
		window33.setHeight(15);
		window33.setFill(Color.LIGHTBLUE);
		window33.setStroke(Color.BLACK); 
		window33.setStrokeWidth(3);
		TranslateTransition slideLeftw33 = new TranslateTransition(Duration.millis(2000), window33);
		slideLeftw33.setByX(-300);
		TranslateTransition slideLeftw333 = new TranslateTransition(Duration.millis(20000), window33);
		slideLeftw333.setByX(-1800);
		slideLeftw33.play();
		slideLeftw33.setOnFinished(event ->{
			//once the rocket is fired, this part of the ship(of the winning player) begins to continue to move leftwards, along with the rest of the parts of the ship 
			slideLeftw333.play();
		});
	}
	public static void main(String[] args) {
		launch(args);
	}
}