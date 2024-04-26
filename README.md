# Event-Tickets-System
 
-Event Tickets System is a Java GUI project developed for the University of Jeddah OOR (Object-Oriented Programming) course. 
-The project aims to create a user-friendly interface for a concert ticket booking system. 
-The application utilizes Java Swing to provide an interactive graphical user interface.

-The system allows users to input their payment details, including card number, cardholder name, and CVV. The payment details are validated, ensuring that all 
 required fields are filled and the input meets the specified criteria. If the details are valid, the system proceeds to generate a receipt.
 The receipt displays the relevant information, such as ticket details and payment summary, which are read from a file named "Receipt.txt". The receipt is 
 presented in a non-editable text area, providing a clear overview of the transaction to the user.
 By combining the functionality of capturing payment details, performing validation, and displaying a receipt, the Event Tickets System offers an intuitive and 
 efficient approach to booking concert tickets. The graphical user interface enhances user experience, making the process seamless and enjoyable for users.
 

#Sign-Up window
The window allows users to sign up by providing their personal information such as name, email, password, phone number, and city. The code is written in Java and utilizes the Swing library for creating the graphical user interface.
  -Functionality
      - The Sign-Up window is a subclass of `JFrame` and has a fixed size of 320x590 pixels.
      - The window consists of various components such as labels, text fields, combo box, buttons, and an image panel.
      - The user interface is built using different panels, including `signup_Panel`, `image_Panel`, `Button_Panel`, `error_Panel`, and `Panel1`.
      - The `signup_Panel` contains labels and text fields for entering the user's name, phone number, email, password, and confirming the password.
      - The `city_comboBox` is a drop-down menu allowing the user to choose their city from a predefined list.
      - The `signup_Button` triggers the sign-up process when clicked. It performs validation on the entered data and writes the user's information to a file named       "customer.txt" if all requirements are met.
      - The `reset_Button` clears all input fields when clicked.
  - Usage
      1. Instantiate the `SignUpWindow` class.
      2. Set the desired properties of the window, such as the title and close operation.
      3. Call the `buildSignupPage()` method to build the user interface.
      4. Add the necessary panels to the content pane of the window using the `add()` method.
      5. Set the window's location using `setLocationRelativeTo(null)` to center it on the screen.
      6. Display the window by calling `setVisible(true)`.
      Note: Make sure to have the necessary image file ("signup.gif") in the same directory as the Java source file.




#Login window
  -Functionality
      - The Login window is a subclass of `JFrame` and has a fixed size of 280x440 pixels.
      - The window consists of various components such as labels, text fields, password field, buttons, and an image panel.
      - The user interface is built using different panels, including `Login_Panel`, `image_Panel`, `signup_Panel`, `error_Panel`, and `Panel1`.
      - The image panel (`image_Panel`) displays an image of a login interface.
      - The login panel (`Login_Panel`) contains labels and text fields for entering the user's email, phone number, and password.
      - The login button (`Login_Button`) triggers the login process when clicked. It performs validation on the entered data and checks against a file named               "customer.txt" to verify the user's credentials. If the credentials are correct, it opens the EventsMenu window.
      - The signup button (`signup_Button`) opens the Sign-Up window when clicked.
      - The error panel (`error_Panel`) displays error messages if any field is left empty or if the entered credentials are incorrect.
  -Usage
      1. Instantiate the `LoginWindow` class.
      2. Set the desired properties of the window, such as the title and close operation.
      3. Call the `buildLoginPage()` method to build the user interface.
      4. Add the necessary panels to the content pane of the window using the `add()` method.
      5. Set the window's location using `setLocationRelativeTo(null)` to center it on the screen.
      6. Display the window by calling `setVisible(true)`.


#Greeting Window
    - The `GreetingWindow` class extends `JFrame` to create a window for displaying the greeting and buttons.
    - The class includes various fields such as labels, an image label, buttons, and panels.
    - The constructor sets up the window by setting its title, size, and close operation. It also creates a label for displaying the greeting and sets its                 properties such as font, size, color, and border.
    - The window layout is set to a 3x1 grid using `GridLayout`.
    - The `buildLogInButtonPanel()` method creates a panel and a "Login" button with specific properties such as font, foreground, and background colors. It               registers an ActionListener to handle button clicks.
    - The `buildExitButtonPanel()` method creates a panel and an "Exit" button with similar properties to the login button. It also registers an ActionListener to         exit the application when the button is clicked.
    - The ActionListener classes (`ExitButtonListener` and `LogInButtonActionListener`) handle the actions performed when the exit button and login button are             clicked, respectively. They implement the `actionPerformed()` method to define the actions to be taken.
    - The `main()` method instantiates the `GreetingWindow` class to display the initial greeting window. 
       To run the code, execute the `main()` method. The window will appear with the greeting, "Welcome To Event Tickets System," an image, and two buttons:   
       "Login"  and "Exit." Clicking the login button will open the Login window, and clicking the exit button will exit the application.



#Events Menu for an event ticket system. 
      - The `EventsMenu` class extends `JFrame` to create a window for displaying the events menu.
      - The class includes various fields such as labels, a menu bar, menus, and menu items.
      - The constructor takes parameters for the user's name, number, and email, and sets up the window by setting its title, size, and close operation. It also 
      creates an image label and adds it to the frame.
      - The `builMenuBar()` method is responsible for building the menu bar and adding menus to it.
      - The `buildFileMenu()` method creates a "File" menu with menu items for exiting the application, accessing the About Us page, and getting help.
      - The `buildEventsMenu()` method creates an "Events" menu with menu items for different event categories such as Concerts and Matches.
      - ActionListener classes are implemented to handle the actions performed when menu items are clicked. These include the ExitListener, AboutUsIListener, 
      HelpIListener, ConcertsListener, and matchesListener.
      - The ExitListener class handles the action of exiting the application when the "Exit" menu item is clicked.
      - The AboutUsIListener class displays a message dialog with information about the event ticket system when the "About Us" menu item is clicked.
      - The HelpIListener class displays a message dialog with instructions on how to use the application when the "Help" menu item is clicked.
      - The ConcertsListener and matchesListener classes open new windows (Concerts and Matches) specific to the selected event category when the corresponding 
      menu items are clicked.
      - The main() method is not present in the provided code.


