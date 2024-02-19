-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2024 at 11:31 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `jean_nepomuscene_iradukunda_stock_mgt_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `fname` varchar(50) DEFAULT NULL,
  `lname` varchar(50) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `gender` varchar(25) DEFAULT NULL,
  `martial_status` varchar(20) DEFAULT NULL,
  `DoB` varchar(90) DEFAULT NULL,
  `email` varchar(120) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`fname`, `lname`, `phone`, `gender`, `martial_status`, `DoB`, `email`, `password`) VALUES
('Iradukunda', 'Jnepo', '0737254565', 'Male', 'Engaged', '2000', 'nepoirad@gmail', '12345'),
('angel', 'niyori', '0789654323', 'Female', 'single', '2001', 'niyoangel@gmail.com', '4444'),
('ishimwe', 'diane', '0789654323', 'Female', 'married', '1998', 'ishimwedne@gmail.com', 'diane'),
('mutesi', 'naome', '0789888889', 'Female', 'single', '2000', 'mutsname@gmail.com', '1234'),
('olivie', 'tuyisenge', '0789898989', 'Male', 'single', '2002/06/08', 'tuyolivie@gmail.com', 'p09'),
('Zahabu', 'keza', '0733344432', 'Female', 'single', '2000', 'kezahabu@gmail.com', '45454'),
('', '', '', 'Male', '', '', '', ''),
('mizero', 'angel', '0732323445', 'Female', 'maried', '2006', 'mizeroangl@gmail.com', 'gaga'),
('fifi', 'ange', '0898989', 'Female', 'single', '2003', 'fifi@gmail.com', 'bb'),
('rebeka', 'tuyise', '072323333', 'Female', 'single', '1996', 'rebk@gmail.com', '4545'),
('fidelitte', 'uwimana', '072334344', 'Female', 'engaged', '2003', 'fidelitt@gmail.com', '0909'),
('', '', '', 'Male', '', '1990', '', ''),
('', '', '', 'Male', '', '1990', '', ''),
('', '', '', 'Male', '', '1990', '', ''),
('', '', '', 'Male', '', '1990', '', ''),
('', '', '', 'Male', '', '1990', '', ''),
('', '', '', 'Male', '', '1990', '', ''),
('', '', '', 'Male', '', '1990', '', ''),
('', '', '', 'Male', '', '1990', '', ''),
('', '', '', 'Male', '', '1990', '', ''),
('', '', '', 'Male', 'Engaged', NULL, '', ''),
('', '', '', 'Male', 'Single', NULL, '', '');

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `Customer_Id` int(11) NOT NULL,
  `Product_Id` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Phone_Number` varchar(10) NOT NULL,
  `Gender` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`Customer_Id`, `Product_Id`, `Name`, `Email`, `Phone_Number`, `Gender`) VALUES
(10, 15, 'Emmy', 'emmy@gmail.com', '0722224332', 'Male'),
(11, 14, 'Denyse', 'denyse@gmail.com', '0794323118', 'Male'),
(13, 15, 'Betty', 'betty@gmail.com', '0783212433', 'Female'),
(14, 7, 'kanengwa', 'kaneg@gmail.com', '078988889', 'Female'),
(16, 15, 'mutesi', 'mutesi@gmail.com', '0723232323', 'Female'),
(19, 7, 'ghjk', 'uhj', '89o', 'Male');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `Order_Id` int(11) NOT NULL,
  `Customer_Id` int(11) NOT NULL,
  `Order_Date` date NOT NULL,
  `Total_Amount` varchar(20) NOT NULL,
  `Order_Status` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`Order_Id`, `Customer_Id`, `Order_Date`, `Total_Amount`, `Order_Status`) VALUES
(2, 16, '2023-11-10', '5000F', 'Pending'),
(3, 14, '2023-07-09', '100k', 'Stock Adjustment'),
(4, 10, '2023-05-02', '500k', 'packing');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `Product_Id` int(11) NOT NULL,
  `Product_Name` varchar(100) DEFAULT NULL,
  `Product_Description` varchar(234) DEFAULT NULL,
  `Product_Price` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`Product_Id`, `Product_Name`, `Product_Description`, `Product_Price`) VALUES
