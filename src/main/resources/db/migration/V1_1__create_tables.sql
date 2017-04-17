CREATE TABLE admin (
  id SMALLINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  login VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL
);

CREATE TABLE doctor (
  id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  surname VARCHAR(50) NOT NULL,
  specialization VARCHAR(100) NOT NULL,
  phone VARCHAR(20) NOT NULL,
  address VARCHAR(100) NOT NULL,
  login VARCHAR(50) UNIQUE NOT NULL,
  password VARCHAR(50) NOT NULL,
  avatar VARCHAR(70) NOT NULL,
  is_working BIT NOT NULL
);

CREATE TABLE nurse (
  id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  surname VARCHAR(50) NOT NULL,
  phone VARCHAR(20) NOT NULL,
  address VARCHAR(100) NOT NULL,
  login VARCHAR(50) UNIQUE NOT NULL,
  password VARCHAR(50) NOT NULL,
  avatar VARCHAR(70) NOT NULL,
  is_working BIT NOT NULL
);

CREATE TABLE patient (
  id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  surname VARCHAR(50) NOT NULL,
  phone VARCHAR(20) NOT NULL,
  address VARCHAR(100) NOT NULL,
  doctor_id INT NOT NULL,
  diagnosis VARCHAR(255) NOT NULL,
  admission_date DATE NOT NULL,
  discharge_date DATE NOT NULL,
  login VARCHAR(50) UNIQUE NOT NULL,
  password VARCHAR(50) NOT NULL,
  avatar VARCHAR(70) NOT NULL,
  FOREIGN KEY (doctor_id) REFERENCES doctor(id)
);

CREATE TABLE location (
  ward_number SMALLINT,
  bed_number SMALLINT NOT NULL,
  patient_id INT UNIQUE NULL,
  PRIMARY KEY (ward_number, bed_number),
  FOREIGN KEY (patient_id) REFERENCES patient(id)
);

CREATE TABLE prescription (
  id INT AUTO_INCREMENT PRIMARY KEY,
  patient_id INT NOT NULL,
  type ENUM ("TREATMENT", "OPERATION") NOT NULL,
  doctor_id INT NOT NULL,
  description VARCHAR(100) NOT NULL,
  frequency SMALLINT NOT NULL,
  start_date DATE NULL,
  final_date DATE NULL,
  appointed_date DATE NOT NULL,
  is_active BIT NOT NULL,
  current_nurse_id INT NULL,
  FOREIGN KEY (patient_id) REFERENCES patient(id),
  FOREIGN KEY (doctor_id) REFERENCES doctor(id),
  FOREIGN KEY (current_nurse_id) REFERENCES nurse(id)
);