![Screenshot_12](https://github.com/user-attachments/assets/4de69680-c5a9-4b38-bbfe-5cc23aa78058)

Step-by-Step Guide to Run a Java Program from Command Line
1. Install Java Development Kit (JDK)
Make sure you have the Java Development Kit (JDK) installed on your computer. You can download it from the official Oracle website.

2. Set Up Environment Variables
Ensure that the JAVA_HOME environment variable is set and the bin directory of your JDK is added to the system PATH.

Windows:
Set JAVA_HOME:
Open the Start Menu and search for "Environment Variables".
Click on "Edit the system environment variables".
In the System Properties window, click on "Environment Variables".
Under "System variables", click "New" and add JAVA_HOME with the path to your JDK directory.
Update PATH:
Find the Path variable under "System variables" and select it.
Click "Edit", then "New", and add the path to the bin directory of your JDK (e.g., C:\Program Files\Java\jdk-15.0.1\bin).

Compile the Java Program
Open your command prompt (CMD) or terminal and navigate to the directory where your India.java file is located. Run the following command to compile your Java program:
javac India.java
