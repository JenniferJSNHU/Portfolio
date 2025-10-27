Program Reflection – Essential Questions

How do I interpret user needs and implement them into a program? How does creating “user stories” help with this?
- Understanding user needs begins with viewing the project from the customer's perspective. It's important to focus on the problems they need solved, rather than just the features they request. Creating user stories helps to clarify those needs by presenting them in simple, goal-oriented language, such as “As a user, I want to…". This approach allowed me to translate general expectations into specific, actionable requirements during development. For instance, in the SNHU Travel project, user stories guided my focus towards functionality that enhanced the user’s booking experience, rather than merely completing technical tasks. By prioritizing and refining user stories throughout the sprints, I ensured that the program’s features aligned closely with real user goals.

How do I approach developing programs? What Agile processes do I hope to incorporate into my future development work?
- I view program development as an iterative and collaborative process that evolves through testing and feedback. My experience with Agile practices, particularly Scrum, has taught me to break significant goals into smaller, manageable increments that can be improved over time. In future projects, I will continue to use sprint planning, daily stand-ups, and retrospectives to stay organized and responsive to change. Continuous integration, adaptive planning, and regular feedback loops will help ensure the delivery of high-quality software that meets stakeholder needs, while also allowing for flexibility as those needs evolve.

What does it mean to be a good team member in software development?
- Being a good team member means contributing more than just code—it means communicating clearly, supporting others, and staying open to feedback. In an Agile team, collaboration and transparency are just as important as technical skills. A good teammate, by participating actively in discussions, helps remove obstacles for others, and respects different viewpoints. This active participation makes each member feel valued and integral to the team. It also means being accountable for your work and adaptable when priorities shift. The best development teams succeed because they trust one another, share ownership of outcomes, and continuously learn from each sprint.

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Project Reflection – Airgead Banking App

Project Summary
This project involved developing an interactive banking application for Airgead Banking that demonstrates the power of compound interest. The program allows users to input their initial investment, monthly deposit, annual interest rate, and the number of years to see how their money grows over time. It generates two reports: one showing investment growth without additional monthly deposits and another showing investment growth with monthly deposits. The goal was to help users understand how compound interest affects long-term investments.

What I Did Well
I excelled at implementing clean, user-friendly input validation. My program accepts inputs that include symbols such as $ and %, as well as the word “years,” and safely converts them to numeric values. I focused on producing well-formatted output with clear tables and aligned columns, making the reports easy to read and professional in appearance. Additionally, I incorporated pauses and prompts to ensure smooth user interaction.

Areas for Enhancement
I could enhance the program by refactoring it into a fully object-oriented design, with classes for the investment profile, calculator, and display renderer. This would improve modularity and make future updates easier. Another improvement would be to optimize compound interest calculations by using more precise rounding and consistent formatting via a helper function. Finally, implementing input loops to allow users to test multiple scenarios without restarting the program would make the app more interactive and efficient.

Challenges and Solutions
The most challenging aspect of the project was correctly implementing the compound interest formulas, particularly in distinguishing between monthly and yearly compounding. I initially struggled to obtain an accurate annual interest total. However, I overcame this by breaking the calculation into monthly steps and verifying my results against sample outputs and online compound interest calculators. I also relied on debugging output, C++ documentation, and examples from Zybooks to confirm my logic.

Transferable Skills
From this project, I gained experience in C++ input validation, formatted console output using <iomanip>, and working with loops and mathematical formulas. These skills are transferable to future programming tasks that require data handling, validation, or formatted reporting. I also strengthened my understanding of modular programming and debugging, which will be valuable in larger software development projects.

Code Quality and Maintainability
To ensure the code is maintainable and readable, I used descriptive variable names, consistent indentation, and clear inline comments to explain the purpose of each function and key formulas. I logically separated tasks into functions for input, display, and calculations, which makes the code easier to test and adapt. Using standard libraries such as <iomanip>, <string>, and <algorithm> improved portability and security by avoiding unsafe C-style input-handling practices.
