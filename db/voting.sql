-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.26 - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for voting
CREATE DATABASE IF NOT EXISTS `voting` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `voting`;

-- Dumping structure for table voting.candidate
CREATE TABLE IF NOT EXISTS `candidate` (
  `Id` varchar(50) NOT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `Party` varchar(50) DEFAULT NULL,
  `Votes` varchar(10000) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table voting.candidate: 6 rows
DELETE FROM `candidate`;
/*!40000 ALTER TABLE `candidate` DISABLE KEYS */;
INSERT INTO `candidate` (`Id`, `Name`, `Party`, `Votes`) VALUES
	('05', 'Lokesh Kumar', 'LKSH', '0'),
	('01', 'Rahul Yadav', 'ABVP', '0'),
	('04', 'Tarunveer Singh Sekhawat', 'TVSS', '0'),
	('03', 'Vikas Choudahry', 'VCBJ', '0'),
	('02', 'Pooja Meena', 'NSUI', '0'),
	('06', 'Priyanshu Sharma', 'DCBF', '0');
/*!40000 ALTER TABLE `candidate` ENABLE KEYS */;

-- Dumping structure for table voting.registration
CREATE TABLE IF NOT EXISTS `registration` (
  `Name` varchar(50) DEFAULT NULL,
  `Rollno` varchar(50) NOT NULL,
  `Id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Rollno`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table voting.registration: 2 rows
DELETE FROM `registration`;
/*!40000 ALTER TABLE `registration` DISABLE KEYS */;
INSERT INTO `registration` (`Name`, `Rollno`, `Id`) VALUES
	('Mohit', '379', 'BCA777'),
	('Neel', '963', 'BSC789');
/*!40000 ALTER TABLE `registration` ENABLE KEYS */;

-- Dumping structure for table voting.voters
CREATE TABLE IF NOT EXISTS `voters` (
  `Name` varchar(50) DEFAULT NULL,
  `Id` varchar(50) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table voting.voters: 0 rows
DELETE FROM `voters`;
/*!40000 ALTER TABLE `voters` DISABLE KEYS */;
/*!40000 ALTER TABLE `voters` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