#Concertt
      1. The `buildRadio()` method creates a panel to hold a label and three radio buttons representing different concerts. The radio buttons are added to a button 
      group and then added to the `radioPanel` panel.
      2. The `buildDate_category_Panel()` method creates two panels: `datePanel` and `categoryPanel`. Each panel contains a label and a combobox (drop-down menu) 
      for selecting the date and category of the concert, respectively. These two panels are then added to the `combination` panel.
      3. The `buildTicketsNumPanel()` method creates a panel (`ticketsNumPanel`) with a label and a text field for entering the number of tickets. 
      4. The `buildPaymentPanel()` method creates a panel (`payment`) with a "Payment" button and an error label. The button has an ActionListener attached to it, 
      which will handle the payment process.
      5. The `paymentListener` class is an ActionListener implementation. It has a constructor that takes three parameters: name, number, and email. In the 
      `actionPerformed` method, it retrieves the selected date, category, ticket number, and concert name from the corresponding components. It also performs some 
      validation checks.
         
      1. If the `concert1` radio button is selected, it sets the `concertName`, `price`, `total_price`, `gate`, and `Stadium` variables based on the selected 
      ticket category. Then it creates a `PrintWriter` object to write to the `Receipt.txt` file. It writes the customer information, concert information, and 
      other relevant details to the file. Finally, it closes the file and sets the `flag` variable to `true`.
      2. If the `concert2` radio button is selected, it follows the same steps as for `concert1` but with different values for the concert details.
      3. If the `concert3` radio button is selected, it follows the same steps as for `concert1` and `concert2` but with different values for the concert details.
      4. If there is an exception while creating the `PrintWriter` object (e.g., file not found), it displays an error message using a `JOptionPane`.
      
      1. After writing the customer and concert information to the `Receipt.txt` file, the code closes the file and sets the `flag` variable to `true`.
      2. If there was an exception while creating the `PrintWriter` object (e.g., file not found), it displays an error message using a `JOptionPane`.
      3. If the `flag` variable is `true`, meaning the receipt was successfully written to the file, it creates an instance of the `Payment` class and makes it 
      visible. It also disposes of the current frame.
      4. Finally, there is a `CalculateTotal` method that takes the `price` and `ticketNum` as parameters and calculates the total price by multiplying the price 
      by the number of tickets. It also calculates the tax as 10% of the subtotal and adds it to the subtotal to get the total price.



#Bill
    1. The class extends `JFrame` and contains several private member variables representing different components of the receipt page.
    2. The constructor initializes the frame, sets the title, default close operation, and size. It then calls the `buildReceiptPage` method to build the     
    components of the receipt page and adds them to the frame.
    3. The `buildReceiptPage` method creates the panels (`receipt_panel`, `bill_details`, `done_panel`) and initializes the receipt label (`receipt`), the bill 
    text area (`bill_txt`), and the "Done" button (`Done`).
    4. The `bill_txt` text area is set to be non-editable. Then, it tries to read the content of the "Receipt.txt" file using a `FileReader`, `BufferedReader`, ]
    and `read` method. If an exception occurs, it displays an error message using a `JOptionPane`.
    5. The `ButtonListener` class implements the `ActionListener` interface and overrides the `actionPerformed` method. In this case, when the "Done" button is 
    clicked, it calls `System.exit(0)` to exit the program.



#Payment class 
      1. The class extends `JFrame` and contains private member variables representing different components of the payment page.
      2. The constructor initializes the frame, sets the title, default close operation, and size. It then calls the `buildPaymentPage` method to build the 
      components of the payment page and adds them to the frame.
      3. The `buildPaymentPage` method creates several panels (`details_Panel`, `image_Panel`, `error_Panel`, `button_Panel`, `topic_Panel`, `panel1`, `panel2`) 
      and sets their layouts accordingly.
      4. An image is added to the `image_Panel` using a `JLabel` and an `ImageIcon`. The image is displayed with a black border.
      5. The `topic_Panel` contains a label (`topic`) indicating the card details.
      6. Labels (`card_number`, `holder_name`, `cvv_label`) and text fields (`number_txt`, `holder_txt`, `cvv_txt`) are added to the `details_Panel` to capture 
      the card details from the user.
      7. The `panel1` is set up with a `BorderLayout` and includes the `image_Panel` in the north position and the `details_Panel` in the center position.
      8. The "Proceed" button (`proceed_Button`) is added to the `button_Panel`, and a `ButtonListener` is attached to it for handling the button click event. The 
      button is styled with white text on a black background.
      9. An error label (`error_Label`) is added to the `error_Panel` to display any validation errors.
      10. The `panel2` is set up with a `BorderLayout` and includes the `button_Panel` in the north position and the `error_Panel` in the center position.
      11. The `ButtonListener` class implements the `ActionListener` interface and overrides the `actionPerformed` method. It retrieves the card details entered 
      by the user, performs validation checks, and if the details are valid, it creates an instance of the `Bill` class and makes it visible. It also disposes of 
      the current frame.


