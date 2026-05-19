# 🎓 Student Management System

A robust console-based Java application designed to manage student records efficiently.  
This project demonstrates:

- Clean OOP architecture
- Input validation
- Exception handling
- File persistence using Java I/O

---

# 🚀 Features

## ✅ Add Students
Capture student details including:
- Name
- Age
- Course

The system automatically generates unique sequential IDs such as:

```text
NIIT1
NIIT2
NIIT3
```

---

## ✅ View Records
Displays a clean and formatted list of all registered students.

---

## ✅ Search Functionality
Instantly locate a student using their unique ID.

✔ Case-insensitive search supported.

---

## ✅ Delete Functionality
Safely remove a student record from the system using their ID.

---

## ✅ Input Validation
Prevents users from entering forbidden delimiters like:

```text
@@
```

This protects the file storage system from corruption.

---

## ✅ Data Persistence (Auto Save & Load)

The system automatically:

- Saves student data to a local file (`students.txt`)
- Reloads saved data whenever the application starts

Implemented using:
- `PrintWriter`
- `BufferedReader`

---

## ✅ Crash-Proof Menu
Custom exception handling prevents the application from crashing when users enter invalid menu inputs.

Example:
```text
abc
```

instead of a number.

---

# 🛠️ Project Architecture

The application follows a modular OOP structure.

## 📁 Main.java
Handles:
- Console menus
- User input
- Front-end validation

---

## 📁 Student.java
Represents the student entity using:
- Private fields
- Getters
- Setters
- Encapsulation

---

## 📁 StudentService.java
Acts as the system's “brain”.

Handles:
- Business logic
- Student storage
- File operations
- Save/load functionality

---

# 📋 Data Storage Format

Student data is stored locally inside:

```text
students.txt
```

The system uses a custom delimiter:

```text
@@
```

### Example

```text
John Doe@@21@@Computer Science@@NIIT1
Jane Smith@@23@@Software Engineering@@NIIT2
```

---

# 💻 How To Run

## 📌 Prerequisites

Install:

- Java Development Kit (JDK 17 or higher)

---

## 📌 Steps

### 1️⃣ Clone The Repository

```bash
git clone https://github.com/YOUR_GITHUB_USERNAME/student-management-system.git
```

---

### 2️⃣ Navigate Into The Project Folder

```bash
cd student-management-system
```

---

### 3️⃣ Compile The Java Files

```bash
javac src/*.java
```

---

### 4️⃣ Run The Application

```bash
java -cp src Main
```

---

# 📝 Future Scope

## 🔹 Backup Storage System
Implement a secondary backup `.txt` file that mirrors the primary storage file in case of:
- File corruption
- Unexpected crashes
- Runtime failures

---

## 🔹 MongoDB Integration
Migrate the current flat-file storage system to a full MongoDB NoSQL database after completing core Java structural principles.

---

# 👨‍💻 Author

Developed by:

```text
YOUR_NAME
```

GitHub:

```text
https://github.com/YOUR_GITHUB_USERNAME
```