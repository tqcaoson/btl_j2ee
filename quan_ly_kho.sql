-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 20, 2021 lúc 04:24 PM
-- Phiên bản máy phục vụ: 10.4.14-MariaDB
-- Phiên bản PHP: 7.2.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `quan_ly_kho`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `export_product`
--

CREATE TABLE `export_product` (
  `id` int(10) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `code_sp` int(255) DEFAULT NULL,
  `price_out` int(18) DEFAULT NULL,
  `date_out` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `export_product`
--

INSERT INTO `export_product` (`id`, `code`, `code_sp`, `price_out`, `date_out`) VALUES
(5, '123', 123, 123, '2021-06-23'),
(6, '123', 123, 5678, '2021-06-22');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `import_product`
--

CREATE TABLE `import_product` (
  `id` int(10) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `code_sp` varchar(255) DEFAULT NULL,
  `price_in` int(18) DEFAULT NULL,
  `date_in` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `import_product`
--

INSERT INTO `import_product` (`id`, `code`, `code_sp`, `price_in`, `date_in`) VALUES
(2, '123', '123', 123, '2021-06-01');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `products`
--

CREATE TABLE `products` (
  `id` int(10) NOT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `number` int(10) DEFAULT NULL,
  `price_int` int(18) DEFAULT NULL,
  `price_out` int(18) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `products`
--

INSERT INTO `products` (`id`, `product_name`, `code`, `number`, `price_int`, `price_out`) VALUES
(1, '1234', '123', 123, 123, 123);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `export_product`
--
ALTER TABLE `export_product`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `import_product`
--
ALTER TABLE `import_product`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `export_product`
--
ALTER TABLE `export_product`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `import_product`
--
ALTER TABLE `import_product`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `products`
--
ALTER TABLE `products`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
