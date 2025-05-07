# AOOC - Project Assessment

## Agenda
1. [Introduction](#1-introduction)
2. [Minimum Project Requirements](#2-minimum-project-requirements)
3. [Minimum Feature Requirements](#3-minimum-feature-requirements)
4. [Coding Standards](#4-coding-standards)
5. [Enhanced Features](#5-enhanced-features)  
6. [Project Submission Process](#6-project-submission-process)  
   6.1. [Screencast Demonstration](#61-screencast-demonstration)  
   6.2. [Moodle Submission](#62-moodle-submission)
7. [Important Notes](#7-important-notes)
8. [Grading Rubric](#8-grading-rubric)

## 1. Introduction

For this project you are required to design and develop a JavaFX GUI (Graphical User Interface) application. The application must manage objects of the type you have chosen from the `Project Object Choice List`, which is available on the Moodle page (e.g. Elephant). You will use an ArrayList to store and manage the objects (e.g. Elephants).

## 2. Minimum Project Requirements
- You must use the Project GitHub Repository provided to you on the Moodle page. No other development set up will be acceptable. This link to create your repository can be found under the `Project Assessment` section on Moodle. You need to click on the link to create your repository. This repository will contain all documentation, application code and any resources (e.g., input and output files, images etc) used by your application. Please note, no materials outside of your GitHub repository are gradable. Using another GitHub repository or not using GitHub at all for this project will incur a penalty of 60%. If you do not understand what is meant by this, then email me before you begin your project.
- This application must be developed using GitHub Codespaces.
- Project development must be tracked on GitHub via regular commits. Your GitHub repository must have at minimum two commits per week, if not I may contact you for a live project demonstration. The project will be capped at 40% if you fail to attend this meeting.
- The README file should contain clear instructions for compiling, deploying, and running the application. It should also briefly outline the nature of the project and detail the set of features it contains. All sections of the README template must be filled out and add more sections if you please.

## 3. Minimum Feature Requirements
The application must incorporate, at minimum, the following features:
- 3 classes (Main, a class to define the object you chose and a manager class for the objects you create)
- A Java collections ArrayList to store your objects.
- A class to manage these objects. This manager class must be able to add, remove, serialize, deserialize, find total and search for the objects in the ArrayList you create.
- Use of the Stream API to assist mainly with searching and streaming the ArrayList to a file
- File IO to save your arraylist to a file and read objects from a file
- Exception Handling to assist the IO
- Serialisation of Objects to a file
- JavaFX GUI defined in a Main class

```mermaid
graph TD
    A[JavaFX Project] --> B[src]
    B --> C[ie.atu.javafx]
    C --> D[Main.java]
    C --> E[myObject.java]
    C --> F[myObjectManager.java]
    A --> G[resources]
    G --> H[styles.css]
    G --> I[myObjects.ser]
    G --> J[myObjects.csv]
```

## 4. Coding Standards
- Your code must compile.
- Consistent code formatting.
- Code commentary is essential. Comment every class and method at minimum.

## 5. Enhanced Features
To achieve a high grade:
- Go above and beyond the minimum by adding extra methods (e.g., a method to list all objects by their unique ID in the array) and features (e.g., ask the user to choose the size of the array) to your application which you have researched yourself. Document any extra methods or features in your README.
- Add JavaFX features not demonstrated in labs.
- Create an animated gif of you using your application and add it to your Readme.
- Create an executable jar file that opens your application independently and include this in your GitHub repository.

## 6. Project Submission Process
You **must** follow this submission process carefully. If you miss any part, especially the screencast, you will be penalised.

### 6.1. Screencast Demonstration
- 5-minute screen recording using [MS Stream](https://www.microsoft365.com/launch/stream), YouTube or any tool of your choosing.
- Download the screencast video file. This will be uploaded to the moodle submission area along with your code.
- Demonstrate your app running and its operation
- Give a brief code walkthrough highlighting places where you expended most of your effort
- Highlight any additional functionality you implemented
- **MAKE SURE YOUR SCREENCAST IS ACCESSIBLE BY ME**. CHECK STREAMS/OneDrive PERMISSIONS and make sure it can be seen by me. It is your responsibility to make sure I can see the screencast. If I can not your grade will be capped at 40%.

### 6.2. Moodle Submission
- [Download a copy of your final Git repository from the GitHub website.](https://youtube.com/shorts/4bDLccFjQyc?si=dWUDWoW4B_tnADty)
- In the submission area on Moodle, where you will upload your zipped project, you will see a text box in which you will be able to enter text (See sample below). Put the URL link to your project GitHub repository and the URL link to your MS Streams screencast recording you created.
- Upload this zip file of your code and your screencast video under the submission link on Moodle. You can find the submission link under the Final Project section on the Moodle page.
- Submit the file to Moodle before the due date. The due date can be found by clicking on the submission link on Moodle. Late submissions will incur a 10% penalty per day.

  #### Sample Textbox Input
  <pre>
  <b>Screencast Link:</b> https://atlantictu-my.sharepoint.com/:v:/g/personal/daniel_cregg_atu_ie/Ed9h1upB77VFuIm0ezGYj8MBlOaHCoiWUJkLUFqj0Z9OJQ?e=ua2JM1
  <b>GitHub Link:</b> https://github.com/DanielCreggOrganization/ooc2-final-project-2021-annmurphy
  </pre>

## 7. Important Notes
1. Only materials within this GitHub repository will be graded. (40% grade cap if missed)
2. Insufficient commits may require a live demonstration (40% grade cap if missed)
3. Late submissions incur a 10% penalty per day

## 8. Grading Rubric

| Area | Poor<br>(0-39) | Fair<br>(40-49) | Good<br>(50-59) | Very Good<br>(60-69) | Excellent<br>(70-100) |
|------|----------------|-----------------|-----------------|---------------------|---------------------|
| **UI/UX** | • Basic template-like<br>• Minimal effort<br>• Poor navigation<br>• Inconsistent design | • Basic effort shown<br>• Meets minimums<br>• Navigation works<br>• Shows competency | • Consistent design<br>• Intuitive navigation<br>• Beyond basic requirements | • Bespoke elements<br>• Consistent design<br>• Fluid navigation<br>• Above requirements | • Professional finish<br>• Innovative design<br>• Flawless UX<br>• Cohesive elements<br>• Exceeds requirements |
| **Technical** | • Inconsistent code<br>• Unfinished sections<br>• Poor formatting | • Basic competence<br>• No new elements<br>• Meets minimums | • Good structure<br>• Technical mastery<br>• Minor added extras | • Professional code<br>• Clean architecture<br>• Consistent style | • Excellence shown<br>• Advanced features<br>• Perfect structure |
| **Docs** | • Basic README<br>• Few commits<br>• Poor submission | • Basic sections done<br>• Sporadic commits<br>• Meets minimums<br>• Minimal comments | • Good GitHub usage<br>• Detailed README<br>• Regular commits<br>• Clear comments | • Bespoke content<br>• Clean repo<br>• Detailed docs | • Professional docs<br>• Rich media<br>• Perfect GitHub use<br>• Research depth |
