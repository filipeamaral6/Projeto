CREATE TABLE `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `full_name` varchar(255) NOT NULL,
  `nif` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `client_cc` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `phone_number` bigint(20) DEFAULT NULL,
  `mobile_number` bigint(20) DEFAULT NULL,
  `address` varchar(255) NOT NULL,
  `birthdate` date NOT NULL,
  `zip_code` varchar(100) NOT NULL,
  `county` varchar(100) NOT NULL,
  `country` varchar(255) NOT NULL,
  `nationality` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL DEFAULT 'ACTIVE',
  `notification` varchar(100) NOT NULL DEFAULT 'TRUE',
  `login_password` varchar(255) NOT NULL,
  `transaction_password` varchar(255) NOT NULL,
  `created_at` date NOT NULL DEFAULT curdate(),
  PRIMARY KEY (`id`),
  UNIQUE KEY `client_cc_un` (`client_cc`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
