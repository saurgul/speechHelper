## Speech Helper - Web-based Public Speaking Skills Improvement Application

### Team 2 - CSCI-P 532 Project - Final

#### Luddy School of Informatics, Computing, and Engineering

##### Team Members: Christian Dummer, Saurabh Gulati, Snehal Patare, Dhruti Patel, Pratyush Duklan

## Overview

Speech Helper is a powerful web-based application designed to assist users in improving their public speaking skills and boosting confidence in delivering speeches. The application analyzes both uploaded and live-recorded text or speech, providing users with valuable feedback to overcome speech-related anxiety and become more confident speakers.

Key Features:
- Filler Word Detection: Helps users identify and reduce the usage of filler words in their speeches, enhancing overall speech quality and clarity.
- Speaking Pace Improvement: Provides guidance on improving speaking pace, ensuring users maintain an engaging and steady flow during their presentations.
- Spelling Suggestions: Offers spelling fixes to help users maintain accuracy and professionalism in their written content.
- Sentiment Analysis: Utilizes machine learning in Python to perform sentiment analysis on speech, providing users with insights into their speech tone during delivery.
- Performance Scoring: Calculates an overall performance score, enabling users to track their progress over time and improve their public speaking skills periodically through regular practice.
- Online Speech Recording: Allows users to conveniently record speeches directly within the application.
- Learning Resources: Provides access to texts and speeches from famous speakers to aid users in enhancing their public speaking techniques.

## Architecture

The application is built on a robust architecture using the following technologies:

- Backend: Java's Spring framework provides the foundation for the backend functionality.
- Frontend: ReactJs powers the dynamic and user-friendly frontend, ensuring a seamless user experience.
- Database: MySQL is utilized to store user data, facilitating progress tracking and continuous improvement.
- Design Patterns: The project incorporates the MVC (Model-View-Controller), Command, and Builder design patterns for well-organized and scalable code.

## Installation Steps

To run the project on localhost, follow these steps:

1. Setting up the Python Environment:
   - Download and Install Python from https://www.python.org/downloads/
   - Install pip from Python (https://pip.pypa.io/en/stable/installation/#get-pip-py)
   - Install the following libraries from the command line:
     ```
     pip install tensorflow
     pip install librosa
     pip install pipwin
     pipwin install pyaudio
     pip install pandas
     pip install SpeechRecognition
     ```

2. Setting up the Frontend:
   - Download Node.js from https://nodejs.org/en/download/
   - Navigate to frontend/app in the command line.
   - Run the following commands to install all dependencies:
     ```
     npm install
     npm start
     ```
   The frontend will be accessible at localhost:3000.

3. Running the Backend:
   - Execute the main class in the package com.speechhelper.main to start the backend.

Once the above steps are completed successfully, the application's frontend should be up and running, allowing users to generate reports, create accounts, log in, and track their progress on their public speaking journey.

For any further assistance or queries, please contact the team members mentioned in the "Team Members" section.

**Note**: Ensure that all prerequisites and dependencies are installed properly to experience the full functionality of Speech Helper.
