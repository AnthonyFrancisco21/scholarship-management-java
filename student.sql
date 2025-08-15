-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 15, 2025 at 02:36 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bucot_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `student_id` int(11) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `middle_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `birthday` varchar(50) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `purok` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `status_id` int(11) DEFAULT NULL,
  `sub_id` int(11) DEFAULT NULL,
  `role` varchar(50) DEFAULT 'student'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`student_id`, `first_name`, `middle_name`, `last_name`, `birthday`, `sex`, `purok`, `email`, `password`, `status_id`, `sub_id`, `role`) VALUES
(1, 'Juan', 'Dela', 'Cruz', '2000-05-05', 'Male', 'Purok 3', 'student@gmail.com', 'password123', 4, 7, 'student'),
(2, 'Juan', 'Ronnie', 'Jesus', '2002-3-14', 'Male', '4', 'juan@gmail.com', '11111111', NULL, NULL, 'student'),
(3, 'delo', 'cruz', 'jose', '2002-1-35', 'Male', '1', 'delo@gmail.com', '12345678', 4, NULL, 'student'),
(4, 'Gusion', 'dela cruz', 'vega', '2001-6-4', 'Male', '7', 'gusion@gmail.com', '12345678', 4, NULL, 'student'),
(5, 'Argun', 'D', 'Cruz', '2002-10-10', 'Male', '5', 'dummy@gmail.com', '123456789', 1, 12, 'student'),
(6, 'qwe', 'q', 'qwe', '2002-1-1', 'Female', '1', 'q@gmail.com', '123456789', 2, 13, 'student'),
(7, 'dummy', 'dummy', 'dummy', '2001-1-1', 'Female', '4', 'dummy2@gmail.com', '12345678', 1, 14, 'student'),
(8, 'luiz', 'dela cruz', 'france', '2002-1-4', 'Male', '6', 'luiz@gmail.com', '12345678', 1, 15, 'student'),
(9, 'Alfred', 'Nasino', 'Dela Cruz', '2001-5-5', 'Male', '2', 'alfred@gmail.com', '12345678', 1, 16, 'student'),
(10, 'Mark', 'Cruz', 'Marquez', '2002-21-2', 'Male', '7', 'mark@gmail.com', '12345678', 2, 17, 'student'),
(11, 'Juan', 'Dela', 'Cruz', '2001-5-6', 'Male', '5', 'juan@gmail.com', '12345678', 1, 18, 'student'),
(12, 'dumy', 'dumy', 'dumy', '2001-6-7', 'Female', '1', 'dumy@gmail.com', '12345678', 2, 19, 'student'),
(13, 'juan', 'cruz', 'luna', '2002-07-14', 'Male', '7', 'juanluna@gmail.com', '12345678', 1, 20, 'student'),
(14, 'anthony', 'f', 'francisco', 'july 21 2002', 'Male', '5', 'francisco@gmail.com', 'qwe', 4, NULL, 'student');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`student_id`),
  ADD KEY `status_id` (`status_id`),
  ADD KEY `sub_id` (`sub_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `student_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `student_ibfk_1` FOREIGN KEY (`status_id`) REFERENCES `status` (`status_id`),
  ADD CONSTRAINT `student_ibfk_2` FOREIGN KEY (`sub_id`) REFERENCES `submission` (`sub_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