(7, 'telephone', 'technology device to call and communicating with people', '1,000,000'),
(14, 'Smartphone', '\'A smartphone with a high-resolution display and a power camera ', '500,000FRW'),
(15, 'Desktop', 'Electronic device used to store data', '500K'),
(16, 'mouse', 'A precision mouse fpr accurate cursor control ', '5000FRW'),
(17, 'Printer', 'Is device to printing papers', '34'),
(19, 'Maize', 'Ia food', '100FRW');

-- --------------------------------------------------------

--
-- Table structure for table `stock_transaction`
--

CREATE TABLE `stock_transaction` (
  `Stock_Transaction_Id` int(11) NOT NULL,
  `Product_Id` int(11) NOT NULL,
  `Transaction_Type` varchar(60) NOT NULL,
  `Quantity` varchar(15) DEFAULT NULL,
  `Transaction_Date` varchar(35) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `stock_transaction`
--

INSERT INTO `stock_transaction` (`Stock_Transaction_Id`, `Product_Id`, `Transaction_Type`, `Quantity`, `Transaction_Date`) VALUES
(1, 7, 'Supplier Invoice', '34kg', '2023-01-01'),
(2, 14, 'Adjustment', '95Kg', '2023-05-05'),
(3, 16, 'Purchase', '100Kg', '2021-12-31'),
(5, 19, 'Purchasing products', '500kg', '2024-11-12');

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `Supplier_Id` int(11) NOT NULL,
  `Product_Id` int(11) NOT NULL,
  `Supplier_Name` varchar(50) NOT NULL,
  `Supplier_Address` varchar(235) NOT NULL,
  `Supplier_Contact` varchar(25) NOT NULL,
  `Gender` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`Supplier_Id`, `Product_Id`, `Supplier_Name`, `Supplier_Address`, `Supplier_Contact`, `Gender`) VALUES
(1, 16, 'Gakuru', 'Kigali', '0789999993', 'Female'),
(5, 7, 'Macka', 'Nyamirambo', '0732323232', 'Male'),
(6, 16, 'Theogene', 'Karongi', '0732221114', 'Male'),
(7, 7, 'FGH', 'HGF', '78', 'Male'),
(18, 16, 'Claude', 'Gatsibo', '0799997666', 'Male');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`Customer_Id`),
  ADD KEY `Product_Id` (`Product_Id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`Order_Id`),
  ADD KEY `Customer_Id` (`Customer_Id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`Product_Id`);

--
-- Indexes for table `stock_transaction`
--
ALTER TABLE `stock_transaction`
  ADD PRIMARY KEY (`Stock_Transaction_Id`),
  ADD KEY `Product_Id` (`Product_Id`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`Supplier_Id`),
  ADD KEY `Product_Id` (`Product_Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customers`
--
ALTER TABLE `customers`
  MODIFY `Customer_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `Order_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `Product_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `stock_transaction`
--
ALTER TABLE `stock_transaction`
  MODIFY `Stock_Transaction_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `Supplier_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `customers`
--
ALTER TABLE `customers`
  ADD CONSTRAINT `customers_ibfk_1` FOREIGN KEY (`Product_Id`) REFERENCES `product` (`Product_Id`);

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`Customer_Id`) REFERENCES `customers` (`Customer_Id`);

--
-- Constraints for table `stock_transaction`
--
ALTER TABLE `stock_transaction`
  ADD CONSTRAINT `stock_transaction_ibfk_1` FOREIGN KEY (`Product_Id`) REFERENCES `product` (`Product_Id`);

--
-- Constraints for table `supplier`
--
ALTER TABLE `supplier`
  ADD CONSTRAINT `supplier_ibfk_1` FOREIGN KEY (`Product_Id`) REFERENCES `product` (`Product_Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
