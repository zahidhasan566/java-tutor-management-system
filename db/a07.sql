-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 17, 2018 at 02:36 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `a07`
--

-- --------------------------------------------------------

--
-- Table structure for table `assignedto`
--

CREATE TABLE `assignedto` (
  `Sid_sa` int(20) NOT NULL,
  `TID_ta` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `assignedto`
--

INSERT INTO `assignedto` (`Sid_sa`, `TID_ta`) VALUES
(1700, 1901),
(1700, 1902),
(1701, 1901),
(1702, 1903),
(1702, 1904);

-- --------------------------------------------------------

--
-- Table structure for table `choice`
--

CREATE TABLE `choice` (
  `Sid_sc` int(20) NOT NULL,
  `SubCode_sca` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `choice`
--

INSERT INTO `choice` (`Sid_sc`, `SubCode_sca`) VALUES
(1700, 101),
(1700, 102),
(1700, 103),
(1701, 102),
(1702, 101),
(1702, 102),
(1702, 103);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `UserId_ui` varchar(20) NOT NULL,
  `Password` int(20) NOT NULL,
  `Status` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`UserId_ui`, `Password`, `Status`) VALUES
('1001', 1234, 1),
('1700', 1234, 2),
('1701', 1657, 2),
('1702', 1234, 2),
('1900', 1234, 3),
('1901', 1234, 3),
('1902', 1639, 3),
('1903', 1234, 3),
('1904', 1249, 3),
('1905', 1071, 3);

-- --------------------------------------------------------

--
-- Table structure for table `preference`
--

CREATE TABLE `preference` (
  `IsMail` int(20) NOT NULL,
  `IsPhone` int(20) NOT NULL,
  `Tid_tp` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `preference`
--

INSERT INTO `preference` (`IsMail`, `IsPhone`, `Tid_tp`) VALUES
(1, 0, 1900),
(1, 0, 1901),
(1, 1, 1902),
(0, 1, 1903),
(1, 1, 1904),
(1, 1, 1905);

-- --------------------------------------------------------

--
-- Table structure for table `rating`
--

CREATE TABLE `rating` (
  `RateValue` double NOT NULL,
  `Sid_ra` int(20) NOT NULL,
  `TID_ra` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rating`
--

INSERT INTO `rating` (`RateValue`, `Sid_ra`, `TID_ra`) VALUES
(4, 1700, 1901),
(5, 1700, 1902),
(5, 1700, 1901),
(1, 1702, 1903),
(2, 1702, 1903),
(4, 1702, 1904);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `Sid_si` int(20) NOT NULL,
  `StudentName` varchar(20) NOT NULL,
  `PhoneNumber` int(20) NOT NULL,
  `Address` varchar(20) NOT NULL,
  `Budget` int(20) NOT NULL,
  `Grade` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`Sid_si`, `StudentName`, `PhoneNumber`, `Address`, `Budget`, `Grade`) VALUES
(1700, 'Noman', 8800171, 'Dhaka', 12000, 12),
(1701, 'Jasim', 6127621, 'Gopalgonj', 12000, 12),
(1702, 'vdygvaww', 472365, 'vhscv', 12000, 12);

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE `subject` (
  `SubName` varchar(20) NOT NULL,
  `SubCode_sc` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subject`
--

INSERT INTO `subject` (`SubName`, `SubCode_sc`) VALUES
('English', 101),
('Bangla', 102),
('Math', 103);

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE `teacher` (
  `TID_ti` int(20) NOT NULL,
  `TeacherName` varchar(20) NOT NULL,
  `PhoneNumber` int(20) NOT NULL,
  `Area` varchar(20) NOT NULL,
  `Subjectcode_aa` int(20) NOT NULL,
  `Wage` int(20) NOT NULL,
  `Mail` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`TID_ti`, `TeacherName`, `PhoneNumber`, `Area`, `Subjectcode_aa`, `Wage`, `Mail`) VALUES
(1900, 'Ishti', 880011111, 'Dhaka', 101, 12000, 'ishtu@gmail.com'),
(1901, 'Kafi', 999999, 'Dhaka', 102, 11000, 'bahsb@gmail.com'),
(1902, 'kali', 8888888, 'Dhaka', 103, 11000, 'asdcb@gmail.com'),
(1903, 'Jahid', 12321, 'Dhaka', 101, 11500, 'bab@gmail.com'),
(1904, 'opo', 2734846, 'Dhaka', 102, 12000, 'hdcb@jgmail.com'),
(1905, 'djbwq', 23423423, 'afdcasc', 101, 112222, 'dfs@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `assignedto`
--
ALTER TABLE `assignedto`
  ADD KEY `Sid_sa` (`Sid_sa`),
  ADD KEY `TID_ta` (`TID_ta`);

--
-- Indexes for table `choice`
--
ALTER TABLE `choice`
  ADD KEY `SubCode_sc` (`SubCode_sca`),
  ADD KEY `Sid_sc` (`Sid_sc`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`UserId_ui`),
  ADD UNIQUE KEY `UserId` (`UserId_ui`);

--
-- Indexes for table `preference`
--
ALTER TABLE `preference`
  ADD KEY `Tid_tp` (`Tid_tp`),
  ADD KEY `Tid_tp_2` (`Tid_tp`);

--
-- Indexes for table `rating`
--
ALTER TABLE `rating`
  ADD KEY `Sid_ra` (`Sid_ra`),
  ADD KEY `Sid_ra_2` (`Sid_ra`),
  ADD KEY `TID_ra` (`TID_ra`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`Sid_si`);

--
-- Indexes for table `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`SubCode_sc`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`TID_ti`),
  ADD KEY `Subjectcode_aa` (`Subjectcode_aa`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `choice`
--
ALTER TABLE `choice`
  ADD CONSTRAINT `choice_ibfk_1` FOREIGN KEY (`SubCode_sca`) REFERENCES `subject` (`SubCode_sc`),
  ADD CONSTRAINT `choice_ibfk_2` FOREIGN KEY (`Sid_sc`) REFERENCES `student` (`Sid_si`);

--
-- Constraints for table `rating`
--
ALTER TABLE `rating`
  ADD CONSTRAINT `rating_ibfk_1` FOREIGN KEY (`Sid_ra`) REFERENCES `student` (`Sid_si`),
  ADD CONSTRAINT `rating_ibfk_2` FOREIGN KEY (`TID_ra`) REFERENCES `teacher` (`TID_ti`);

--
-- Constraints for table `teacher`
--
ALTER TABLE `teacher`
  ADD CONSTRAINT `teacher_ibfk_1` FOREIGN KEY (`Subjectcode_aa`) REFERENCES `subject` (`SubCode_sc`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
