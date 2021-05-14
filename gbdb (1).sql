-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 24, 2021 at 05:17 PM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gbdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `fundmanagement`
--

CREATE TABLE `fundmanagement` (
  `fid` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `address` varchar(200) NOT NULL,
  `fundAmount` double NOT NULL,
  `interestedCategory` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fundmanagement`
--

INSERT INTO `fundmanagement` (`fid`, `name`, `email`, `address`, `fundAmount`, `interestedCategory`) VALUES
(1, 'funder1', 'funder1@gmail.com', '345/6 wasalamawatha,kotte', 23000, 'science');

-- --------------------------------------------------------

--
-- Table structure for table `research`
--

CREATE TABLE `research` (
  `rid` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `projectTitle` varchar(200) NOT NULL,
  `totalCost` double NOT NULL,
  `duration` varchar(30) NOT NULL,
  `catogary` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `research`
--

INSERT INTO `research` (`rid`, `name`, `email`, `projectTitle`, `totalCost`, `duration`, `catogary`) VALUES
(1, 'Researcher1', 'Researcher1@gmail.com', 'New Tech ', 25000, '3months', 'science');

-- --------------------------------------------------------

--
-- Table structure for table `scholor`
--

CREATE TABLE `scholor` (
  `sid` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `approvedProjectTitle` varchar(200) NOT NULL,
  `approvedDate` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `scholor`
--

INSERT INTO `scholor` (`sid`, `name`, `email`, `approvedProjectTitle`, `approvedDate`) VALUES
(2, 'scholar3', 'scholar3@gmail.com', 'science for tech', '2020/2/4');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `userID` int(11) NOT NULL,
  `userName` varchar(30) NOT NULL,
  `userType` varchar(30) NOT NULL,
  `Password` varchar(30) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Phone` int(11) NOT NULL,
  `Address` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userID`, `userName`, `userType`, `Password`, `Email`, `Phone`, `Address`) VALUES
(1, 'Niradha', 'Researcher', '1234', 'nira123@gmail.com', 773312555, 'Kaduwela'),
(3, 'Nethmi', 'Buyer', '4321', 'nnimes@gmail.com', 785432444, 'Malabe');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `fundmanagement`
--
ALTER TABLE `fundmanagement`
  ADD PRIMARY KEY (`fid`);

--
-- Indexes for table `research`
--
ALTER TABLE `research`
  ADD PRIMARY KEY (`rid`);

--
-- Indexes for table `scholor`
--
ALTER TABLE `scholor`
  ADD PRIMARY KEY (`sid`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `fundmanagement`
--
ALTER TABLE `fundmanagement`
  MODIFY `fid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `research`
--
ALTER TABLE `research`
  MODIFY `rid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `scholor`
--
ALTER TABLE `scholor`
  MODIFY `sid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `userID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
