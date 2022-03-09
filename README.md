# CS3220 Code Examples

This repository contains Java Servlet and JSP examples used in [my CS3220 class](https://cysun.org/).

The code is organized into "modules", and each module represents the examples used in one week of the class.
For each module, the Java source code is in the `module<X>` package where `<X>` is the module number.
The web resources are under either the `src/main/webapp/module<X>` folder or the
`src/main/webapp/WEB-INF/module<X>` folder.

## Modules

| Module | Subjects |
| :----: | -------- |
| 1 | Instruction to Java Servlets |
| 2 | Handing HTTP Requests |
| 3 | Generating HTTP Responses<br>Cookies and Session Tracking |

## Usage

To run the code, you need to first clone the repository to your computer, then
import the project into Eclipse as a Maven Project.

### Clone Project Repository

First, copy the repository URL `https://github.com/cysun/cs3220-examples.git` .

Then, in Eclipse, open Git perspective (Window -> Perspective -> Open Perspective -> Git).
Click the `Clone a Git Repository` button, and a popup window like the following
would appear:

![Screenshot of Cloning Repository URL](https://mynotes.cysun.org/files/view/1001285)

The URI field should already be filled with the repository URL you copied
earlier; if not, you can simply paste it into the field yourself.

Click the Next button, then on the next screen, click the Next button again. On
the Local Destination screen (shown below), note down the directory where the
repository is going to be cloned to - you will import the project from this
directory later.

![Screenshot of Local Destination Screen](https://mynotes.cysun.org/files/view/1001289)

Click the Finish button to clone the repository, then go back to Java EE
perspective (Window -> Perspective -> Open Perspective -> Java EE).

### Import Project

In Eclipse, from the File menu, select Import -> Existing Maven Projects as shown below:

![Screenshot of Local Destination Screen](https://mynotes.cysun.org/files/view/1001290)

Click the Next button, and on the next screen, set Root Directory to the directory
where the repository was cloned to in the *Clone Project Repository* step.

![Screenshot of Local Destination Screen](https://mynotes.cysun.org/files/view/1001287)

Click the Finish button to import the project. It will take Eclipse a little time
to complete the import (you can see the progress at the bottom right corner of
Eclipse). After the project is imported, you can run it like a Eclipse Dynamic
Web Project, e.g. right click on the project name and select Run As -> Run on Server.

### Update Project

To get new code from the GitHub repository, you can use a `git pull` operation.
In Eclipse, right click on the project name, then select Team -> Pull.
