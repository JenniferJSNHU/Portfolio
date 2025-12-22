/*
 * Project Two: ABCU Advising Assistance Program
 * Course: CS 300 Data Structures and Algorithms
 * Author: Jennifer Joseph
 * Date: December 2025
 *
 * Purpose:
 * This program allows Computer Science advisors at ABC University to load course data
 * from a user provided CSV file, store it in an appropriate data structure, and retrieve
 * course information for advising purposes.
 *
 * Objectives:
 * - Prompt the user for a course data file and load it into the program
 * - Store course objects using an efficient data structure
 * - Display an alphanumeric list of all courses
 * - Allow lookup of an individual course and its prerequisites
 * - Validate user input and handle errors gracefully
 */

#include <algorithm>        
#include <cctype>           
#include <fstream>          
#include <iostream>         
#include <sstream>          
#include <string>           
#include <unordered_map>    
#include <vector>           

using namespace std;

// Represents a course with its number, title, and prerequisites
struct Course {
    string courseNumber;    
    string title;           
    vector<string> prereqs; 
};

// Trims leading and trailing whitespace from a string
static inline string trim(const string& s) {
    size_t start = 0;

	// move start forward past leading whitespace
    while (start < s.size() && isspace(static_cast<unsigned char>(s[start]))) {
        ++start;
    }

    size_t end = s.size();

	// move end backward past trailing whitespace
    while (end > start && isspace(static_cast<unsigned char>(s[end - 1]))) {
        --end;
    }

    // return the trimmed string
    return s.substr(start, end - start);
}

// Converts a string to uppercase and returns a copy
static inline string toUpperCopy(string s) {
    for (char& ch : s) {
        ch = static_cast<char>(toupper(static_cast<unsigned char>(ch)));
    }
    return s;
}

// Splits a CSV line into tokens using a simple comma delimiter
static vector<string> splitCsvSimple(const string& line) {
    vector<string> tokens;
    string token;
    stringstream ss(line);

	// split the line by commas
    while (getline(ss, token, ',')) {
        tokens.push_back(trim(token));
    }

    return tokens;
}

// Prints the main menu options
static void printMenu() {
    cout << endl;
    cout << "1. Load Data Structure." << endl;
    cout << "2. Print Course List." << endl;
    cout << "3. Print Course." << endl;
    cout << "9. Exit" << endl;
    cout << endl;
}

// Loads course data from a CSV file into the provided hash table
static bool loadCoursesFromFile(
    const string& fileName,
    unordered_map<string, Course>& courses,
    string& errorMessage
) {
	// clear any existing data
    courses.clear();

	// open the input file
    ifstream infile(fileName);
    if (!infile.is_open()) {
        errorMessage = "Error: Could not open file: " + fileName;
        return false;
    }

	// store prerequisite references for validation
    vector<pair<string, string>> prereqRefs;
    string line;
    int lineNumber = 0;

	// read each line from the file
    while (getline(infile, line)) {
        ++lineNumber;

		// trim whitespace
        line = trim(line);
        if (line.empty()) {
            continue;
        }

		// split the line into tokens
        vector<string> tokens = splitCsvSimple(line);

		// validate minimum field count
        if (tokens.size() < 2) {
            errorMessage = "Format Error on line " + to_string(lineNumber) +
                ": expected at least 2 fields";
            courses.clear();
            return false;
        }

		// extract course number and title
        string courseNum = toUpperCopy(tokens[0]);
        string courseTitle = tokens[1];

		// validate required fields
        if (courseNum.empty() || courseTitle.empty()) {
            errorMessage = "Format Error on line " + to_string(lineNumber) +
                ": missing course number or title";
            courses.clear();
            return false;
        }

		// check for duplicate course numbers
        if (courses.find(courseNum) != courses.end()) {
            errorMessage = "Format Error on line " + to_string(lineNumber) +
                ": duplicate course number " + courseNum;
            courses.clear();
            return false;
        }

		// create the course object
        Course c;
        c.courseNumber = courseNum;
        c.title = courseTitle;

		// process prerequisite course numbers
        for (size_t i = 2; i < tokens.size(); ++i) {
            string prereqNum = toUpperCopy(tokens[i]);
            if (!prereqNum.empty()) {
                c.prereqs.push_back(prereqNum);
                prereqRefs.push_back({ courseNum, prereqNum });
            }
        }

		// insert the course into the hash table
        courses.emplace(courseNum, c);
    }

    infile.close();

	// validate that all prerequisites exist
    for (const auto& ref : prereqRefs) {
        const string& courseNum = ref.first;
        const string& prereqNum = ref.second;

        if (courses.find(prereqNum) == courses.end()) {
            errorMessage = "Prerequisite Error: " + courseNum +
                " references missing course " + prereqNum;
            courses.clear();
            return false;
        }
    }

    return true;
}

