# CarRental-Software 🚗

A professional Java-based desktop application for managing car rental operations, developed using Eclipse IDE with a user-friendly Swing GUI. This project demonstrates complete CRUD functionalities, database connectivity using JDBC, and core Object-Oriented Programming (OOP) concepts.

## 📋 Project Description

This Car Rental Software allows users to register, login, rent cars, return cars, and manage all associated records through a graphical user interface (GUI). It features 5 core Java classes with image-based UI elements and integrates with a MySQL database via XAMPP (on port `3307`). A third-party library `JCalendar-1.4.jar` is used for selecting and managing dates within the application.

> Login credentials (for testing):  
> **Username:** `obaid`  
> **Password:** `12345`

---

## 🔧 Technologies Used

- **Java (Swing GUI)**
- **Eclipse IDE**
- **JDBC**
- **MySQL (via XAMPP, port 3307)**
- **JCalendar-1.4.jar**
- **OOP Concepts**
- **Image-based JFrame design**

---

## 🧱 Application Structure

### 📂 Java Source Files (`src` folder)
- `Login.java` – Login form (fixed admin credentials)
- `Register.java` – Customer registration form
- `CarRegistration.java` – Register new cars
- `RentCar.java` – Car rental form
- `ReturnCar.java` – Return form with fine calculation logic

### 🗃️ Database (MySQL)
- **Database Name:** `manage car`
- **Tables:**
  - `car_rigistration` – Stores registered car details (note: spelling typo preserved intentionally)
  - `customertbl` – Stores customer registration data
  - `renttbl` – Logs rented cars
  - `returntbl` – Logs returned cars and calculates fine

> 💡 **Important**: Fine is calculated as Rs. 1000 per day if the return date exceeds the due date.

---

## 🔁 App Flow

1. **Login:** Admin logs in using fixed credentials.
2. **Customer Registration:** New users register via a dedicated form.
3. **Car Registration:** Manager adds new cars into the system.
4. **Car Renting:** Customer selects and rents an available car.
5. **Return Car:** Customer returns the car; system calculates fines if applicable.
6. **Manager Controls:** Admin can view, edit, or delete records.

---

## 🎯 Features

- Login & Register System (with fixed login credentials)
- Date Picker using JCalendar
- Real-time database connectivity using JDBC
- Car renting and return logic with fine generation
- Manager control panel (view/edit/delete records)
- Image-based styled forms for better UX
- Simple, maintainable, and modular OOP structure

---

## 📸 Demo

> All JFrames include designed visuals with icons/images for a user-friendly interface.

![Login Screenshot](path/to/login_image.png)  
![Register Screenshot](path/to/register_image.png)  
![Rent Screenshot](path/to/rent_image.png)  
![Return Screenshot](path/to/return_image.png)

_(Replace with actual image paths or remove this section if not uploading images)_

---

## ⚠️ Known Issues / Notes

- Table name `car_rigistration` contains a spelling mistake (kept intentionally as per initial schema).
- Fixed admin login (no dynamic user roles implemented).
- No encryption for credentials (for demo/educational use only).
- Application runs on XAMPP using MySQL on port 3307 — make sure Apache and MySQL are running.

---

## 📂 Getting Started

1. Clone this repository.
2. Import the project into Eclipse.
3. Ensure `JCalendar-1.4.jar` is added to your build path.
4. Start XAMPP (Apache + MySQL).
5. Open `http://localhost/phpmyadmin/` and create the database `manage car`.
6. Create the four required tables using your SQL schema or import the dump (if provided).
7. Run the `Login.java` to launch the application.

---

## 🧑‍💻 Author

**Obaid Ullah**  
Java Desktop Application Developer | Student (IT)  
[Your LinkedIn or Email (optional)]

---

## 📄 License

This project is for academic/educational purposes. No commercial license is associated.

