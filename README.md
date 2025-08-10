British Spoken Time Converter

Overview
--------
The British Spoken Time Converter is a simple Java application that converts a given time in HH:mm format into its spoken form according to British English conventions.

Example:
Input:  14:45
Output: quarter to three

Features
--------
- Converts 24-hour format to British-style spoken time.
- Handles:
  - Exact hours (e.g., 15:00 → three o’clock)
  - Half past times (e.g., 15:30 → half past three)
  - Quarter past and quarter to times
  - Other minutes with correct phrasing
- Unit tested with JUnit

Project Structure
-----------------
BritishTimeConverter/
│
├── src/
│   ├── main/java/com/example/time/
│   │   ├── TimeSpokenForm.java
│   │   ├── BritishTimeSpokenForm.java
│   │   ├── TimeSpokenFormFactory.java
│   │   └── Main.java
│   │
│   └── test/java/com/example/time/
│       └── BritishTimeSpokenFormTest.java
│
├── pom.xml
└── README.txt

Installation & Usage
--------------------
1. Clone the repository
   git clone https://github.com/agarwal-shreya-3010/BritishSpokenConverter.git
   cd BritishSpokenConverter

2.  Compile and run the Main class
	C:\BritishSpokenConverter\src\main\java\com\example\time> javac *.java                        
    C:\BritishSpokenConverter\src\main\java\com\example\time> java Main.java

   OR alternatively can use this command
	mvn clean compile
	mvn exec:java
	Enter the input when prompted to see the result.

3.  Run tests
	C:\BritishSpokenConverter\src\test\java\com\example\time\BritishTimeSpokenFormTest.java and run this file
 

Example Run
-----------
Input:
Enter time in HH:mm: 05:15

Output:
quarter past five


Importants points considered:

1. Used interfaces to define behavior (TimeSpokenForm), enabling future extensions for other time formats without changing existing logic.
2. Factory Pattern is used via TimeSpokenFormFactory —
   This centralizes object creation and hides implementation details from the client code (Main), making it easy to switch formats in the future.
3. Object Oriented principles
   
	Abstraction — TimeSpokenForm defines a contract for time conversion without exposing implementation details.

	Encapsulation — formatting logic is contained inside the BritishTimeSpokenForm class.

	Polymorphism — new time formats can be added by implementing the TimeSpokenForm interface and plugging them into the factory.
	
	Single Responsibility Principle — each class has one clear purpose.
4.	The BritishTimeSpokenFormTest class contains clear and focused unit tests.