// Prints an alphanumeric list of all courses
static void printCourseList(const unordered_map<string, Course>& courses) {
    vector<string> keys;

	// reserve space for course numbers
    keys.reserve(courses.size());

	// collect all course numbers
    for (const auto& kv : courses) {
        keys.push_back(kv.first);
    }

	// sort course numbers alphanumerically
    sort(keys.begin(), keys.end());

        cout << "Here is a sample schedule:\n" << endl;

	// print each course in sorted order
    for (const string& key : keys) {
        const Course& c = courses.at(key);
        cout << c.courseNumber << ", " << c.title << endl;
    }
}

// Prints detailed information for a specific course
static void printCourseInformation(
    const unordered_map<string, Course>& courses,
    const string& courseNumberInput
) {
	// normalize the course number input
    string courseNumber = toUpperCopy(trim(courseNumberInput));

	// look up the course in the hash table
    auto it = courses.find(courseNumber);
    if (it == courses.end()) {
        cout << "Course not found: " << courseNumber << endl;
        return;
    }

    const Course& c = it->second;

    cout << endl;
    cout << c.courseNumber << ", " << c.title << endl;

	// print prerequisites
    if (c.prereqs.empty()) {
        cout << "Prerequisites: None" << endl;
        return;
    }

    cout << "Prerequisites:";

	// list all prerequisites
    for (size_t i = 0; i < c.prereqs.size(); ++i) {
        cout << c.prereqs[i];
        if (i < c.prereqs.size() - 1) {
            cout << ", ";
        }
    }

    cout << endl;
}

// Reads an integer from user input with validation
static bool readIntFromUser(const string& prompt, int& outValue) {
    cout << prompt;
    string line;

	// read a line of input
    if (!getline(cin, line)) {
        return false;
    }

    line = trim(line);

	// check for empty input
    if (line.empty()) {
        return false;
    }

    try {
        size_t idx = 0;
        int value = stoi(line, &idx);

		// ensure entire line was consumed
        if (idx != line.size()) {
            return false;
        }

        outValue = value;
        return true;
    }
    catch (...) {
        return false;
    }
}

int main() {
    unordered_map<string, Course> courses; 
    bool dataLoaded = false;               

    cout << "Welcome to the course planner." << endl;

	// main program loop
    while (true) {
        printMenu();

        int choice = 0;

		// read user menu choice
        if (!readIntFromUser("What would you like to do? ", choice)) {
            cout << choice << " is not a valid option." << endl;
            continue;
        }

		// load course data from file
        if (choice == 1) {
            cout << "Enter the file name: ";
            string fileName;
            getline(cin, fileName);
            fileName = trim(fileName);

            string errorMessage;

            if (loadCoursesFromFile(fileName, courses, errorMessage)) {
                dataLoaded = true;
                cout << "Course data loaded successfully" << endl;
            }
            else {
                dataLoaded = false;
                cout << errorMessage << endl;
            }
        }
		// print course list
        else if (choice == 2) {
            if (!dataLoaded) {
                cout << "Error: Please load course data first" << endl;
            }
            else {
                printCourseList(courses);
            }
        }
		// print individual course information
        else if (choice == 3) {
            if (!dataLoaded) {
                cout << "Error: Please load course data first" << endl;
            }
            else {
                cout << "What course do you want to know about? ";
                string courseNumber;
                getline(cin, courseNumber);
                printCourseInformation(courses, courseNumber);
            }
        }
		// exit the program
        else if (choice == 9) {
            cout << "Thank you for using the course planner!" << endl;
            break;
        }
		// invalid menu option
        else {
            cout << choice << " is not a valid option." << endl;
        }
    }

    return 0;
}
